package lv.v3nom.DI;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DIContainerImpl implements DIContainer {
    Map<Class<?>, Class<?>> dependencies = new HashMap<>();

    public <T> void register(Class<T> abstraction, Class<? extends T> implementation) {
        dependencies.put(abstraction, implementation);
    }

    public <T> T resolve(Class<T> type) {
        return resolveWithTracking(type, new HashSet<>());
    }

    private <T> T resolveWithTracking(Class<T> type, Set<Class<?>> resolvingStack) {
        if (resolvingStack.contains(type)) {
            throw new IllegalStateException(
                    "ERR: Circular dependency, path: " +
                            buildCircularPath(resolvingStack, type)
            );
        }

        resolvingStack.add(type);

        try {
            Class<?> implementation = dependencies.get(type);

            if (implementation == null) {
                implementation = type;
            }

            Constructor[] constructors = implementation.getDeclaredConstructors();
            Constructor<?> targetConstructor = constructors[0];

            for (Constructor<?> c : constructors) {
                if (c.getParameterCount() > targetConstructor.getParameterCount()) {
                    targetConstructor = c;
                }
            }

            targetConstructor.setAccessible(true);

            Class<?>[] targetConstructorParams = targetConstructor.getParameterTypes();
            Object[] dependencyInstances = new Object[targetConstructorParams.length];

            for (int i = 0; i < targetConstructorParams.length; i++) {
                dependencyInstances[i] = resolveWithTracking(targetConstructorParams[i], resolvingStack);
            }

            T instance = (T) targetConstructor.newInstance(dependencyInstances);
            resolvingStack.remove(type);
            targetConstructor.setAccessible(false);

            return instance;

        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to create instance of " + type.getName(), e);
        }
    }

    private String buildCircularPath(Set<Class<?>> resolvingStack, Class<?> circularType) {
        StringBuilder path = new StringBuilder();

        for (Class<?> clazz : resolvingStack) {
            path.append(clazz.getSimpleName()).append(" -> ");
        }
        path.append(circularType.getSimpleName());

        return path.toString();
    }
}

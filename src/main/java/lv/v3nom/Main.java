package lv.v3nom;

import lv.v3nom.DI.DIContainer;
import lv.v3nom.DI.DIContainerImpl;
import lv.v3nom.test_environment.vechile_part_types.Battery;
import lv.v3nom.test_environment.vechile_part_types.Brakes;
import lv.v3nom.test_environment.vechile_part_types.Engine;
import lv.v3nom.test_environment.vechile_part_types.Transmission;
import lv.v3nom.test_environment.vechile_parts.BatteryLithium_Impl;
import lv.v3nom.test_environment.vechile_parts.Brakes_Impl;
import lv.v3nom.test_environment.vechile_parts.EngineElectric_Impl;
import lv.v3nom.test_environment.vechile_parts.TransmissionAuto_Impl;
import lv.v3nom.test_environment.vechile_parts.part_details.Bolt;
import lv.v3nom.test_environment.vechile_parts.part_details.Valve;
import lv.v3nom.test_environment.vechile_parts.part_details.Wiring;
import lv.v3nom.test_environment.vehicle.Car;

public class Main {
    static void main() {
        DIContainer container = new DIContainerImpl();

        container.register(Battery.class, BatteryLithium_Impl.class);
        container.register(Brakes.class, Brakes_Impl.class);
        container.register(Engine.class, EngineElectric_Impl.class);
        container.register(Transmission.class, TransmissionAuto_Impl.class);
        container.register(Bolt.class, Bolt.class);
        container.register(Valve.class, Valve.class);
        container.register(Wiring.class, Wiring.class);

        Car car = container.resolve(Car.class);

        car.drive();
    }
}

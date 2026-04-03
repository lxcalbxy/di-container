package lv.v3nom.test_environment.vehicle;

import lv.v3nom.test_environment.vechile_part_types.Battery;
import lv.v3nom.test_environment.vechile_part_types.Brakes;
import lv.v3nom.test_environment.vechile_part_types.Engine;
import lv.v3nom.test_environment.vechile_part_types.Transmission;

public class Car {
    private final Battery battery;
    private final Brakes brakes;
    private final Engine engine;
    private final Transmission transmission;

    public Car(Battery battery, Brakes brakes, Engine engine, Transmission transmission) {
        this.battery = battery;
        this.brakes = brakes;
        this.engine = engine;
        this.transmission = transmission;
    }

    public void drive() {
        battery.turnOn();
        brakes.enable();
        engine.start();
        transmission.shiftGear();
        System.out.println("Functioning: Car (Is driving)");
    }
}

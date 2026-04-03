package lv.v3nom.test_environment.vechile_parts;

import lv.v3nom.test_environment.vechile_part_types.Battery;
import lv.v3nom.test_environment.vechile_parts.part_details.Wiring;

public class BatteryLithium_Impl implements Battery {
    private final Wiring wiring;

    public BatteryLithium_Impl(Wiring wiring) {
        this.wiring = wiring;
    }

    public void turnOn() {
        System.out.println(String.format("Battery: wiring #%s", wiring.sid));
        System.out.println("Functioning: Battery (Lithium)");
    }
}

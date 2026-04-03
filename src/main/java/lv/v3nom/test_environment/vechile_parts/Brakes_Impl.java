package lv.v3nom.test_environment.vechile_parts;

import lv.v3nom.test_environment.vechile_part_types.Brakes;
import lv.v3nom.test_environment.vechile_parts.part_details.Bolt;
import lv.v3nom.test_environment.vechile_parts.part_details.Valve;
import lv.v3nom.test_environment.vechile_parts.part_details.Wiring;

public class Brakes_Impl implements Brakes {
    private final Bolt bolt;
    private final Wiring wiring;

    public Brakes_Impl(Bolt bolt, Wiring wiring) {
        this.bolt = bolt;
        this.wiring = wiring;
    }

    public void enable() {
        System.out.println(String.format("Breaks: bolt #%s", bolt.sid));
        System.out.println(String.format("Breaks: wiring #%s", wiring.sid));
        System.out.println("Functioning: Breaks");
    }
}

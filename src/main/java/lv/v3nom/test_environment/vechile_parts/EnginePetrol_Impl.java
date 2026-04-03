package lv.v3nom.test_environment.vechile_parts;

import lv.v3nom.test_environment.vechile_part_types.Engine;
import lv.v3nom.test_environment.vechile_parts.part_details.Bolt;
import lv.v3nom.test_environment.vechile_parts.part_details.Wiring;

public class EnginePetrol_Impl implements Engine {
    private final Bolt bolt;
    private final Wiring wiring;

    public EnginePetrol_Impl(Bolt bolt, Wiring wiring) {
        this.bolt = bolt;
        this.wiring = wiring;
    }

    public void start() {
        System.out.println(String.format("Engine: bolt #%s", bolt.sid));
        System.out.println(String.format("Engine: wiring #%s", wiring.sid));
        System.out.println("Functioning: Engine (Petrol)");
    }
}

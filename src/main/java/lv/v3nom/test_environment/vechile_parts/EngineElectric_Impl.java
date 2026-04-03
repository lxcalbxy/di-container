package lv.v3nom.test_environment.vechile_parts;

import lv.v3nom.test_environment.vechile_part_types.Battery;
import lv.v3nom.test_environment.vechile_part_types.Engine;
import lv.v3nom.test_environment.vechile_parts.part_details.Valve;
import lv.v3nom.test_environment.vechile_parts.part_details.Wiring;

public class EngineElectric_Impl implements Engine {
    private final Valve valve;
    private final Wiring wiring;
    private final Battery battery;

    public EngineElectric_Impl(Valve valve, Wiring wiring, Battery battery) {
        this.valve = valve;
        this.wiring = wiring;
        this.battery = battery;
    }

    public void start() {
        System.out.println(String.format("Engine: valve #%s", valve.sid));
        System.out.println(String.format("Engine: wiring #%s", wiring.sid));
        System.out.println("Functioning: Engine (Electric)");
    }
}

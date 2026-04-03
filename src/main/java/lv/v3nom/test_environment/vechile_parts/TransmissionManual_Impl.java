package lv.v3nom.test_environment.vechile_parts;

import lv.v3nom.test_environment.vechile_part_types.Transmission;
import lv.v3nom.test_environment.vechile_parts.part_details.Bolt;

public class TransmissionManual_Impl implements Transmission {
    private final Bolt bolt;

    public TransmissionManual_Impl(Bolt bolt) {
        this.bolt = bolt;
    }

    public void shiftGear() {
        System.out.println(String.format("Transmission: bolt #%s", bolt.sid));
        System.out.println("Functioning: Transmission (Manual)");
    }
}

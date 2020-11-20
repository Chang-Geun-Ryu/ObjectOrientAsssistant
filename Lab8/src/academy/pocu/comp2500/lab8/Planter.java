package academy.pocu.comp2500.lab8;

import java.util.ArrayList;

public class Planter {
    private static final int WATER_CONSUME_PER_TICK = 2;
    private int waterAmount;
    private final ArrayList<SmartDevice> smartDevices;

    public Planter(int waterAmount) {
        this.waterAmount = waterAmount;
        smartDevices = new ArrayList<>();
    }

    public int getWaterAmount() {
        return waterAmount;
    }

    public void installSmartDevice(SmartDevice smartDevice) {
        this.smartDevices.add(smartDevice);
    }

    public void tick() {

        for (SmartDevice smartDevice : smartDevices) {
            if (smartDevice.geteSmartDeviceType() == ESmartDeviceType.DRAINER) {
                Drainer drainer = (Drainer) smartDevice;
                drainer.detect(waterAmount);
            }
        }

        for (SmartDevice smartDevice : smartDevices) {
            switch (smartDevice.geteSmartDeviceType()) {
                case DRAINER:
                    Drainer drainer = (Drainer) smartDevice;
                    drainer.drain(this);
                    break;

                case SPRINKER:
                    Sprinkler sprinkler = (Sprinkler) smartDevice;
                    sprinkler.spray(this);
                    break;

                default:
                    assert false;
                    break;
            }
        }

        if (waterAmount > 0) {
            waterAmount = Math.max(waterAmount - WATER_CONSUME_PER_TICK, 0);
        }
    }

    public void addWaterAmount(int waterAmount) {
        this.waterAmount += waterAmount;
    }

    public void removeWaterAmount(int waterAmount) {
        this.waterAmount = Math.max(this.waterAmount - waterAmount, 0);
    }
}

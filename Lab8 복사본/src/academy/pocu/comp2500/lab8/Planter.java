package academy.pocu.comp2500.lab8;

import java.util.ArrayList;

public class Planter {
    private int waterAmount;
    private ArrayList<SmartDevice> smartDevices;

    public Planter(final int waterAmount) {
        this.waterAmount = waterAmount;
        this.smartDevices = new ArrayList<>();
    }

    public int getWaterAmount() {
        return this.waterAmount;
    }

    public void setWaterAmount(final int waterAmount) {
        this.waterAmount = waterAmount;
    }

    public void increaseWaterAmount(int waterAmount) {
        this.waterAmount += waterAmount;
    }

    public void decreaseAmount(final int waterAmount) {
        if (this.waterAmount < waterAmount) {
            this.waterAmount = 0;
        } else {
            this.waterAmount -= waterAmount;
        }
    }

    public void installSmartDevice(final SmartDevice smartDevice) {
        this.smartDevices.add(smartDevice);
    }

    public void tick() {
        for (SmartDevice device : this.smartDevices) {
            device.onTick();
            if (device.getType() == SmartDevice.DeviceType.DRAINER) {
                Drainer drainer = (Drainer) device;
                drainer.detect(this.waterAmount);
            }
        }

        for (SmartDevice device : this.smartDevices) {
            if (device.isOn()) {
                switch (device.getType()) {
                    case SPRINKLER:
                        Sprinkler sprinkler = (Sprinkler) device;
                        sprinkler.spray(this);
                        break;
                    case DRAINER:
                        Drainer drainer = (Drainer) device;
                        drainer.drain(this);
                        break;
                }
            }
        }

        this.waterAmount = Math.max(0, this.waterAmount - 2);
    }
}

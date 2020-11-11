package academy.pocu.comp2500.lab8;

import java.util.ArrayList;

public class Planter {
    private int waterAmount;
    private ArrayList<SmartDevice> smartDevices;
    private ArrayList<ISprayable> sprayables;
    private ArrayList<IDrainable> drainables;
    private ArrayList<IWaterDetectable> waterDetectables;

    public Planter(final int waterAmount) {
        this.waterAmount = waterAmount;
        this.smartDevices = new ArrayList<>();
        this.sprayables = new ArrayList<>();
        this.drainables = new ArrayList<>();
        this.waterDetectables = new ArrayList<>();
    }

    public int getWaterAmount() {
        return this.waterAmount;
    }

    public void setWaterAmount(final int waterAmount) {
        this.waterAmount = waterAmount;
    }

    public void installSmartDevice(final SmartDevice smartDevice) {
        this.smartDevices.add(smartDevice);
    }

    public void tick() {
        for (SmartDevice device : this.smartDevices) {
            device.onTick();
//            if (device.getType() == SmartDevice.DeviceType.DRAINER) {
//                Drainer drainer = (Drainer) device;
//                drainer.detect(this.waterAmount);
//            }
            if (device.getDeviceKind() == SmartDevice.DeviceType.SPRINKLER) {
                this.sprayables.add((ISprayable) device);
            } else if (device.getDeviceKind() == SmartDevice.DeviceType.DRAINER) {
                this.waterDetectables.add((IWaterDetectable) device);
                this.drainables.add((IDrainable) device);
            }
        }

        for (IWaterDetectable device : this.waterDetectables) {
            device.detect(this.getWaterAmount());
        }

        for (ISprayable device : this.sprayables) {
            device.spray(this);
        }

        for (IDrainable device : this.drainables) {
            device.drain(this);
        }
//        for (SmartDevice device : this.smartDevices) {
//            if (device.isOn()) {
//                switch (device.getType()) {
//                    case SPRINKLER:
//                        Sprinkler sprinkler = (Sprinkler) device;
//                        sprinkler.spray(this);
//                        break;
//                    case DRAINER:
//                        Drainer drainer = (Drainer) device;
//                        drainer.drain(this);
//                        break;
//                }
//            }
//        }

        if (this.waterAmount < 2) {
            this.waterAmount = 0;
        } else {
            this.waterAmount -= 2;
        }

        this.waterDetectables.clear();
        this.sprayables.clear();
        this.drainables.clear();
    }
}

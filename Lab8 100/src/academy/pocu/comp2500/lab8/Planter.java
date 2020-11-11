package academy.pocu.comp2500.lab8;

import java.util.ArrayList;

public class Planter {

    private int waterAmount;
    private int tics;
    private ArrayList<SmartDevice> smartDevices;
    private ArrayList<ISprayable> sprayables;
    private ArrayList<IDrainable> drainables;
    private ArrayList<IWaterDetectable> waterDetectables;

    private final int CONSUMED_WATER = 2;


    public Planter(int waterAmount) {
        this.waterAmount = waterAmount;
        this.tics = 0;
        this.smartDevices = new ArrayList<>();
        this.sprayables = new ArrayList<>();
        this.drainables = new ArrayList<>();
        this.waterDetectables = new ArrayList<>();
    }

    public int getWaterAmount() {
        return this.waterAmount;
    }
    public void increaseWaterAmount(int waterAmount) {
        this.waterAmount += waterAmount;
    }
    public void decreaseWaterAmount(int waterAmount) {
        if (this.waterAmount < waterAmount) {
            this.waterAmount = 0;
        } else {
            this.waterAmount -= waterAmount;
        }
    }

    public void installSmartDevice(SmartDevice smartDevice) {
        this.smartDevices.add(smartDevice);
    }

    public ArrayList<IWaterDetectable> getWaterDetectables() {
        return this.waterDetectables;
    }

    public ArrayList<ISprayable> getSprayables() {
        return this.sprayables;
    }

    public ArrayList<IDrainable> getDrainables() {
        return this.drainables;
    }

    public int getTics() {
        return tics;
    }

    public void tick() {
        for (SmartDevice device : smartDevices) {
            device.onTick();
            if (device.getDeviceKind() == EDeviceKind.SPRINKLER) {
                this.sprayables.add((ISprayable) device);
            } else if (device.getDeviceKind() == EDeviceKind.DRAINER) {
                this.waterDetectables.add((IWaterDetectable) device);
                this.drainables.add((IDrainable) device);
            }
        }

        for (IWaterDetectable device : this.getWaterDetectables()) {
            device.detect(this.getWaterAmount());
        }

        for (ISprayable device : this.getSprayables()) {
            device.spray(this);
        }

        for (IDrainable device : this.getDrainables()) {
            device.drain(this);
        }
        this.decreaseWaterAmount(this.CONSUMED_WATER);

        this.getSprayables().clear();
        this.getDrainables().clear();
        this.getWaterDetectables().clear();
    }

}

package academy.pocu.comp2500.lab8;

import java.util.ArrayList;

public class Planter {
    private final int USE_WATER = 2;
    private int waterAmount;
    private ArrayList<Sprinkler> sprayableDevices;
    private ArrayList<Drainer> drainableDevices;
    private ArrayList<IWaterDetectable> waterDetectables;

    private ISprayable sprayableCallBack = null;

    public Planter(int waterAmount) {
        this.waterAmount = waterAmount;
        this.sprayableDevices = new ArrayList<>();
        this.drainableDevices = new ArrayList<>();
        this.waterDetectables = new ArrayList<>();
    }

    public void setSprayableCallBack(ISprayable sprayable) {
        this.sprayableCallBack = sprayable;
    }

    public int getWaterAmount() {
        return this.waterAmount;
    }

    public void installSmartDevice(SmartDevice device) {
        device.addInstall(this);
    }

    public void installSprinkler(Sprinkler s) {
        this.sprayableDevices.add(s);
    }

    public void installDrainer(Drainer d) {
        this.drainableDevices.add(d);
    }

    public void addDetect(IWaterDetectable detectable) {
        this.waterDetectables.add(detectable);
    }

    public void sprayWater(int watarLevel) {
        this.waterAmount += watarLevel;
    }

    public void drainWater(int waterLevel) {
        this.waterAmount -= waterLevel;
    }

    public void tick() {
        for (IWaterDetectable iWaterDetectable : this.waterDetectables) {
            iWaterDetectable.detect(this.waterAmount);
        }

        for (Drainer d : this.drainableDevices) {
            d.onTick();
            d.drain(this);
        }

        for (Sprinkler s : this.sprayableDevices) {
            s.onTick();
            s.spray(this);
        }



        this.waterAmount = this.waterAmount - USE_WATER >= 0 ? this.waterAmount - USE_WATER : 0;
    }
}

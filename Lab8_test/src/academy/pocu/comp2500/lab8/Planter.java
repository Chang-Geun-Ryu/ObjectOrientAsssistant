package academy.pocu.comp2500.lab8;

import java.util.ArrayList;

public class Planter {
    private static final int AMOUNT_OF_WATER_CONSUMING_PER_TICK_IN_LITRE = 2;
    private int waterAmount;
    //private ArrayList<SmartDevice> listOfSmartDevices;
    private ArrayList<Drainer> drainers;
    private ArrayList<Sprinkler> sprinklers;

    public Planter(int waterAmount) {
        this.waterAmount = waterAmount;
        //listOfSmartDevices = new ArrayList<SmartDevice>();
        drainers = new ArrayList<>();
        sprinklers = new ArrayList<>();
    }

    public int getWaterAmount() {
        return this.waterAmount;
    }

    public void sprayWater(int amountOfWaterSprayingInLitre) {
        waterAmount += amountOfWaterSprayingInLitre;
    }

    public void drainWater(int amountOfWaterDrainingInLitre) {
        waterAmount = Math.max(0, waterAmount - amountOfWaterDrainingInLitre);
    }

    public void installSmartDevice(SmartDevice smartDevice) {
        //listOfSmartDevices.add(smartDevice);
        if (smartDevice.smartDeviceType == SmartDeviceType.DRAINER) {
            drainers.add((Drainer) smartDevice);
        } else {
            sprinklers.add((Sprinkler) smartDevice);
        }
    }

    public void tick() {
        for (int i = 0; i < drainers.size(); ++i) {
            Drainer drainer = drainers.get(i);
            drainer.onTick();
            IWaterDetectable iWaterDetectable = (IWaterDetectable) drainer;
            iWaterDetectable.detect(this.waterAmount);
//            if (drainer.isOn()) {
//                IDrainable iDrainable = (IDrainable) drainer;
//                iDrainable.drain(this);
//            }
        }

        for (int i = 0; i < sprinklers.size(); ++i) {
            Sprinkler sprinkler = sprinklers.get(i);
            sprinkler.onTick();
            ISprayable iSprayable = (ISprayable) sprinkler;
            if (sprinkler.isOn()) {
                iSprayable.spray(this);
            }
        }

        for (int i = 0; i < drainers.size(); ++i) {
            Drainer drainer = drainers.get(i);
            if (drainer.isOn()) {
                IDrainable iDrainable = (IDrainable) drainer;
                iDrainable.drain(this);
            }
        }

        this.waterAmount = Math.max(waterAmount - AMOUNT_OF_WATER_CONSUMING_PER_TICK_IN_LITRE, 0);
        /*for (int i = 0; i < listOfSmartDevices.size(); ++i) {
            SmartDevice currentDevice = listOfSmartDevices.get(i);
            currentDevice.onTick();
            if (currentDevice.smartDeviceType == SmartDeviceType.DRAINER) {
                Drainer drainer = (Drainer) currentDevice;
*//*                if (drainer.isJustChanged()) {
                    drainer.executeWhenIsChanged();
                }*//*
                IWaterDetectable iWaterDetectable = (IWaterDetectable) drainer;
                iWaterDetectable.detect(this.waterAmount);
                if (drainer.isOn()) {
                    IDrainable iDrainable = (IDrainable) drainer;
                    iDrainable.drain(this);
                }
            } else {
                Sprinkler sprinkler = (Sprinkler) currentDevice;
                ISprayable sprayable = (ISprayable) currentDevice;
                if (sprinkler.isOn()) {
                    sprayable.spray(this);
                }
            }
        }
        this.waterAmount = Math.max(waterAmount - AMOUNT_OF_WATER_CONSUMING_PER_TICK_IN_LITRE, 0);*/
    }

}

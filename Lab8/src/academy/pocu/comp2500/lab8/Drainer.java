package academy.pocu.comp2500.lab8;

public class Drainer extends SmartDevice implements IWaterDetectable, IDrainable {
    private final int waterGage;
    private final static int DRAIN_AMOUNT_PER_TICK = 7;

    public Drainer(int waterGage) {
        this.waterGage = waterGage;
        this.eSmartDeviceType = ESmartDeviceType.DRAINER;
    }

    @Override
    public void onTick() {
        if (preDeviceState == isOn) {
            currentTick++;
        } else {
            currentTick = 0;
        }
    }

    @Override
    public int getTicksSinceLastUpdate() {
        return currentTick;
    }

    @Override
    public void detect(int waterLevel) {
        preDeviceState = isOn;
        isOn = waterLevel >= waterGage;
    }

    @Override
    public void drain(Planter planter) {
        if (isOn) {
            planter.removeWaterAmount(DRAIN_AMOUNT_PER_TICK);
        }
        onTick();
    }
}

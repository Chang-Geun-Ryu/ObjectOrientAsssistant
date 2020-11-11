package academy.pocu.comp2500.lab8;

public class Drainer extends SmartDevice implements IWaterDetectable, IDrainable {
    private final int triggerLevel;

    public Drainer(int triggerLevel) {
        super();
        super.type = DeviceType.DRAINER;
        this.triggerLevel = triggerLevel;
    }

    @Override
    public void detect(final int waterLevel) {
        boolean activator = waterLevel >= this.triggerLevel;
        if (activator ^ this.isOn) {
            super.activateOrDeactivate(activator);
        }
    }

    @Override
    public void drain(Planter planter) {
        planter.decreaseAmount(7);
    }

    @Override
    public void onTick() {
        super.currentTick += 1;
    }
}

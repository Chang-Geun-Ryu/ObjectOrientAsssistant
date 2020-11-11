package academy.pocu.comp2500.lab8;

public class Drainer extends SmartDevice implements IWaterDetectable, IDrainable {
    private final int triggerLevel;

    public Drainer(int triggerLevel) {
        super(DeviceType.DRAINER);
//        super.type = DeviceType.DRAINER;
        this.triggerLevel = triggerLevel;
    }

    @Override
    public void detect(final int waterLevel) {
//        boolean activator = waterLevel >= this.triggerLevel;
//        if (activator ^ this.isOn) {
//            super.activateOrDeactivate(activator);
//        }
        if (this.triggerLevel <= waterLevel) {
            if (!super.isOn()) {
                super.isOn = true;
            }
        } else {
            if (super.isOn()) {
                super.isOn = false;
            }
        }
    }

    @Override
    public void drain(Planter planter) {
        if (super.isOn) {
            planter.setWaterAmount(planter.getWaterAmount() - 7);
        }
    }

    @Override
    public void onTick() {
//        super.currentTick += 1;
        super.increaseTicks();
    }
}

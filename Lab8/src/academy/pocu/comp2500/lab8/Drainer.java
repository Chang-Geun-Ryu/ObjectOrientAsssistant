package academy.pocu.comp2500.lab8;

public class Drainer extends SmartDevice implements IDrainable, IWaterDetectable {
    private static final int DRAIN_AMOUNT = -7;
    private int detectionAmount;

    public Drainer(int detectionAmount) {
        super();
        this.detectionAmount = detectionAmount;
    }

    @Override
    public void onTick() {
        tick++;
        ticksSinceLastUpdate++;
    }

    @Override
    public void drain(Planter planter) {
        if (isOn()) {
            planter.addWater(DRAIN_AMOUNT);
        }
    }

    @Override
    public void detect(int waterLevel) {
        updateOn(waterLevel >= detectionAmount);
    }
}

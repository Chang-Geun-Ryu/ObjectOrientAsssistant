package academy.pocu.comp2500.lab8;

public class Drainer extends SmartDevice implements IDrainable, IWaterDetectable {
    private static final int AMOUNT_OF_WATER_DRAINING_IN_LITRE = 7;
    private int amountOfWaterInLitreWhenOn;
    private int ticksSinceLastUpdate;
    private boolean isJustChanged;

    public Drainer(int amountOfWaterInLitreWhenOn) {
        super.smartDeviceType = SmartDeviceType.DRAINER;
        this.amountOfWaterInLitreWhenOn = amountOfWaterInLitreWhenOn;
    }

    @Override
    public boolean isOn() {
        return super.isOn;
    }

    @Override
    public void onTick() {
        ++this.ticksSinceLastUpdate;
    }

    @Override
    public int getTicksSinceLastUpdate() {
        return ticksSinceLastUpdate;
    }

    @Override
    public void drain(Planter planter) {
        planter.drainWater(AMOUNT_OF_WATER_DRAINING_IN_LITRE);
    }

    @Override
    public void detect(int waterLevel) {
        if (amountOfWaterInLitreWhenOn <= waterLevel) {
            if (super.isOn != true) {
                super.isOn = true;
                this.ticksSinceLastUpdate = 0;
            }
        } else {
            if (super.isOn == true) {
                super.isOn = false;
                this.ticksSinceLastUpdate = 0;
            }
        }
    }

/*    public void executeWhenIsChanged() {
        super.isOn ^= true;
        ticksSinceLastUpdate = 0;
        this.isJustChanged = false;
    }*/

/*    public boolean isJustChanged() {
        return this.isJustChanged;
    }*/
}

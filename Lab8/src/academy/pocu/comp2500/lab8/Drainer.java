package academy.pocu.comp2500.lab8;

import java.util.ArrayList;

public class Drainer extends SmartDevice implements IDrainable, IWaterDetectable {

    private final int DRAIN_AMOUNT = 7;
    private final int CRITERIA;

    public Drainer(int criteria) {
        super(EDeviceKind.DRAINER);
        this.CRITERIA = criteria;
    }

    @Override
    public void onTick() {
        super.increaseTicks();
    }

    @Override
    public void detect(int waterLevel) {
        if (this.getCriteria() <= waterLevel) {
            if (!super.isOn()) {
                super.changeState();
                super.updateTicksSinceLastUpdate();
            }
        } else {
            if (super.isOn()) {
                super.changeState();
                super.updateTicksSinceLastUpdate();
            }
        }
    }

    @Override
    public void drain(Planter planter) {
        if (super.isOn()) {
            planter.decreaseWaterAmount(this.DRAIN_AMOUNT);
        }
    }


    public int getCriteria() {
        return this.CRITERIA;
    }
}

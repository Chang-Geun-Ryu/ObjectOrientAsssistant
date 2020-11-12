package academy.pocu.comp2500.assignment3;

import java.util.ArrayList;

public class SmartMine extends Mine implements IThinkable {
    private int enemySensorCount;
    private boolean activated;

    public SmartMine(IntVector2D position, int touchCount, int enemySensorCount) {
        super(position, touchCount);
        super.symbol = 'A';
        super.vision = 1;
        super.aoe = 1;
        super.ap = 15;
        super.unitComponents.add(UnitComponent.THINKABLE);
        this.enemySensorCount = enemySensorCount;
        this.activated = false;
    }

    public boolean isActivated() {
        return this.activated;
    }

    @Override
    public AttackIntent attack() {
        SimulationManager simulationManager = SimulationManager.getInstance();
        if (simulationManager.getUnits().isEmpty()) {
            return null;
        }
        ArrayList<Unit> attackCandidates = new ArrayList<>(simulationManager.getUnits().size());
        for (Unit unit : simulationManager.getUnits()) {
            if (unit != this && unit.getUnitComponents().contains(UnitComponent.VISIBLE) && unit.getUnitType() == UnitType.GROUND && super.position.getDistance(unit.getPosition()) <= 1) {
                attackCandidates.add(unit);
            }
        }
        if (attackCandidates.size() >= enemySensorCount) {
            this.activated = true;
            return new AttackIntent(this, new IntVector2D(super.position), super.ap, super.aoe);
        } else {
            return null;
        }
    }

    @Override
    public AttackIntent collide() {
        return super.attack();
    }
}

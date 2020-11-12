package academy.pocu.comp2500.assignment3;

import java.util.ArrayList;

public class SmartMine extends Mine implements IThinkable {
    private int enemySensorCount;

    public SmartMine(IntVector2D position, int touchCount, int enemySensorCount) {
        super(position, touchCount);
        super.symbol = 'A';
        super.vision = 1;
        super.aoe = 1;
        super.ap = 15;
        super.unitComponents.add(UnitComponent.THINKABLE);
        this.enemySensorCount = enemySensorCount;
    }

    @Override
    public AttackIntent attack() {
        AttackIntent normalMineAttackIntent = super.attack();
        if (normalMineAttackIntent == null) {
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
                super.hp = 0;
                simulationManager.getUnits().remove(this);
                return new AttackIntent(this, new IntVector2D(super.position), super.ap, super.aoe);
            } else {
                return null;
            }
        } else {
            return normalMineAttackIntent;
        }
    }
}

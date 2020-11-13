package academy.pocu.comp2500.assignment3;

import java.util.ArrayList;
import java.util.Collections;

public class Turret extends Unit implements IThinkable {
    public Turret(IntVector2D position) {
        super('U', UnitType.GROUND, 2, 0, 7, 99, position);
        super.unitComponents.add(UnitComponent.VISIBLE);
        super.unitComponents.add(UnitComponent.THINKABLE);
        super.attackableTypes.add(UnitType.AIR);
    }

    @Override
    public AttackIntent attack() {
        SimulationManager simulationManager = SimulationManager.getInstance();
        if (simulationManager.getUnits().isEmpty()) {
            return null;
        }
        ArrayList<Unit> attackCandidates = new ArrayList<>(simulationManager.getUnits().size());
        for (Unit unit : simulationManager.getUnits()) {
            if (unit != this && unit.getUnitComponents().contains(UnitComponent.VISIBLE) && unit.getUnitType() == UnitType.AIR && super.position.getDistance(unit.getPosition()) <= 1) {
                attackCandidates.add(unit);
            }
        }
        if (attackCandidates.isEmpty() == true) {
            return null;
        } else {
            int minHP = Integer.MAX_VALUE;
            for (Unit unit : attackCandidates) {
                if (unit.getHp() < minHP) {
                    minHP = unit.getHp();
                }
            }
            ArrayList<Unit> weakestUnits = new ArrayList<>(attackCandidates.size());
            for (Unit unit : attackCandidates) {
                if (unit.getHp() == minHP) {
                    weakestUnits.add(unit);
                }
            }
            if (weakestUnits.size() == 1) {
                return new AttackIntent(this, new IntVector2D(weakestUnits.get(0).getPosition()), super.ap, super.aoe);
            } else {
                for (Unit unit : weakestUnits) {
                    if (unit.getPosition().getX() == super.position.getX() && unit.getPosition().getY() == super.position.getY()) {
                        return new AttackIntent(this, new IntVector2D(this.position), super.ap, super.aoe);
                    }
                }
                ComparatorAttackTurret comparatorAttackTurret = new ComparatorAttackTurret(super.position.getX(), super.position.getY());
                Collections.sort(weakestUnits, comparatorAttackTurret);
                return new AttackIntent(this, new IntVector2D(weakestUnits.get(0).getPosition()), super.ap, super.aoe);
            }
        }
    }
}

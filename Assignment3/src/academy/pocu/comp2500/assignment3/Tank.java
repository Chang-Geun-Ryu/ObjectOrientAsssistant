package academy.pocu.comp2500.assignment3;

import java.util.ArrayList;
import java.util.Collections;

public class Tank extends Unit implements IMovable, IThinkable {
    private boolean headEast;

    public Tank(IntVector2D position) {
        super('T', UnitType.GROUND, 3, 1, 8, 85, position);
        super.attackableTypes.add(UnitType.GROUND);
        super.unitComponents.add(UnitComponent.MOVABLE);
        super.unitComponents.add(UnitComponent.THINKABLE);
        super.unitComponents.add(UnitComponent.VISIBLE);
        this.headEast = true;
    }

    private void changeMode() {
        if (super.unitComponents.contains(UnitComponent.MOVABLE)) {
            super.unitComponents.remove(UnitComponent.MOVABLE);
            super.multipliedDamage = 2.0;
        } else {
            super.unitComponents.add(UnitComponent.MOVABLE);
            super.multipliedDamage = 1.0;
        }
        super.setNowUsed(true);
    }

    @Override
    public AttackIntent attack() {
        if (super.unitComponents.contains(UnitComponent.MOVABLE) == true) {
            changeMode();
            return null;
        } else {
            SimulationManager simulationManager = SimulationManager.getInstance();
            ArrayList<Unit> attackCandidates = new ArrayList<>(simulationManager.getUnits().size());
            for (Unit unit : simulationManager.getUnits()) {
                if (unit != this && unit.getUnitComponents().contains(UnitComponent.VISIBLE) && unit.getUnitType() == UnitType.GROUND && super.position.getDistance(unit.getPosition()) == 2) {
                    int diffX = Math.abs(super.position.getX() - unit.getPosition().getX());
                    int diffY = Math.abs(super.position.getY() - unit.getPosition().getY());
                    if (diffX != 2 || diffY != 2) {
                        attackCandidates.add(unit);
                    }
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
                    ComparatorClockCycle comparatorClockCycle = new ComparatorClockCycle(super.position.getX(), super.position.getY(), 2);
                    Collections.sort(weakestUnits, comparatorClockCycle);
                    return new AttackIntent(this, new IntVector2D(weakestUnits.get(0).getPosition()), super.ap, super.aoe);
                }
            }
        }
    }

    @Override
    public MoveIntent move() {
        if (super.unitComponents.contains(UnitComponent.MOVABLE) == false) {
            changeMode();
            return null;
        } else {
            if (headEast == true) {
                if (super.position.getX() == 15) {
                    headEast = false;
                    return new MoveIntent(this, new IntVector2D(super.position.getX() - 1, super.position.getY()));
                } else {
                    return new MoveIntent(this, new IntVector2D(super.position.getX() + 1, super.position.getY()));
                }
            } else {
                if (super.position.getX() == 0) {
                    headEast = true;
                    return new MoveIntent(this, new IntVector2D(super.position.getX() + 1, super.position.getY()));
                } else {
                    return new MoveIntent(this, new IntVector2D(super.position.getX() - 1, super.position.getY()));
                }
            }
        }
    }
}

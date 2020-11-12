package academy.pocu.comp2500.assignment3;

import java.util.ArrayList;
import java.util.Collections;

public class Marine extends Unit implements IMovable, IThinkable {

    public Marine(IntVector2D position) {
        super('M', UnitType.GROUND, 2, 0, 6, 35, position);
        super.attackableTypes.add(UnitType.GROUND);
        super.attackableTypes.add(UnitType.AIR);
        super.unitComponents.add(UnitComponent.MOVABLE);
        super.unitComponents.add(UnitComponent.THINKABLE);
        super.unitComponents.add(UnitComponent.VISIBLE);
    }

    @Override
    public AttackIntent attack() {
        SimulationManager simulationManager = SimulationManager.getInstance();
        if (simulationManager.getUnits().isEmpty()) {
            return null;
        }
        ArrayList<Unit> attackCandidates = new ArrayList<>(simulationManager.getUnits().size());
        for (Unit unit : simulationManager.getUnits()) {
            if (unit != this && unit.getUnitComponents().contains(UnitComponent.VISIBLE) && super.position.getDistance(unit.getPosition()) <= 1) {
                attackCandidates.add(unit);
            }
        }
        ArrayList<Unit> willBeDeleted = new ArrayList<>(attackCandidates.size());
        for (Unit unit : attackCandidates) {
            if (super.position.getX() != unit.getPosition().getX() && super.position.getY() != unit.getPosition().getY()) {
                willBeDeleted.add(unit);
            }
        }
        for (Unit unit : willBeDeleted) {
            attackCandidates.remove(unit);
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
                ComparatorAttackCross comparatorAttackCross = new ComparatorAttackCross(super.position.getX(), super.position.getY());
                Collections.sort(weakestUnits, comparatorAttackCross);
                return new AttackIntent(this, new IntVector2D(weakestUnits.get(0).getPosition()), super.ap, super.aoe);
            }
        }
    }

    @Override
    public MoveIntent move() {
        SimulationManager simulationManager = SimulationManager.getInstance();
        if (simulationManager.getUnits().isEmpty()) {
            return null;
        }
        int nearest = Integer.MAX_VALUE;
        for (Unit unit : simulationManager.getUnits()) {
            if (unit != this && unit.getUnitComponents().contains(UnitComponent.VISIBLE) && super.position.getDistance(unit.getPosition()) < nearest) {
                nearest = super.position.getDistance(unit.getPosition());
            }
        }
        if (nearest > vision) {
            return null;
        }
        ArrayList<Unit> nearestUnits = new ArrayList<>(simulationManager.getUnits().size());
        for (Unit unit : simulationManager.getUnits()) {
            if (super.position.getDistance(unit.getPosition()) == nearest) {
                nearestUnits.add(unit);
            }
        }
        if (nearestUnits.size() == 1) {
            return moveYThanX(nearestUnits.get(0));
        } else {
            int minHP = Integer.MAX_VALUE;
            for (Unit unit : nearestUnits) {
                if (unit.getHp() < minHP) {
                    minHP = unit.getHp();
                }
            }
            ArrayList<Unit> weakestUnits = new ArrayList<>(nearestUnits.size());
            for (Unit unit : nearestUnits) {
                if (unit.getHp() == minHP) {
                    weakestUnits.add(unit);
                }
            }
            if (weakestUnits.size() == 1) {
                return moveYThanX(weakestUnits.get(0));
            } else {
                ComparatorClockCycle comparatorClockCycle = new ComparatorClockCycle(super.position.getX(), super.position.getY(), nearest);
                Collections.sort(weakestUnits, comparatorClockCycle);
                return moveYThanX(weakestUnits.get(0));
            }
        }
    }

    public MoveIntent moveYThanX(Unit other) {
        int move = 0;
        int diffY = other.getPosition().getY() - this.position.getY();
        if (diffY != 0) {
            move = (diffY > 0) ? 1 : -1;
            return new MoveIntent(this, new IntVector2D(super.position.getX(), super.position.getY() + move));
        } else {
            int diffX = other.getPosition().getX() - this.position.getX();
            // attack도 아닌 move 단계에서 y도 x도 같은(이미 같은 칸이며 공격 대상일 수 있던) 상대방은 move 대상이 될 수 없다.
            move = (diffX > 0) ? 1 : -1;
            return new MoveIntent(this, new IntVector2D(super.position.getX() + move, super.position.getY()));
        }
    }


}

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
//            System.out.println(super.getNo()+" (마린): 공격할 넘이 없음");
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
//                System.out.println(super.getNo()+" (마린): 젤 약한 애 하나 공격할 거임 -> " + weakestUnits.get(0).getNo());
//                System.out.println("내꺼: " + super.position.getX() + ", " + super.position.getY());
//                System.out.println("적: " + weakestUnits.get(0).getPosition().getX() + ", " + weakestUnits.get(0).getPosition().getY());
//                System.out.println(" - " + super.position.getDistance(weakestUnits.get(0).getPosition()));
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
            if (unit != this && unit.getUnitComponents().contains(UnitComponent.VISIBLE) && super.position.getDistance(unit.getPosition()) <= vision && super.position.getManhattanDistance(unit.getPosition()) <= nearest) {
                nearest = super.position.getManhattanDistance(unit.getPosition());
            }
        }
        if (nearest > vision * 2) {
//            System.out.println(super.getNo()+" (마린): 시야 안에 없어서 못 움직임");
            return null;
        }
        ArrayList<Unit> nearestUnits = new ArrayList<>(simulationManager.getUnits().size());
        for (Unit unit : simulationManager.getUnits()) {
            if (unit != this && unit.getUnitComponents().contains(UnitComponent.VISIBLE) && super.position.getDistance(unit.getPosition()) <= vision && super.position.getManhattanDistance(unit.getPosition()) == nearest) {
                nearestUnits.add(unit);
            }
        }
        if (nearestUnits.isEmpty() == true) {
//            System.out.println(super.getNo()+" (마린): 시야 안에 없어서 못 움직임");
            return null;
        } else if (nearestUnits.size() == 1) {
//            System.out.println(super.getNo()+" (마린): 시야 안에 단 하나를 향해 움직임");
            return moveYThanX(nearestUnits.get(0));
        } else {
            int minHP = Integer.MAX_VALUE;
            for (Unit unit : nearestUnits) {
                if (unit.getHp() <= minHP) {
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
//                System.out.println(super.getNo()+" (마린): 약한 애 단 하나를 향해 움직임 -> " + weakestUnits.get(0).getNo());
                return moveYThanX(weakestUnits.get(0));
            } else {
//                ComparatorClockCycle comparatorClockCycle = new ComparatorClockCycle(super.position.getX(), super.position.getY(), nearest);
//                Collections.sort(weakestUnits, comparatorClockCycle);
                ComparatorScanClockCycle comparatorScanClockCycle = new ComparatorScanClockCycle(super.position.getX(), super.position.getY(), vision);
                Collections.sort(weakestUnits, comparatorScanClockCycle);
//                System.out.println("약한애들이라고 하면");
//                for (Unit unit : weakestUnits) {
//                    System.out.print(unit.getNo()+",");
//                }
//                System.out.println("");
//                System.out.println(super.getNo()+" (마린): 약한 애 시계방향 탐색해서 움직임 -> " + weakestUnits.get(0).getNo());
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

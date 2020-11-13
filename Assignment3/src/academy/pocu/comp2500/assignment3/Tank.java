package academy.pocu.comp2500.assignment3;

import java.util.ArrayList;
import java.util.Collections;

public class Tank extends Unit implements IMovable, IThinkable {
    private boolean headEast;
//    private boolean changeMoveMode;

    public Tank(IntVector2D position) {
        super('T', UnitType.GROUND, 3, 1, 8, 85, position);
        super.attackableTypes.add(UnitType.GROUND);
        super.unitComponents.add(UnitComponent.MOVABLE);
        super.unitComponents.add(UnitComponent.THINKABLE);
        super.unitComponents.add(UnitComponent.VISIBLE);
        this.headEast = true;
//        this.changeMoveMode = false;
    }

//    public boolean isChangeMoveMode() {
//        return changeMoveMode;
//    }

    public void changeMode() {
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
//        this.changeMoveMode = false;
        SimulationManager simulationManager = SimulationManager.getInstance();
        ArrayList<Unit> visibleEnemies = new ArrayList<>(simulationManager.getUnits().size());
        for (Unit unit : simulationManager.getUnits()) {
            if (unit != this && unit.getUnitComponents().contains(UnitComponent.VISIBLE) && unit.getUnitType() == UnitType.GROUND && super.position.getDistance(unit.getPosition()) <= super.vision) {
                visibleEnemies.add(unit);
            }
        }
        if (visibleEnemies.isEmpty() == false) {
            if (super.unitComponents.contains(UnitComponent.MOVABLE) == true) {
//                System.out.println(super.getNo() + "는 공격태세로 전환");
//                System.out.print(" - 시야에 ");
//                for (Unit unit : visibleEnemies) {
//                    System.out.print(unit.getNo()+"("+unit.getSymbol()+"),");
//                }
//                System.out.println("있어서");
                changeMode();
                return null;
            }
        } else {
            if (super.unitComponents.contains(UnitComponent.MOVABLE) == false) {
//                System.out.println(super.getNo() + "는 이동태세로 전환할거야(시야에 아무도 없거든)");
                changeMode();
            }
            return null;
        }
        ArrayList<Unit> attackCandidates = new ArrayList<>(visibleEnemies.size());
        for (Unit unit : visibleEnemies) {
            if (super.position.getDistance(unit.getPosition()) == 2) {
                int diffX = Math.abs(super.position.getX() - unit.getPosition().getX());
                int diffY = Math.abs(super.position.getY() - unit.getPosition().getY());
                if (diffX != 2 || diffY != 2) {
                    attackCandidates.add(unit);
                }
            }
        }
        if (attackCandidates.isEmpty() == true) {
//            if (super.unitComponents.contains(UnitComponent.MOVABLE) == false) {
//                System.out.println(super.getNo() + "는 이동태세로 전환할거야(공격 가능한 애가 없어)");
//                this.changeMoveMode = true;
//                super.setNowUsed(true);
//            }
//            System.out.println(super.getNo() + "는 가만히 있을거야(시야는 있지만 공격 가능한 애가 없어)");
            super.setNowUsed(true);
            return null;
        } else {
//            System.out.println(super.getNo() + "는 공격한다");
            super.setNowUsed(true);
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
//                System.out.println(" - " + weakestUnits.get(0).getNo()+"를!");
                return new AttackIntent(this, new IntVector2D(weakestUnits.get(0).getPosition()), super.ap, super.aoe);
            } else {
                ComparatorAttackTank comparatorAttackTank = new ComparatorAttackTank(super.position.getX(), super.position.getY());
                Collections.sort(weakestUnits, comparatorAttackTank);
//                System.out.println(" - " + weakestUnits.get(0).getNo()+"를!");
                return new AttackIntent(this, new IntVector2D(weakestUnits.get(0).getPosition()), super.ap, super.aoe);
            }
        }
    }

    @Override
    public MoveIntent move() {
        if (super.nowUsed == true) {
            return null;
        }
        super.setNowUsed(true);
        if (super.unitComponents.contains(UnitComponent.MOVABLE) == false) {
//            System.out.println(super.getNo() + "는 이동태세로 전환할거야");
            changeMode();
            return null;
        } else {
//            System.out.println(super.getNo() + "는 이동한다");
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

package academy.pocu.comp2500.assignment3;

import java.util.ArrayList;
import java.util.Collections;

public class Wraith extends Unit implements IMovable, IThinkable {
    private boolean barrierUsed;
    private boolean nowUseBarrier;
    private IntVector2D firstPosition;

    public Wraith(IntVector2D position) {
        super('W', UnitType.AIR, 4, 0, 6, 80, position);
        super.attackableTypes.add(UnitType.GROUND);
        super.attackableTypes.add(UnitType.AIR);
        super.unitComponents.add(UnitComponent.MOVABLE);
        super.unitComponents.add(UnitComponent.THINKABLE);
        super.unitComponents.add(UnitComponent.VISIBLE);
        this.barrierUsed = false;
        this.nowUseBarrier = false;
        this.firstPosition = new IntVector2D(position);
    }

    @Override
    public AttackIntent attack() {
        this.nowUseBarrier = false;
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
        ArrayList<Unit> willBeDeleted = new ArrayList<>();
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
            ArrayList<Unit> airCandidates = new ArrayList<>(attackCandidates.size());
            for (Unit unit : attackCandidates) {
                if (unit.getUnitType() == UnitType.AIR) {
                    airCandidates.add(unit);
                }
            }
            if (airCandidates.isEmpty() == false) {
                attackCandidates = airCandidates;
            }
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
            return moveToFirstPosition();
        }
        ArrayList<Unit> enemies = new ArrayList<>();
        for (Unit unit : simulationManager.getUnits()) {
            if (unit != this && unit.getUnitComponents().contains(UnitComponent.VISIBLE) && unit.getUnitType() == UnitType.AIR) {
                enemies.add(unit);
            }
        }
        int nearest = Integer.MAX_VALUE;
        ArrayList<Unit> nearestUnits = null;
        if (enemies.isEmpty() == false) {
            nearest = Integer.MAX_VALUE;
            for (Unit unit : enemies) {
                if (super.position.getDistance(unit.getPosition()) <= vision && super.position.getManhattanDistance(unit.getPosition()) <= nearest) {
                    nearest = super.position.getManhattanDistance(unit.getPosition());
                }
            }
            if (nearest > vision * 2) {
                enemies.clear();
            } else {
                nearestUnits = new ArrayList<>(enemies.size());
                for (Unit unit : enemies) {
                    if (super.position.getDistance(unit.getPosition()) <= vision && super.position.getManhattanDistance(unit.getPosition()) == nearest) {
                        nearestUnits.add(unit);
                    }
                }
            }
        }
        if (nearestUnits == null) {
            for (Unit unit : simulationManager.getUnits()) {
                if (unit != this && unit.getUnitComponents().contains(UnitComponent.VISIBLE) && unit.getUnitType() == UnitType.GROUND) {
                    enemies.add(unit);
                }
            }
            if (enemies.isEmpty() == false) {
                nearest = Integer.MAX_VALUE;
                for (Unit unit : enemies) {
                    if (super.position.getDistance(unit.getPosition()) <= vision && super.position.getManhattanDistance(unit.getPosition()) <= nearest) {
                        nearest = super.position.getManhattanDistance(unit.getPosition());
                    }
                }
                if (nearest <= vision * 2) {
                    nearestUnits = new ArrayList<>(enemies.size());
                    for (Unit unit : enemies) {
                        if (super.position.getDistance(unit.getPosition()) <= vision && super.position.getManhattanDistance(unit.getPosition()) == nearest) {
                            nearestUnits.add(unit);
                        }
                    }
                } else {
                    return moveToFirstPosition();
                }
            } else {
                return moveToFirstPosition();
            }
        }
        if (nearestUnits.isEmpty() == true) {
            return moveToFirstPosition();
        } else if (nearestUnits.size() == 1) {
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
//                ComparatorClockCycle comparatorClockCycle = new ComparatorClockCycle(super.position.getX(), super.position.getY(), nearest);
//                Collections.sort(weakestUnits, comparatorClockCycle);
                ComparatorScanClockCycle comparatorScanClockCycle = new ComparatorScanClockCycle(super.position.getX(), super.position.getY(), vision);
                Collections.sort(weakestUnits, comparatorScanClockCycle);
                return moveYThanX(weakestUnits.get(0));
            }
        }

    }

    private MoveIntent moveToFirstPosition() {
        int move = 0;
        int diffY = this.firstPosition.getY() - super.position.getY();
        if (diffY == 0) {
            int diffX = this.firstPosition.getX() - super.position.getX();
            if (diffX == 0) {
                return null;
            } else {
                move = (diffX > 0) ? 1 : -1;
                return new MoveIntent(this, new IntVector2D(super.position.getX() + move, super.position.getY()));
            }
        } else {
            move = (diffY > 0) ? 1 : -1;
            return new MoveIntent(this, new IntVector2D(super.position.getX(), super.position.getY() + move));
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

    @Override
    public void onAttacked(int damage) {
        if (nowUseBarrier == true) {
//            System.out.println(super.getNo() + "는 잘막음!");
            return;
        } else if (barrierUsed == false) {
            this.barrierUsed = true;
            this.nowUseBarrier = true;
//            System.out.println(super.getNo() + "는 잘막음!");
        } else {
            super.onAttacked(damage);
        }
    }

    @Override
    public void die() {
        if (nowUseBarrier == true) {
            return;
        } else if (barrierUsed == false) {
            this.barrierUsed = true;
            this.nowUseBarrier = true;
        } else {
//            super.die();
            super.hp = 0;
        }
    }
}

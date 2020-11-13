package academy.pocu.comp2500.assignment3;

import java.util.ArrayList;

public class Unit {
    //unit stat
    protected char mark;
    protected AreaType areaType;
    protected int sight;
    protected int aoe;
    protected int ap;
    protected int hp;
    protected AreaType attackArea;
    protected AreaType visibleArea;
    protected boolean visible = true;

    //unit status
    protected IntVector2D position;
    protected IntVector2D[] attackRange;

    protected ActionType actionThisFrame;
    protected IntVector2D targetPosition;

    //
    //필수 함수
    //
    //     * getPosition(): 유닛의 현재 위치를 반환합니다.
    public final IntVector2D getPosition() {
        return position;
    }

    //     * getHp(): 유닛의 현재 HP를 반환합니다.
    public final int getHp() {
        return hp;
    }

    //     * attack(): 공격 의도(AttackIntent) 개체를 반환합니다. AttackIntent 안에는 공격 위치, 피해치, 공격자 등 공격에 필요한 정보가 담겨 있어야 합니다.
    public AttackIntent attack() {
        if (actionThisFrame != ActionType.ATTACK) {
            return null;
        }
        return new AttackIntent(this, targetPosition);
    }

    //     * onAttacked(): 유닛에 피해치(damage)를 적용합니다.
    public void onAttacked(int damage) {
        if (damage == -1) {
            hp = 0;
        } else {
            hp -= damage;
        }
    }

    //     * onSpawn(): 유닛이 월드에 추가될 때(spawn) SimulationManager가 이 메서드를 호출해야 합니다.
    public void onSpawn() {
    }

    //getSymbol(): 유닛을 나타내는 표식(symbol)을 반환합니다. 각 유닛의 표식은 부록 A.3 참고해주세요.
    public final char getSymbol() {
        return mark;
    }

    //
    //  내맘대로
    //
    public int getAp() {
        return ap;
    }

    public int getDamageFromPercent(Unit attackedUnit, double percent) {
        return (int) (attackedUnit.getHp() * percent);
    }

    public AreaType getAreaType() {
        return areaType;
    }


    public final int getAoe() {
        return aoe;
    }

    protected void setTargetPosition(IntVector2D targetPosition) {
        this.targetPosition = new IntVector2D(targetPosition.getX(), targetPosition.getY());
    }

    //볼 수 있는 유닛을 찾는다
    protected final ArrayList<Unit> searchVisibleUnit() {
        ArrayList<Unit> unitList = SimulationManager.getInstance().getUnits();
        ArrayList<Unit> inVisionUnit = new ArrayList<>();

        int maxY = this.position.getY() + sight;
        int minY = this.position.getY() - sight;
        int maxX = this.position.getX() + sight;
        int minX = this.position.getX() - sight;

        for (Unit unit : unitList) {
            if (unit == this) {
                continue;
            }
            if (unit.visible
                    && unit.position.getX() <= maxX
                    && unit.position.getX() >= minX
                    && unit.position.getY() <= maxY
                    && unit.position.getY() >= minY
                    && (this.visibleArea == AreaType.BOTH
                    || this.visibleArea == unit.getAreaType())) {
                inVisionUnit.add(unit);
            }
        }
        return inVisionUnit;
    }

    //공격범위 안에 있는 유닛을 찾는다
    protected final ArrayList<Unit> searchCanAttackUnits() {
        ArrayList<Unit> unitList = SimulationManager.getInstance().getUnits();
        ArrayList<Unit> canAttackUnit = new ArrayList<>();

        for (Unit unit : unitList) {
            if (unit == this || !unit.visible) {
                continue;
            }
            for (IntVector2D vector2D : attackRange) {
                if ((this.attackArea == AreaType.BOTH || this.attackArea == unit.areaType)
                        && unit.getPosition().getX() == this.getPosition().getX() + vector2D.getX()
                        && unit.getPosition().getY() == this.getPosition().getY() + vector2D.getY()) {
                    canAttackUnit.add(unit);
                    break;
                }
            }
        }
        return canAttackUnit;
    }

    //볼 수 있는 유닛 중에 가장 가까운 유닛들을 찾는다.
    protected final ArrayList<Unit> searchMinDistanceUnits(ArrayList<Unit> units) {
        if (units.size() <= 1) {
            return units;
        }
        ArrayList<Unit> sameDistanceUnit = new ArrayList<>();
        int minDistance = Integer.MAX_VALUE;
        int distance = 0;

        for (Unit unit : units) {
            distance = Math.abs(unit.position.getX() - this.position.getX()) + Math.abs(unit.position.getY() - this.position.getY());
            if (distance < minDistance) {
                sameDistanceUnit.clear();
                sameDistanceUnit.add(unit);
                minDistance = distance;
            } else if (distance == minDistance) {
                sameDistanceUnit.add(unit);
            }
        }
        return sameDistanceUnit;
    }

    //가장 체력이 낮은 유닛들을 찾는다.
    protected final ArrayList<Unit> searchWeakestUnits(ArrayList<Unit> units) {
        if (units.size() <= 1) {
            return units;
        }
        int weakest = Integer.MAX_VALUE;
        ArrayList<Unit> weakestUnits = new ArrayList<>();

        for (Unit unit : units) {
            if (unit == this) {
                continue;
            }
            if (weakest > unit.getHp()) {
                weakest = unit.getHp();
                weakestUnits.clear();
                weakestUnits.add(unit);
            } else if (weakest == unit.getHp()) {
                weakestUnits.add(unit);
            }
        }

        return weakestUnits;
    }

    //시계방향으로 유닛을 찾는다.
    protected final Unit searchFirstUnitInClockwiseDirection(ArrayList<Unit> unitList) {
        Unit firstUnit = null;
        double x;
        double y;
        double radian;
        double minRadian = Double.MAX_VALUE;

        for (Unit unit : unitList) {
            if (unit == this) {
                continue;
            }
            x = unit.position.getX() - this.position.getX();
            y = unit.position.getY() - this.position.getY();
            double degree45 = Math.atan2(1, 1);
            if (x == 0 && y < 0) {
                radian = 0;
            } else if (x > 0 && y <= 0) {
                y = Math.abs(y);
                radian = degree45 * 2 - Math.atan2(y, x);
            } else if (x >= 0 && y > 0) {
                radian = degree45 * 4 - Math.atan2(x, y);
            } else if (x < 0 && y >= 0) {
                x = Math.abs(x);
                radian = degree45 * 6 - Math.atan2(y, x);
            } else {
                x = Math.abs(x);
                y = Math.abs(y);
                radian = degree45 * 8 - Math.atan2(x, y);
            }
            if (minRadian > radian) {
                minRadian = radian;
                firstUnit = unit;
            }
        }
        return firstUnit;
    }

    //특정 구역 유닛만 검사
    protected ArrayList<Unit> searchSpecificAreaUnit(ArrayList<Unit> unitList, AreaType type) {
        if (type == AreaType.BOTH) {
            return unitList;
        }

        ArrayList<Unit> typeUnits = new ArrayList<>();

        for (Unit unit : unitList) {
            if (unit == this || !visible) {
                continue;
            }
            if (unit.getAreaType() == type) {
                typeUnits.add(unit);
            }
        }
        return typeUnits;
    }
}
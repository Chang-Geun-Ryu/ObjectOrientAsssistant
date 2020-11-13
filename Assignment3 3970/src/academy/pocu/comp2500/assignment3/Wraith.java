package academy.pocu.comp2500.assignment3;

import java.util.ArrayList;

public class Wraith extends Unit implements IMoveable, IThinkable {
    private static final int ATTACK_TILE_AMOUNT = 5;
    private IntVector2D originalPosition;
    private boolean isProtectionOn;
    private boolean isAttacked;

    public Wraith(IntVector2D position) {
        mark = 'W';
        sight = 4;
        aoe = 0;
        ap = 6;
        hp = 80;
        areaType = AreaType.SKY;
        attackArea = AreaType.BOTH;
        visibleArea = AreaType.BOTH;
        this.position = position;
        this.originalPosition = new IntVector2D(position.getX(), position.getY());

        isProtectionOn = true;
        isAttacked = false;

        attackRange = new IntVector2D[ATTACK_TILE_AMOUNT];
        attackRange[0] = new IntVector2D(0, 0);
        attackRange[1] = new IntVector2D(0, 1);
        attackRange[2] = new IntVector2D(1, 0);
        attackRange[3] = new IntVector2D(0, -1);
        attackRange[4] = new IntVector2D(-1, 0);
    }

    public void onSpawn() {
        SimulationManager.getInstance().registerThinkable(this);
        SimulationManager.getInstance().registerMovable(this);
    }

    public void onAttacked(int damage) {
        if (isProtectionOn) {
            isAttacked = true;
            return;
        }
        super.onAttacked(damage);
    }

    @Override
    public void move() {
        if (actionThisFrame != ActionType.MOVE) {
            return;
        }

        if (targetPosition.getY() == getPosition().getY()) {
            //x이동
            if (targetPosition.getX() > getPosition().getX()) {
                getPosition().setX(getPosition().getX() + 1);
            } else {
                getPosition().setX(getPosition().getX() - 1);
            }
        } else {
            //y이동
            if (targetPosition.getY() > getPosition().getY()) {
                getPosition().setY(getPosition().getY() + 1);
            } else {
                getPosition().setY(getPosition().getY() - 1);
            }
        }
    }

    @Override
    public void think() {
        if (isAttacked) {
            isProtectionOn = false;
        }
        ArrayList<Unit> canAttackUnits = searchCanAttackUnits();
        if (canAttackUnits.size() > 0) {
            actionThisFrame = ActionType.ATTACK;
            setTargetForAttack(canAttackUnits);
            return;
        }
        ArrayList<Unit> visibleUnits = searchVisibleUnit();
        if (visibleUnits.size() > 0
                || !position.equals(originalPosition)) {
            actionThisFrame = ActionType.MOVE;
            setTargetForMoving(visibleUnits);
            return;
        }
        actionThisFrame = ActionType.DO_NOTHING;
    }

    private void setTargetForAttack(ArrayList<Unit> unit) {
        ArrayList<Unit> targets;
        ArrayList<Unit> skyUnits = searchSpecificAreaUnit(searchCanAttackUnits(), AreaType.SKY);
        if (skyUnits.size() > 0) {
            targets = skyUnits;
        } else {
            targets = unit;
        }
        //1. 가장 약한 유닛을 찾는다.
        targets = searchWeakestUnits(targets);

        //2. 자신의 위치를 찾는다.
        for (Unit unit2 : targets) {
            if (unit2.position.equals(this.position)) {
                setTargetPosition(unit2.getPosition());
                return;
            }
        }
        //3. 시계방향으로 찾는다.
        Unit target = searchFirstUnitInClockwiseDirection(targets);
        setTargetPosition(target.getPosition());

    }

    private void setTargetForMoving(ArrayList<Unit> unit) {
        ArrayList<Unit> targets;
        Unit target;
        ArrayList<Unit> skyUnits = searchSpecificAreaUnit(unit, AreaType.SKY);
        if (skyUnits.size() > 0) {
            targets = skyUnits;
        } else {
            targets = unit;
        }
        targets = searchMinDistanceUnits(targets);
        targets = searchWeakestUnits(targets);
        setTargetPosition(searchFirstUnitInClockwiseDirection(targets).getPosition());
    }
}

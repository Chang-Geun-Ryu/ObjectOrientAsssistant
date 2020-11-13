package academy.pocu.comp2500.assignment3;

import java.util.ArrayList;

public class Marine extends Unit implements IMoveable, IThinkable {
    private static final int ATTACK_TILE_AMOUNT = 5;

    public Marine(IntVector2D position) {
        mark = 'M';
        sight = 2;
        aoe = 0;
        ap = 6;
        hp = 35;
        areaType = AreaType.GROUND;
        attackArea = AreaType.BOTH;
        visibleArea = AreaType.BOTH;
        this.position = position;

        attackRange = new IntVector2D[ATTACK_TILE_AMOUNT];
        attackRange[0] = new IntVector2D(0, 0);
        attackRange[1] = new IntVector2D(0, 1);
        attackRange[2] = new IntVector2D(1, 0);
        attackRange[3] = new IntVector2D(0, -1);
        attackRange[4] = new IntVector2D(-1, 0);
    }

    @Override
    public void onSpawn() {
        SimulationManager.getInstance().registerMovable(this);
        SimulationManager.getInstance().registerThinkable(this);
    }

    @Override
    public void move() {
        if (targetPosition == null || actionThisFrame != ActionType.MOVE) {
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
        ArrayList<Unit> canAttackUnits = searchCanAttackUnits();
        if (canAttackUnits.size() > 0) {
            actionThisFrame = ActionType.ATTACK;
            setTargetForAttack(canAttackUnits);
            return;
        }
        ArrayList<Unit> visibleUnits = searchVisibleUnit();
        if (visibleUnits.size() > 0) {
            actionThisFrame = ActionType.MOVE;
            setTargetForMoving(visibleUnits);
            return;
        }
        actionThisFrame = ActionType.DO_NOTHING;
    }


    private void setTargetForAttack(ArrayList<Unit> units) {
        ArrayList<Unit> targets;
        //1. 가장 약한 유닛을 찾는다.
        targets = searchWeakestUnits(units);

        //2. 자신의 위치를 찾는다.
        for (Unit unit : targets) {
            if (unit.position.equals(this.position)) {
                setTargetPosition(unit.getPosition());
                return;
            }
        }
        //3. 시계방향으로 찾는다.
        Unit target = searchFirstUnitInClockwiseDirection(targets);
        setTargetPosition(target.getPosition());
    }

    private void setTargetForMoving(ArrayList<Unit> units) {
        ArrayList<Unit> targets;
        //1. 가장 가까운 유닛, 맨해튼
        targets = searchMinDistanceUnits(units);
        //2. 가장 가까운 유닛 중 가장 약한 유닛
        targets = searchWeakestUnits(targets);
        setTargetPosition(searchFirstUnitInClockwiseDirection(targets).getPosition());
    }
}

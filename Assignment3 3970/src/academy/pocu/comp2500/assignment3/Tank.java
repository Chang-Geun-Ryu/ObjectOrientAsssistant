package academy.pocu.comp2500.assignment3;

import java.util.ArrayList;

public class Tank extends Unit implements IThinkable, IMoveable {
    private static final int ATTACK_TILE_AMOUNT = 12;
    private boolean isMoveable = true;
    private boolean isGoRight = true;

    public Tank(IntVector2D position) {
        mark = 'T';
        sight = 3;
        aoe = 1;
        ap = 8;
        hp = 85;
        areaType = AreaType.GROUND;
        attackArea = AreaType.GROUND;
        visibleArea = AreaType.GROUND;
        this.position = position;

        attackRange = new IntVector2D[ATTACK_TILE_AMOUNT];
        attackRange[0] = new IntVector2D(0, 2);
        attackRange[1] = new IntVector2D(1, 2);
        attackRange[2] = new IntVector2D(2, 1);
        attackRange[3] = new IntVector2D(2, 0);
        attackRange[4] = new IntVector2D(2, -1);
        attackRange[5] = new IntVector2D(1, -2);
        attackRange[6] = new IntVector2D(0, -2);
        attackRange[7] = new IntVector2D(-1, -2);
        attackRange[8] = new IntVector2D(-2, -1);
        attackRange[9] = new IntVector2D(-2, 0);
        attackRange[10] = new IntVector2D(-2, 1);
        attackRange[11] = new IntVector2D(-1, 2);
    }

    @Override
    public void onAttacked(int damage) {
        if (damage == -1) {
            hp = 0;
            return;
        }
        if (isMoveable) {
            hp -= damage;
        } else {
            hp -= damage * 2;
        }
    }

    public void think() {
        ArrayList<Unit> targets = searchVisibleUnit();
        if (targets.size() == 0) {
            actionThisFrame = ActionType.MOVE;
            return;
        }
        if (isMoveable) {
            isMoveable = false;
            actionThisFrame = ActionType.DO_NOTHING;
            return;
        }
        targets = searchCanAttackUnits();
        if (targets.size() == 0) {
            actionThisFrame = ActionType.DO_NOTHING;
            return;
        }
        actionThisFrame = ActionType.ATTACK;
        targets = searchWeakestUnits(targets);
        setTargetPosition(searchFirstUnitInClockwiseDirection(targets).getPosition());
    }

    public void onSpawn() {
        SimulationManager.getInstance().registerThinkable(this);
        SimulationManager.getInstance().registerMovable(this);
    }

    @Override
    public void move() {
        if (actionThisFrame != ActionType.MOVE) {
            return;
        }
        if (!isMoveable) {
            isMoveable = true;
            return;
        }
        int direction;
        if (isGoRight) {
            direction = 1;
        } else {
            direction = -1;
        }
        if (position.getX() + direction <= -1 || position.getX() + direction >= 16) {
            position.setX(position.getX() - direction);
            isGoRight = !isGoRight;
        } else {
            position.setX(position.getX() + direction);
        }
    }
}

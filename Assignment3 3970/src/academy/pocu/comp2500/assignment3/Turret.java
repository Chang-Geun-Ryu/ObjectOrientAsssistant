package academy.pocu.comp2500.assignment3;

import java.util.ArrayList;

public class Turret extends Unit implements IThinkable {

    private static final int ATTACK_TILE_AMOUNT = 9;

    public Turret(IntVector2D position) {
        mark = 'U';
        sight = 2;
        aoe = 0;
        ap = 7;
        hp = 99;
        areaType = AreaType.GROUND;
        attackArea = AreaType.SKY;
        visibleArea = AreaType.SKY;
        this.position = position;

        attackRange = new IntVector2D[ATTACK_TILE_AMOUNT];
        attackRange[0] = new IntVector2D(0, 0);
        attackRange[1] = new IntVector2D(0, 1);
        attackRange[2] = new IntVector2D(1, 1);
        attackRange[3] = new IntVector2D(1, 0);
        attackRange[4] = new IntVector2D(1, -1);
        attackRange[5] = new IntVector2D(0, -1);
        attackRange[6] = new IntVector2D(-1, -1);
        attackRange[7] = new IntVector2D(-1, 0);
        attackRange[8] = new IntVector2D(-1, 1);
    }

    public void onSpawn() {
        SimulationManager.getInstance().registerThinkable(this);
    }

    @Override
    public void think() {
        ArrayList<Unit> canAttackUnits = searchCanAttackUnits();
        if (canAttackUnits.size() > 0) {
            actionThisFrame = ActionType.ATTACK;
            setTargetForAttack(canAttackUnits);
        } else {
            actionThisFrame = ActionType.DO_NOTHING;
        }
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
}

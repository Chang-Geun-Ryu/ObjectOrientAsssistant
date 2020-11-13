package academy.pocu.comp2500.assignment3;

public class Mine extends Unit implements ICollideable {
    private int timer;
    private int maxTimer;

    public Mine(IntVector2D position, int maxTimer) {
        visible = false;
        this.maxTimer = maxTimer;
        timer = 0;

        mark = 'U';
        sight = 0;
        aoe = 0;
        ap = 10;
        hp = 1;
        areaType = AreaType.GROUND;
        attackArea = AreaType.GROUND;
        this.position = position;
        actionThisFrame = ActionType.DO_NOTHING;
    }

    @Override
    public void onSpawn() {
        SimulationManager.getInstance().registerCollisionEventListener(this);
    }

    @Override
    public void collided() {
        for (Unit unit : SimulationManager.getInstance().getUnits()) {
            if (unit.position.equals(this.position)
                    && unit != this) {
                timer++;
            }
        }
        if (timer > maxTimer) {
            actionThisFrame = ActionType.ATTACK;
            this.onAttacked(this.getAp());
            setTargetPosition(position);
        }
    }
}

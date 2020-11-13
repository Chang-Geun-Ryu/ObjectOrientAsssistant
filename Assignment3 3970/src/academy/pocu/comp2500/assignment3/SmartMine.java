package academy.pocu.comp2500.assignment3;

public class SmartMine extends Unit implements IThinkable {

    private int detectUnitsAmount;

    public SmartMine(IntVector2D position, int detectUnitsAmount) {
        visible = false;
        mark = 'A';
        sight = 1;
        aoe = 1;
        ap = 10;
        hp = 1;
        areaType = AreaType.GROUND;
        attackArea = AreaType.GROUND;
        visibleArea = AreaType.GROUND;
        this.position = position;

        this.detectUnitsAmount = detectUnitsAmount;

        actionThisFrame = ActionType.DO_NOTHING;
    }

    @Override
    public void onSpawn() {
        SimulationManager.getInstance().registerThinkable(this);
    }

    @Override
    public void think() {
        if (searchVisibleUnit().size() >= detectUnitsAmount) {
            actionThisFrame = ActionType.ATTACK;
            this.onAttacked(this.getAp());
            setTargetPosition(position);
        }
    }
}
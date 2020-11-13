package academy.pocu.comp2500.assignment3;

public class Destroyer extends Unit {
    public Destroyer() {
        mark = 'D';
        sight = -1;
        aoe = -1;
        ap = -1;
        hp = 9999;
        areaType = AreaType.GROUND;
        attackArea = AreaType.BOTH;
        visibleArea = AreaType.BOTH;

        actionThisFrame = ActionType.ATTACK;
    }

    @Override
    public AttackIntent attack() {
        return new AttackIntent(SimulationManager.getInstance().getUnits(), this);
    }

    @Override
    public void onAttacked(int damage) {
        if (damage == -1) {
            hp -= damage;
        } else {
            hp -= 1;
        }
    }
}

package academy.pocu.comp2500.assignment3;

public class Destroyer extends Unit {
    public Destroyer(IntVector2D position) {
        super('D', UnitType.UNKNOWN, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, position);
        super.attackableTypes.add(UnitType.GROUND);
        super.attackableTypes.add(UnitType.AIR);
    }

    @Override
    public AttackIntent attack() {
        return new AttackIntent(this, super.position, Integer.MAX_VALUE, Integer.MAX_VALUE);
    }

    @Override
    public void onAttacked(int damage) {
        --super.hp;
        if (super.hp <= 0) {
            SimulationManager simulationManager = SimulationManager.getInstance();
            simulationManager.getUnits().remove(this);
        }
    }
}

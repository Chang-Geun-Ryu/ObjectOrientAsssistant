package academy.pocu.comp2500.assignment3;

public class Destroyer extends Unit implements IThinkable {
    public Destroyer(IntVector2D position) {
        super('D', UnitType.GROUND, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, position);
        super.attackableTypes.add(UnitType.GROUND);
        super.attackableTypes.add(UnitType.AIR);
        super.unitComponents.add(UnitComponent.THINKABLE);
        super.unitComponents.add(UnitComponent.VISIBLE);
    }

    @Override
    public AttackIntent attack() {
        return new AttackIntent(this, super.position, Integer.MAX_VALUE, Integer.MAX_VALUE);
    }

    @Override
    public void onAttacked(int damage) {
        if (super.hp > 0 && damage > 0) {
            --super.hp;
        }
        if (super.hp <= 0) {
            SimulationManager simulationManager = SimulationManager.getInstance();
            simulationManager.deathUnit(this);
        }

    }
}

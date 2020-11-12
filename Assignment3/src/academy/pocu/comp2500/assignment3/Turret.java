package academy.pocu.comp2500.assignment3;

import java.util.ArrayList;

public class Turret extends Unit {
    public Turret(IntVector2D vector2D) {
        super(vector2D, 99, 'U', UnitKind.LAND, 2, 0, 7, Target.AIR);
        this.pos = new ArrayList<>();
        this.pos.add(new IntVector2D(0, 0));
        this.pos.add(new IntVector2D(0, -1));
        this.pos.add(new IntVector2D(1, -1));
        this.pos.add(new IntVector2D(1, 0));
        this.pos.add(new IntVector2D(1, 1));
        this.pos.add(new IntVector2D(0, 1));
        this.pos.add(new IntVector2D(-1, 1));
        this.pos.add(new IntVector2D(-1, 0));
        this.pos.add(new IntVector2D(-1, -1));
    }

    @Override
    public void onSpawn() {
        SimulationManager.getInstance().registerThinkable(this);
    }

    @Override
    public void think() {
        super.think();
        if (this.getHp() == 0) {
            return;
        }

        ArrayList<Unit> findedUnits = getFindUnits();
        Unit attack = canAttack(findedUnits);

        if (attack != null) {
            addAttack(attack);
        }
    }

}

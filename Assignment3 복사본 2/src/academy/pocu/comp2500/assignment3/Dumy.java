package academy.pocu.comp2500.assignment3;

public class Dumy extends Unit {
    protected Dumy(IntVector2D vector2D, int hp, char sign, UnitKind unitKind, int vision, int aoe, int ap, Target target) {
        super(vector2D, hp, sign, unitKind, vision, aoe, ap, target);
    }

    @Override
    public void onSpawn() {

    }
}

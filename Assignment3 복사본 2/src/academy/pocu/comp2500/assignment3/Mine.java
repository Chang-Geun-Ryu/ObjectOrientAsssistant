package academy.pocu.comp2500.assignment3;

public class Mine extends Unit implements ICollidable {
    protected int touchCount;

    public Mine(IntVector2D position, int touchCount) {
        super('N', UnitType.GROUND, 0, 0, 10, 1, position);
        super.attackableTypes.add(UnitType.GROUND);
        this.touchCount = touchCount;
    }

    @Override
    public void touch() {
        if (this.touchCount > 0) {
            --this.touchCount;
        }
    }

    @Override
    public AttackIntent collide() {
        return attack();
    }

    @Override
    public AttackIntent attack() {
        if (this.touchCount == 0) {
            return new AttackIntent(this, new IntVector2D(super.position), super.ap, super.aoe);
        } else {
            return null;
        }
    }
}

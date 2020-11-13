package academy.pocu.comp2500.assignment3;

import java.util.ArrayList;

public class Destroyer extends Unit implements IMovable, ICollisionEventable {
    public Destroyer(IntVector2D vector2D) {
        super(vector2D, 100, 'D', UnitKind.LAND, 3, 0, 1, Target.BOTH);
    }

    @Override
    public void onSpawn() {
        SimulationManager.getInstance().registerThinkable(this);
        SimulationManager.getInstance().registerMovable(this);
        SimulationManager.getInstance().registerCollisionEventListener(this);
    }

    protected void addMove(IntVector2D vector2D) {
        this.movePos = vector2D;
    }




    @Override
    public void think() {
        super.think();
        if (this.getHp() == 0) {
            return;
        }
//
//        ArrayList<Unit> findedUnits = SimulationManager.getInstance().getUnits();
////        Unit attack = canAttack(findedUnits);
//
//        for (Unit u : findedUnits) {
//            if (u.hashCode() != this.hashCode()) {
////                addAttack(u);
//                u.onAttacked(u.getHp());
//            }
//        }
    }

    @Override
    public void event() {
        super.think();
        if (this.getHp() == 0) {
            return;
        }

        ArrayList<Unit> findedUnits = SimulationManager.getInstance().getUnits();

        for (Unit u : findedUnits) {
            if (u.hashCode() != this.hashCode()) {
                addAttack(u);
                u.onAttacked(u.getHp());
            }
        }
    }

    @Override
    public void onAttacked(int damage) {
        if (this.hp >= 0) {
            this.hp -= 1;
        } else {
            this.hp = 0;
        }
    }

    private IntVector2D getPriority(ArrayList<Unit> units) {

        int min = units.get(0).getHp();
        for (Unit u : units) {
            if (min > u.getHp()) {
                min = u.getHp();
            }
        }

        for (int i = units.size() - 1; i >= 0; --i) {
            if (min != units.get(i).getHp()) {
                units.remove(i);
            }
        }


        Unit target = units.get(0);
        int x = target.getPosition().getX() - this.vector2D.getX();
        int y = target.getPosition().getY() - this.vector2D.getY();
        double max = Math.toDegrees(Math.atan2(x, y));
        for (Unit unit : units) {
            x = unit.vector2D.getX() - this.vector2D.getX();
            y = unit.vector2D.getY() - this.vector2D.getY();

            if (max < Math.toDegrees(Math.atan2(x, y))) {
                max = Math.toDegrees(Math.atan2(x, y));
                target = unit;
            }
        }

        return target.vector2D;
    }

    @Override
    public void move() {
        if (this.movePos != null) {
            this.vector2D = this.movePos;
            this.movePos = null;
        }
    }

    private IntVector2D toMove(IntVector2D vector2D) {
        if (vector2D.getY() == this.vector2D.getY()) {
            int x = this.vector2D.getX() < vector2D.getX() ? 1 : -1;
            return new IntVector2D(this.vector2D.getX() + x, this.vector2D.getY());
        } else {
            int y = this.vector2D.getY() < vector2D.getY() ? 1 : -1;
            return new IntVector2D(this.vector2D.getX(), this.vector2D.getY() + y);
        }
    }
}

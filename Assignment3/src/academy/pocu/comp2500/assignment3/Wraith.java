package academy.pocu.comp2500.assignment3;

import java.util.ArrayList;

public class Wraith extends Unit implements IMovable {
    private int useShield;
    private IntVector2D originVector2D;

    public Wraith(IntVector2D vector2D) {
        super(vector2D, 80, 'W', UnitKind.AIR, 4, 0, 6, Target.BOTH);
        this.useShield = -1;
        this.pos = new ArrayList<>();
        this.pos.add(new IntVector2D(0, 0));
        this.pos.add(new IntVector2D(0, -1));
        this.pos.add(new IntVector2D(1, 0));
        this.pos.add(new IntVector2D(0, 1));
        this.pos.add(new IntVector2D(-1, 0));

        this.originVector2D = new IntVector2D(vector2D.getX(), vector2D.getY());
    }

    protected void addMove(IntVector2D vector2D) {
        this.movePos = vector2D;
    }

    @Override
    public void onSpawn() {
        SimulationManager.getInstance().registerThinkable(this);
        SimulationManager.getInstance().registerMovable(this);
    }

    @Override
    public void onAttacked(int damage) {
        if (this.useShield == -1) {
            this.useShield = 0;
        }

        if (this.useShield == 1) {
            super.onAttacked(damage);
        }
    }

    @Override
    public void think() {
        super.think();
        if (this.getHp() == 0) {
            return;
        }
        if (this.useShield == 0) {
            this.useShield = 1;
        }

        ArrayList<Unit> findedUnits = getFindUnits();

        ArrayList<Unit> airUnits = getAirUnits(findedUnits);
        Unit attack;

        attack = canAttack(airUnits);

        if (attack == null) { // can't attack air
            attack = canAttack(findedUnits);
        }

        if (attack != null) {    // attack
            addAttack(attack);
        } else if (airUnits.size() > 0) {
            goTo(airUnits);
        } else if (findedUnits.size() > 0) { // move
            goTo(findedUnits);
        } else {
            if (this.originVector2D.hashCode() != this.vector2D.hashCode()) {
                IntVector2D move = toMove(originVector2D);
                addMove(move);
            }
        }
    }

    private ArrayList<Unit> getAirUnits(ArrayList<Unit> units) {
        ArrayList<Unit> air = new ArrayList<>();
        for (Unit unit : units) {
            if (unit.unitKind == UnitKind.AIR) {
                air.add(unit);
            }
        }

        return air;
    }


    private void goTo(ArrayList<Unit> findedUnits) {
        if (findedUnits.size() > 1) {
            int min = Integer.MAX_VALUE;
            for (Unit unit : findedUnits) {
                if (min > calcDistance(unit.vector2D)) {
                    min = calcDistance(unit.vector2D);
                }
            }

            for (int i = findedUnits.size() - 1; i >= 0; --i) {
                if (calcDistance(findedUnits.get(i).vector2D) != min) {
                    findedUnits.remove(i);
                }
            }

            if (findedUnits.size() > 1) {
                IntVector2D move = getPriority(findedUnits);
                move = toMove(move);
                addMove(move);
            } else if (findedUnits.size() == 1) { // move
                IntVector2D move = toMove(findedUnits.get(0).vector2D);
                addMove(move);
            } else { // error
                assert false : "finded unit logic error";
            }

        } else if (findedUnits.size() == 1) { // move
            IntVector2D move = toMove(findedUnits.get(0).vector2D);
            addMove(move);
        } else {    // stay
            IntVector2D move = toMove(originVector2D);
            addMove(move);
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

    private IntVector2D toMove(IntVector2D vector2D) {
        if (vector2D.getY() == this.vector2D.getY()) {
            int x = this.vector2D.getX() < vector2D.getX() ? 1 : -1;
            return new IntVector2D(this.vector2D.getX() + x, this.vector2D.getY());
        } else {
            int y = this.vector2D.getY() < vector2D.getY() ? 1 : -1;
            return new IntVector2D(this.vector2D.getX(), this.vector2D.getY() + y);
        }
    }



    @Override
    public void move() {
        if (this.movePos != null) {
            this.vector2D = this.movePos;
            this.movePos = null;
        }
    }

}

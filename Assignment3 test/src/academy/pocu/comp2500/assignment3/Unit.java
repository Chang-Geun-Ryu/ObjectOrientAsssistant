package academy.pocu.comp2500.assignment3;


import java.util.ArrayList;

public abstract class Unit implements IThinkable {
    private final char sign;
    protected final UnitKind unitKind;
    private int vision;
    protected int aoe;
    protected int ap;
    protected final Target target;

    protected int hp;
    protected IntVector2D vector2D;
    protected AttackIntent attackIntent;
    protected IntVector2D movePos;

    protected ArrayList<IntVector2D> pos;
    protected ArrayList<IntVector2D> move;

    protected Unit(IntVector2D vector2D, int hp, char sign, UnitKind unitKind, int vision, int aoe, int ap, Target target) {
        this.vector2D = vector2D;
        this.sign = sign;
        this.unitKind = unitKind;
        this.vision = vision;
        this.aoe = aoe;
        this.ap = ap;
        this.target = target;
        this.hp = hp;
//        this.attackIntent;// = new AttackIntent(vector2D, ap, this);

        this.movePos = null;
    }

    public final IntVector2D getPosition() {
        return this.vector2D;
    }

    public final int getHp() {
        return this.hp;
    }

    public final Target getTarget() {
        return this.target;
    }

    public final UnitKind getUnitKind() {
        return this.unitKind;
    }

    public final AttackIntent attack() {
        return this.attackIntent;
    }

    public void onAttacked(int damage) {
        if (this.hp - damage < 0) {
            this.hp = 0;
        } else {
            this.hp -= damage;
        }
    }

    public abstract void onSpawn();

    public final char getSymbol() {
        return this.sign;
    }

    public final int getAoe() {
        return this.aoe;
    }


    protected ArrayList<Unit> weekUnits(ArrayList<Unit> units) {
        int hp = Integer.MAX_VALUE;
        for (Unit unit : units) {
            if (unit.hp < hp) {
                hp = unit.hp;
            }
        }

        return units;
    }

    protected ArrayList<Unit> getFindUnits() {
        SimulationManager manager = SimulationManager.getInstance();

        ArrayList<Unit> findUnit = new ArrayList<>();
        for (Unit unit : manager.getUnits()) {
            if (canSeeUnit(unit.vector2D, unit.unitKind, this.vision) /*&& canFindUnit(unit.unitKind)*/ && this.hashCode() != unit.hashCode()) {
                findUnit.add(unit);
            }
        }

        return findUnit;
    }

    protected int calcDistance(IntVector2D vector2D) {
        return Math.abs(this.vector2D.getX() - vector2D.getX()) + Math.abs(this.vector2D.getY() - vector2D.getY());
    }

    protected boolean canSeeUnit(IntVector2D vector2D, UnitKind kind, int thisVision) {

        if (kind == UnitKind.UNDER) {
//            return this.unitKind == kind;
            if (this.unitKind != kind) {
                return false;
            }
        } else if (this.target == Target.LAND && kind != UnitKind.LAND) {
            return false;
        } else if (this.target == Target.AIR && kind != UnitKind.AIR) {
            return false;
        }

        int x = Math.abs(this.vector2D.getX() - vector2D.getX());
        int y = Math.abs(this.vector2D.getY() - vector2D.getY());

        if (x <= thisVision && y <= thisVision) {
            return true;
        }

        return false;
    }

    private boolean canFindUnit(UnitKind kind) {
        boolean find = true;

        if (this.target == Target.LAND) {
            find = kind == UnitKind.LAND;
        } else if (this.target == Target.AIR) {
            find = kind == UnitKind.AIR;
        }

        return find;
    }

    protected Unit canAttack(ArrayList<Unit> units) {
        if (units == null || units.size() == 0) {
            return null;
        }
        ArrayList<Unit> attack = new ArrayList<>(units);
//        ArrayList<Unit> attack = units;
        int minHp = Integer.MAX_VALUE;
        for (int i = attack.size() - 1; i >= 0; --i) {
            int x = attack.get(i).getPosition().getX();
            int y = attack.get(i).getPosition().getY();
            boolean isEqual = false;
            for (IntVector2D v : this.pos) {
                if (v.getX() + this.vector2D.getX() == x && v.getY() + this.vector2D.getY() == y) {
                    isEqual = true;
                }

                if (isEqual) {
                    break;
                }
            }

            if (isEqual == false) {
                attack.remove(i);
            } else {
                if (minHp > attack.get(i).getHp()) {
                    minHp = attack.get(i).getHp();
                }
            }
        }

        if (attack == null || attack.size() == 0) {
            return null;
        }

        ArrayList<Unit> weaks = getWeakUnits(attack);

        if (weaks.size() == 1) {
            return weaks.get(0);
        } else if (weaks.size() > 1) {
            for (Unit u : weaks) {
                if (u.getPosition().hashCode() == this.vector2D.hashCode()) {
                    return u;
                }
            }

            return getAnglePriority(weaks);

        } else {
            return null;
        }

    }

    protected Unit canAttack1(ArrayList<Unit> units) {

        ArrayList<Unit> attackableUnit = new ArrayList<>();
        // 00, 북, 동, 남, 서
        for (IntVector2D vector2D : this.pos) {
            int x = this.vector2D.getX() + vector2D.getX();
            int y = this.vector2D.getY() + vector2D.getY();
            IntVector2D attackPos = new IntVector2D(x, y);
            for (int i = 0; i < units.size(); ++i) {
                if (attackPos.hashCode() == units.get(i).vector2D.hashCode() && this.hashCode() != units.get(i).hashCode()) {
                    attackableUnit.add(units.get(i));
                }
            }
        }

        if (attackableUnit.size() == 1) {
            return attackableUnit.get(0);
        } else if (attackableUnit.size() > 1) {
            int min = Integer.MAX_VALUE;
            for (Unit unit : attackableUnit) {
                if (min > unit.getHp()) {
                    min = unit.getHp();
                }
            }

            for (int i = units.size() - 1; i >= 0; --i) {
                if (units.get(i).getHp() != min) {
                    units.remove(i);
                }
            }
            // index가 0에 가까울수록 우선순위가 높다,
            // hp가 낮은 유닛만 골라 놨다
            return units.get(0);
        }

        return null;
    }

    protected ArrayList<Unit> getWeakUnits(ArrayList<Unit> units) {
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

        return units;
    }

    protected Unit getAnglePriority(ArrayList<Unit> units) {
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

        return target;
    }

    protected void addAttack(Unit unit) {
        this.attackIntent = new AttackIntent(unit.getPosition(), this.ap, unit.unitKind, this);
    }

    @Override
    public void think() {
        this.attackIntent = null;
    }

    @Override
    public int hashCode() {
        return System.identityHashCode(this);
    }



}
package academy.pocu.comp2500.assignment3;

import java.util.ArrayList;

public class SmartMine extends Mine {

    public SmartMine(IntVector2D vector2D, int pushCount, int detectUnitCount) {
        super(vector2D, pushCount, detectUnitCount);
    }

    @Override
    public void onSpawn() {
        SimulationManager.getInstance().registerCollisionEventListener(this);
        SimulationManager.getInstance().registerThinkable(this);
    }

    @Override
    public void think() {
        if (this.hp == 0) {
            return;
        }
        ArrayList<Unit> findedUnits = getFindUnits();

        if (this.detectUnitCount <= findedUnits.size()) {
            this.detectUnitCount = 0;
        }

        if (this.detectUnitCount == 0) {
            addAttack(this);
//            for (int i = -aoe; i <= aoe; ++i) {
//                for (int j = -aoe; j <= aoe; ++j) {
//                    int x = this.vector2D.getX() + i;
//                    int y = this.vector2D.getY() + j;
//
//                    int aoeValue = Math.abs(i) <= Math.abs(j) ? Math.abs(j) : Math.abs(i);
//                    int damage = aoeDamage(aoeValue, this.ap);
//
//                    attackPos(this, new IntVector2D(x, y), damage);
//                }
//            }
            this.hp = 0;
        }
    }

    @Override
    public void onAttacked(int damage) {
        if (damage == 0) {
            return;
        }
//        for (int i = -aoe; i <= aoe; ++i) {
//            for (int j = -aoe; j <= aoe; ++j) {
//                int x = this.vector2D.getX() + i;
//                int y = this.vector2D.getY() + j;
//
//                int aoeValue = Math.abs(i) <= Math.abs(j) ? Math.abs(j) : Math.abs(i);
//                int d = aoeDamage(aoeValue, this.ap);
//
//                attackPos(this, new IntVector2D(x, y), d);
//            }
//        }
        this.hp = 0;
    }



    protected void detect() {
        if (this.getHp() == 0) {
            return;
        }

        ArrayList<Unit> findedUnits = getFindUnits();

//        if (this.detectUnitCount <= findedUnits.size()) {
//            this.detectUnitCount = 0;
//        }

        for (Unit unit : findedUnits) {
            if (calcDistance(unit.vector2D) == 0) {
                this.pushCount = this.pushCount - 1 >= 0 ? this.pushCount - 1 : 0;
            }
        }

        if (this.pushCount == 0) {
//            addAttack(this);
            addAttack(this);
//            for (int i = -aoe; i <= aoe; ++i) {
//                for (int j = -aoe; j <= aoe; ++j) {
//                    int x = this.vector2D.getX() + i;
//                    int y = this.vector2D.getY() + j;
//
//                    int aoeValue = Math.abs(i) <= Math.abs(j) ? Math.abs(j) : Math.abs(i);
//                    int damage = aoeDamage(aoeValue, this.ap);
//
//                    attackPos(this, new IntVector2D(x, y), damage);
//                }
//            }
            this.hp = 0;
        }
    }

    private void attackPos(Unit attacker, IntVector2D vector2D, int damage) {
        for (Unit u : SimulationManager.getInstance().getUnits()) {
            if (u.getPosition().hashCode() == vector2D.hashCode()) {
                if (u.hashCode() != attacker.hashCode() && u.getUnitKind() != UnitKind.AIR) {
                    u.onAttacked(damage);
                }
            }
        }
    }

    private int aoeDamage(int aoe, int damage) {
        double aoeDouble = (double) aoe;
        double damageDouble = (double) damage;
        int aoeDamage = (int) (damageDouble * (1.0 - (1.0 / (aoeDouble + 1.0))));
        return aoeDamage > 0 ? aoeDamage : damage;
    }

}

package academy.pocu.comp2500.assignment3;

public class AttackIntent {
    private IntVector2D vector2D;
    private int damage;
    private Unit attacker;
    private UnitKind kind;

    public AttackIntent(IntVector2D vector2D, int damage, UnitKind kind, Unit attacker) {
        this.vector2D = vector2D;
        this.damage = damage;
        this.attacker = attacker;
        this.kind = kind;
    }

    public IntVector2D getVector2D() {
        return this.vector2D;
    }

    public int getDamage() {
        return this.damage;
    }

    public Unit getAttacker() {
        return this.attacker;
    }

    public void attack() {
        int aoe = this.attacker.getAoe();

        if (aoe == 0) {
            attackPos(this.attacker, getVector2D(), getDamage());
        } else if (aoe > 0) {

            for (int i = -aoe; i <= aoe; ++i) {
                for (int j = -aoe; j <= aoe; ++j) {
                    int x = getVector2D().getX() + i;
                    int y = getVector2D().getY() + j;

                    int aoeValue = Math.abs(i) <= Math.abs(j) ? Math.abs(j) : Math.abs(i);
                    int damage = aoeDamage(aoeValue, getDamage());
                    attackPos(this.attacker, new IntVector2D(x, y), damage);
                }
            }
        }
    }

    private void attackPos(Unit attacker, IntVector2D vector2D, int damage) {

        for (Unit u : SimulationManager.getInstance().getUnits()) {
            if (u.getPosition().hashCode() == vector2D.hashCode()) {
                if (u.hashCode() != attacker.hashCode()) {
                    if (isAttack(attacker, u)) {
                        if (this.attacker.getSymbol() == 'D') {
                            u.onAttacked(u.getHp());
                        } else {
                            u.onAttacked(damage);
                        }
                    }
                }
            }
        }
    }

    private boolean isAttack(Unit attacker, Unit unit) {
        if (attacker.getTarget() == Target.LAND) {
            return unit.getUnitKind() != UnitKind.AIR;
        } else if (attacker.getTarget() == Target.AIR) {
            return unit.getUnitKind() == UnitKind.AIR;
        } else {
            return true;
//            return unit.getUnitKind() != UnitKind.UNDER;
        }

    }

    private int aoeDamage(int aoe, int damage) {
        double aoeDouble = (double) aoe;
        double damageDouble = (double) damage;
        int aoeDamage = (int) (damageDouble * (1.0 - (1.0 / (aoeDouble + 1.0))));
        return aoeDamage > 0 ? aoeDamage : damage;
    }

}
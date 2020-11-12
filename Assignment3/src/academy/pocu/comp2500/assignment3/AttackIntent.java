package academy.pocu.comp2500.assignment3;

import java.util.ArrayList;
import java.util.HashSet;

public class AttackIntent {
    private Unit who;
    private IntVector2D target;
    private int ap;
    private int aoe;

    public AttackIntent(Unit who, IntVector2D target, int ap, int aoe) {
        this.who = who;
        this.target = new IntVector2D(target);
        this.ap = ap;
        this.aoe = aoe;
    }

    public void execute() {
        SimulationManager simulationManager = SimulationManager.getInstance();
        ArrayList<Unit> units = new ArrayList<>(simulationManager.getUnits());
        units.remove(who);
        if (who.getSymbol() == 'D') {
            for (Unit unit : units) {
                unit.onAttacked(Integer.MAX_VALUE);
            }
        } else {
            HashSet<UnitType> attackableTypes = who.getAttackableTypes();
            for (Unit unit : units) {
                if (attackableTypes.contains(unit.getUnitType()) && target.getDistance(unit.getPosition()) <= aoe) {
                    double damage = (double) ap * unit.getMultipliedDamage() * (1.0 - (double) (target.getDistance(unit.getPosition())) / ((double) aoe + 1.0));
//                    System.out.println(unit.getNo() + " 이(가) " + who.getNo() + " 로부터 " + damage + " 의 피해를 입음!");
                    unit.onAttacked((int) Math.floor(damage));
                }
            }

        }


    }
}
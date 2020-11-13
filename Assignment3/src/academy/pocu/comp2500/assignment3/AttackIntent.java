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
        if (who.getSymbol() == 'N' || who.getSymbol() == 'A') {
            simulationManager.deathUnit(who);
        }
        ArrayList<Unit> units = new ArrayList<>(simulationManager.getUnits());
        units.remove(who);
        if (who.getSymbol() == 'D') {
            for (Unit unit : units) {
//                if (unit.getSymbol() == 'D') {
                simulationManager.deathUnit(unit);
//                } else {
//                    unit.onAttacked(Integer.MAX_VALUE);
//                    simulationManager.deathUnit(unit);
//                }

//                unit.onAttacked(Integer.MAX_VALUE);

//                simulationManager.deathUnit(unit);
            }
        } else {
            HashSet<UnitType> attackableTypes = who.getAttackableTypes();
            for (Unit unit : units) {
//                System.out.println(who.getNo() + " -> 이 유닛은 어케되나요: " + unit.getNo() + "(" + target.getDistance(unit.getPosition()) + "/" + aoe + ")");
                if (attackableTypes.contains(unit.getUnitType()) && target.getDistance(unit.getPosition()) <= aoe) {
                    double damage = (double) ap * (1.0 - (double) (target.getDistance(unit.getPosition())) / ((double) aoe + 1.0));
                    damage = Math.floor(damage);
                    int calculatedDamage = (int) (damage * unit.getMultipliedDamage());
//                    System.out.println(unit.getNo() + " 이(가) " + who.getNo() + " 로부터 " + calculatedDamage + " 의 피해를 입음!");
                    unit.onAttacked(calculatedDamage);
                }
            }
        }
        /*
        HashSet<UnitType> attackableTypes = who.getAttackableTypes();
        for (Unit unit : units) {
            if (attackableTypes.contains(unit.getUnitType()) && target.getDistance(unit.getPosition()) <= aoe) {
                double damage = (double) ap * (1.0 - (double) (target.getDistance(unit.getPosition())) / ((double) aoe + 1.0));
                damage = Math.floor(damage);
                int calculatedDamage = (int) (damage * unit.getMultipliedDamage());
                if (who.getSymbol() == 'D') {
                    calculatedDamage = Integer.MAX_VALUE;
                }
                unit.onAttacked(calculatedDamage);
            }
        }
        */


    }
}
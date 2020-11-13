package academy.pocu.comp2500.assignment3;

import java.util.ArrayList;

public class AttackIntent {

    private IntVector2D attackTile;
    private ArrayList<Unit> multiTarget;
    private Unit attackingUnit;

    public AttackIntent(Unit attackingUnit, IntVector2D attackTile) {
        multiTarget = null;
        this.attackTile = attackingUnit.targetPosition;
        this.attackingUnit = attackingUnit;
    }

    public AttackIntent(ArrayList<Unit> multiTarget, Unit attackingUnit) {
        this(attackingUnit, null);
        this.multiTarget = multiTarget;
    }

    public void executeAttack() {
        if (attackTile != null) {
            normalAttack();
        } else if (multiTarget != null) {
            multiTargetAttack(multiTarget);
        }
    }

    private void normalAttack() {
        for (Unit unit : SimulationManager.getInstance().getUnits()) {
            if (unit.position.equals(this.attackTile)
                    && unit != attackingUnit) {
                unit.onAttacked(attackingUnit.ap);
            }
            if (attackingUnit.getAoe() > 0) {
                splashAttack(unit);
            }
        }
    }

    private void multiTargetAttack(ArrayList<Unit> multiTarget) {
        for (Unit unit : multiTarget) {
            if (unit == attackingUnit) {
                continue;
            }
            unit.onAttacked(attackingUnit.getAp());
        }
    }

    private void splashAttack(Unit unit) {
        int minXboarder;
        int maxXboarder;
        int minYboarder;
        int maxYboarder;
        int boarderDistance;
        for (int i = 0; i < attackingUnit.getAoe(); i++) {
            boarderDistance = i + 1;
            minXboarder = attackTile.getX() - boarderDistance;
            maxXboarder = attackTile.getX() + boarderDistance;
            minYboarder = attackTile.getY() - boarderDistance;
            maxYboarder = attackTile.getY() + boarderDistance;

            if ((minXboarder == unit.getPosition().getX() && unit.getPosition().getY() <= maxYboarder && unit.getPosition().getY() >= minYboarder)
                    || (maxXboarder == unit.getPosition().getX() && unit.getPosition().getY() <= maxYboarder && unit.getPosition().getY() >= minYboarder)
                    || (minYboarder == unit.getPosition().getY() && unit.getPosition().getX() <= maxXboarder && unit.getPosition().getX() >= minXboarder)
                    || (maxYboarder == unit.getPosition().getY() && unit.getPosition().getX() <= maxXboarder && unit.getPosition().getX() >= minXboarder)) {
                unit.onAttacked((int) (attackingUnit.getAp() * (1.0 - boarderDistance / (double) (attackingUnit.getAoe() + 1))));
            }
        }
    }
}

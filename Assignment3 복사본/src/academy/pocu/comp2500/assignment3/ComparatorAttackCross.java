package academy.pocu.comp2500.assignment3;

import java.util.Comparator;

public class ComparatorAttackCross implements Comparator<Unit> {
    private int targetX;
    private int targetY;

    public ComparatorAttackCross(int targetX, int targetY) {
        this.targetX = targetX;
        this.targetY = targetY;
    }

    @Override
    public int compare(Unit o1, Unit o2) {
        int priority1 = getPriority(o1);
        int priority2 = getPriority(o2);
        return priority1 - priority2;
    }

    private int getPriority(Unit unit) {
        if (unit.getPosition().getX() == targetX && unit.getPosition().getY() == targetY) {
            return 0;
        } else if (unit.getPosition().getY() < targetY) {
            return 1;
        } else if (unit.getPosition().getX() > targetX) {
            return 2;
        } else if (unit.getPosition().getY() > targetY) {
            return 3;
        } else {
            return 4;
        }
    }
}

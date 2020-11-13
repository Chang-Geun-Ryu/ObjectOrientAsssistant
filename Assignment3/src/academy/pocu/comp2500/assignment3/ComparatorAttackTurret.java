package academy.pocu.comp2500.assignment3;

import java.util.Comparator;

public class ComparatorAttackTurret implements Comparator<Unit> {
    private static final int[][] PRIORITY = new int[][]{{8, 1, 2}, {7, 0, 3}, {6, 5, 4}};

    private final int targetX;
    private final int targetY;

    public ComparatorAttackTurret(int targetX, int targetY) {
        this.targetX = targetX;
        this.targetY = targetY;
    }

    @Override
    public int compare(Unit o1, Unit o2) {
        return getPriority(o1) - getPriority(o2);
    }

    private int getPriority(Unit unit) {
        int x = unit.getPosition().getX() - targetX;
        int y = unit.getPosition().getY() - targetY;
        return PRIORITY[1 + y][1 + x];
    }
}

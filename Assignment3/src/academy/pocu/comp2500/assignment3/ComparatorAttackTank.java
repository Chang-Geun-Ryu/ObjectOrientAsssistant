package academy.pocu.comp2500.assignment3;

import java.util.Comparator;

public class ComparatorAttackTank implements Comparator<Unit> {
    private static final int[][] PRIORITY = new int[][]{{99, 11, 0, 1, 99}, {10, 99, 99, 99, 2}, {9, 99, 99, 99, 3}, {8, 99, 99, 99, 4}, {99, 7, 6, 5, 99}};

    private final int targetX;
    private final int targetY;

    public ComparatorAttackTank(int targetX, int targetY) {
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
        return PRIORITY[2 + y][2 + x];
    }
}

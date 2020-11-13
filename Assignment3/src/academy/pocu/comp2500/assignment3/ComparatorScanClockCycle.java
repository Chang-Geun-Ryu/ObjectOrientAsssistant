package academy.pocu.comp2500.assignment3;

import java.util.Comparator;

public class ComparatorScanClockCycle implements Comparator<Unit> {
    private static final int[][] PRIORITY_VISION_2 = new int[][]{{23, 24, 2, 4, 5}, {22, 21, 1, 3, 6}, {20, 19, 0, 7, 8}, {18, 15, 13, 9, 10}, {17, 16, 14, 12, 11}};
    private static final int[][] PRIORITY_VISION_4 = new int[][]{{74, 75, 77, 80, 4, 8, 11, 13, 14}, {73, 72, 76, 79, 3, 7, 10, 12, 15}, {71, 70, 69, 78, 2, 6, 9, 16, 17}, {68, 67, 66, 65, 1, 5, 18, 19, 20}, {64, 63, 62, 61, 0, 21, 22, 23, 24}, {60, 59, 58, 45, 41, 25, 26, 27, 28}, {57, 56, 49, 46, 42, 38, 29, 30, 31}, {55, 52, 50, 47, 43, 39, 36, 32, 33}, {54, 53, 51, 48, 44, 40, 37, 35, 34}};

    private final int targetX;
    private final int targetY;
    private final int vision;

    public ComparatorScanClockCycle(int targetX, int targetY, int vision) {
        this.targetX = targetX;
        this.targetY = targetY;
        this.vision = vision;
    }

    @Override
    public int compare(Unit o1, Unit o2) {
        return getPriority(o1) - getPriority(o2);
    }

    private int getPriority(Unit unit) {
        int x = unit.getPosition().getX() - targetX;
        int y = unit.getPosition().getY() - targetY;
        switch (vision) {
            case 2:
                return PRIORITY_VISION_2[vision + y][vision + x];
            case 4:
                return PRIORITY_VISION_4[vision + y][vision + x];
            default:
                assert (false) : "Invalid vision!";
                return -1;
        }
    }
}

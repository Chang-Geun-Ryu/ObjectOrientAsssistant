//package academy.pocu.comp2500.assignment3;
//
//import java.util.Comparator;
//
//public class ComparatorClockCycle implements Comparator<Unit> {
//    private int targetX;
//    private int targetY;
//    private int distance;
//
//    public ComparatorClockCycle(int targetX, int targetY, int distance) {
//        this.targetX = targetX;
//        this.targetY = targetY;
//        this.distance = distance;
//    }
//
//    @Override
//    public int compare(Unit o1, Unit o2) {
//        int quadrant1 = getQuadrant(o1);
//        int quadrant2 = getQuadrant(o2);
//        if (quadrant1 == quadrant2) {
//            switch (quadrant1) {
//                case 1:
//                    if (o1.getPosition().getY() == o2.getPosition().getY()) {
//                        return (o1.getPosition().getX() - o2.getPosition().getX());
//                    } else {
//                        return (o2.getPosition().getY() - o1.getPosition().getY());
//                    }
//                case 2:
//                    if (o1.getPosition().getY() == o2.getPosition().getY()) {
//                        return (o2.getPosition().getX() - o1.getPosition().getX());
//                    } else {
//                        return (o1.getPosition().getY() - o2.getPosition().getY());
//                    }
//                case 3:
//                    if (o1.getPosition().getY() == o2.getPosition().getY()) {
//                        return (o1.getPosition().getX() - o2.getPosition().getX());
//                    } else {
//                        return (o2.getPosition().getY() - o1.getPosition().getY());
//                    }
//                case 4:
//                    if (o1.getPosition().getY() == o2.getPosition().getY()) {
//                        return (o2.getPosition().getX() - o1.getPosition().getX());
//                    } else {
//                        return (o1.getPosition().getY() - o2.getPosition().getY());
//                    }
//                default:
//                    assert (false) : "Invalid Quadrant!";
//                    return 0;
//            }
//        } else {
//            return (quadrant1 > quadrant2) ? 1 : -1;
//        }
//    }
//
//    private int getQuadrant(Unit unit) {
//        if (unit.getPosition().getY() == targetY - distance) {
//            if (unit.getPosition().getX() - targetX >= 0) {
//                return 1;
//            } else {
//                return 4;
//            }
//        } else if (unit.getPosition().getY() == targetY + distance) {
//            if (unit.getPosition().getX() - targetX <= 0) {
//                return 3;
//            } else {
//                return 2;
//            }
//        } else if (unit.getPosition().getY() == targetY) {
//            if (unit.getPosition().getX() - targetX > 0) {
//                return 2;
//            } else {
//                return 4;
//            }
//        } else if (unit.getPosition().getY() - targetY > 0) {
//            if (unit.getPosition().getX() - targetX > 0) {
//                return 1;
//            } else {
//                return 4;
//            }
//        } else {
//            if (unit.getPosition().getX() - targetX > 0) {
//                return 2;
//            } else {
//                return 3;
//            }
//        }
//    }
//}

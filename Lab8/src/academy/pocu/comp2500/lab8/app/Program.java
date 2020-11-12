package academy.pocu.comp2500.lab8.app;

import academy.pocu.comp2500.lab8.Drainer;
import academy.pocu.comp2500.lab8.Planter;
import academy.pocu.comp2500.lab8.Schedule;
import academy.pocu.comp2500.lab8.Sprinkler;

public class Program {

    public static void main(String[] args) {
        {
//            Sprinkler sprinkler = new Sprinkler();
//            sprinkler.addSchedule(new Schedule(12, 6));
//            sprinkler.addSchedule(new Schedule(19, 10));
//            sprinkler.addSchedule(new Schedule(36, 10));
//            sprinkler.addSchedule(new Schedule(51, 2));
//            sprinkler.addSchedule(new Schedule(64, 7));
//            sprinkler.addSchedule(new Schedule(86, 10));
//            sprinkler.addSchedule(new Schedule(103, 2));
//
//            Drainer drainer = new Drainer(76);
//
//            Planter planter = new Planter(96);

        Sprinkler sprinkler = new Sprinkler();
        sprinkler.addSchedule(new Schedule(1, 9));
        sprinkler.addSchedule(new Schedule(21, 10));
        sprinkler.addSchedule(new Schedule(36, 9));
        sprinkler.addSchedule(new Schedule(49, 7));
        sprinkler.addSchedule(new Schedule(72, 7));
        sprinkler.addSchedule(new Schedule(95, 3));
        sprinkler.addSchedule(new Schedule(105, 3));

        Drainer drainer = new Drainer(110);

        Planter planter = new Planter(13);

            planter.installSmartDevice(drainer);
            planter.installSmartDevice(sprinkler);

            for (int i = 0; i < 25; ++i) {
                System.out.print(String.format("%d: ", i));
                System.out.println(planter.getWaterAmount());
                planter.tick();
            }
        }
//        {
//            Sprinkler sprinkler = new Sprinkler();
//
//            sprinkler.addSchedule(new Schedule(0, 4));
//            sprinkler.addSchedule(new Schedule(2, 3));
//            sprinkler.addSchedule(new Schedule(6, 4));
//
//            boolean[] expectedIsOn = new boolean[]{false, true, true, true, true, false, false,
//                    true, true, true, true, false, false};
//
//            for (int i = 0; i < expectedIsOn.length; ++i) {
//                System.out.print(String.format("%d: ", i));
//                System.out.println(sprinkler.isOn());
//                assert (expectedIsOn[i] == sprinkler.isOn());
//                sprinkler.onTick();
//            }
//        }
//
//        {
//            Sprinkler sprinkler = new Sprinkler();
//
//            sprinkler.addSchedule(new Schedule(3, 20));
//            Drainer drainer = new Drainer(50);
//
//            Planter planter = new Planter(0);
//            planter.installSmartDevice(sprinkler);
//            planter.installSmartDevice(drainer);
//
//            int[] expectedWaterAmount = new int[]{0, 0, 0, 0, 13, 26, 39, 52, 58, 64,
//                    70, 76, 82, 88, 94, 100, 106, 112, 118, 124,
//                    130, 136, 142, 148, 139, 130, 121, 112, 103, 94,
//                    85, 76, 67, 58, 49, 47, 45, 43, 41, 39,
//                    37, 35, 33, 31, 29, 27, 25, 23, 21, 19};
//
//            int[] sprinklerTicksSinceLastUpdate = new int[]{0, 1, 2, 3, 1, 2, 3, 4, 5, 6,
//                    7, 8, 9, 10, 11, 12, 13, 14, 15, 16,
//                    17, 18, 19, 20, 1, 2, 3, 4, 5, 6,
//                    7, 8, 9, 10, 11, 12, 13, 14, 15, 16,
//                    17, 18, 19, 20, 21, 22, 23, 24, 25, 26};
//            int[] drainerTicksSinceLastUpdate = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 1, 2,
//                    3, 4, 5, 6, 7, 8, 9, 10, 11, 12,
//                    13, 14, 15, 16, 17, 18, 19, 20, 21, 22,
//                    23, 24, 25, 26, 27, 1, 2, 3, 4, 5,
//                    6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
//
//            for (int i = 0; i < expectedWaterAmount.length; ++i) {
//                System.out.print(String.format("%d WaterAmount: %d ", i, planter.getWaterAmount()));
//                System.out.print(expectedWaterAmount[i] == planter.getWaterAmount());
//                System.out.print(String.format(", %d TicksSinceLastUpdate: %d ", i, sprinkler.getTicksSinceLastUpdate()));
//                System.out.print(sprinklerTicksSinceLastUpdate[i] == sprinkler.getTicksSinceLastUpdate());
//                System.out.print(String.format(", %d TicksSinceLastUpdate: %d ", i, drainer.getTicksSinceLastUpdate()));
//                System.out.println(drainerTicksSinceLastUpdate[i] == drainer.getTicksSinceLastUpdate());
//
//                assert (expectedWaterAmount[i] == planter.getWaterAmount());
//                assert (sprinklerTicksSinceLastUpdate[i] == sprinkler.getTicksSinceLastUpdate());
//                assert (drainerTicksSinceLastUpdate[i] == drainer.getTicksSinceLastUpdate());
//                planter.tick();
//            }
//        }
    }
}
package academy.pocu.comp2500.lab8.app;

import academy.pocu.comp2500.lab8.Drainer;
import academy.pocu.comp2500.lab8.Planter;
import academy.pocu.comp2500.lab8.Schedule;
import academy.pocu.comp2500.lab8.Sprinkler;

public class Program {

    public static void main(String[] args) {
	    // write your code here

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
}

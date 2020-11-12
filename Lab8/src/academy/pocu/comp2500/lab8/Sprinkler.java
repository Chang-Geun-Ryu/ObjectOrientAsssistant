package academy.pocu.comp2500.lab8;

import java.util.ArrayList;

public class Sprinkler extends SmartDevice implements ISprayable {
    private final int WATER = 15;
    private final ArrayList<Schedule> S = new ArrayList<>();
    private Schedule onSchedule;
    private int keepSprayTick;


    public Sprinkler() {
        this.tick = 0;
        this.switchTick = 0;
        this.isOn = false;
        this.keepSprayTick = 0;
        this.onSchedule = null;
    }

    public void addSchedule(Schedule schedule) {
        S.add(schedule);
    }

    @Override
    public void addInstall(Planter planter) {
        planter.installSprinkler(this);
    }

    private Schedule getScheduleOrNull() {
        ArrayList<Schedule> removeItems = new ArrayList<>();
        Schedule pickSchedule = null;

        for (Schedule schedule : S) {
            removeItems.add(schedule);

            if (schedule.getStartTick() != 0 && this.tick <= schedule.getStartTick() + schedule.getKeep()) {
                pickSchedule = schedule;
                break;
            }
        }

        S.removeAll(removeItems);

        return pickSchedule;
    }

    private boolean processeSchedule() {
        Schedule schedule = getScheduleOrNull();
        if (schedule != null) {
            int startTick = schedule.getStartTick();
            int keepTick = schedule.getKeep();

            if (this.tick > startTick) {

            } else {

            }
        }

        return false;
    }

    @Override
    public void onTick() {
        this.tick += 1;
        // start
        if (this.onSchedule == null) {
            this.onSchedule = getScheduleOrNull();
        }

        // process on/off
        if (this.isOn) {
            if (this.tick == this.onSchedule.getStartTick() + this.onSchedule.getKeep()) {
                this.isOn = false;
                switchTick = this.tick;
            }
        } else {
            if (this.onSchedule != null && this.onSchedule.getStartTick() == this.tick) {
                this.isOn = true;
                switchTick = this.tick;
            }
        }

        // end 처리
        if (this.onSchedule != null && this.tick >= this.onSchedule.getStartTick() + this.onSchedule.getKeep()) {
            this.onSchedule = null;
        }

    }

    @Override
    public void spray(Planter planter) {
        if (this.isOn) {
            planter.sprayWater(WATER);
        }
    }


//    @Override
//    public void spray(Planter planter) {
//        if (this.isOn) {
////            planter.
//        }
//    }
}

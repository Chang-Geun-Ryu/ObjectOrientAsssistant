package academy.pocu.comp2500.lab8;

import java.util.ArrayList;

public class Sprinkler extends SmartDevice implements ISprayable {
    private ArrayList<Schedule> schedules;

    private int scheduleIndex;
    public Sprinkler() {
        super();
        super.type = DeviceType.SPRINKLER;
        this.schedules = new ArrayList<>();
        this.scheduleIndex = 0;
    }

    public void addSchedule(Schedule schedule) {
        this.schedules.add(schedule);
    }

    @Override
    public void spray(Planter planter) {
//        int waterAmount = planter.getWaterAmount() + 15;
//        planter.setWaterAmount(waterAmount);
        planter.increaseWaterAmount(15);
    }

    @Override
    public void onTick() {
        super.currentTick += 1;
        this.manageSchedule();
    }

    private void manageSchedule() {
        if (this.schedules.size() == 0) {
            return;
        }

//        for (Schedule schedule : this.schedules) {
//            // check schedule condition
//            if (schedule.getStartTick() <= 0) {
//                continue;
//            }
//
//            if (schedule.getStartTick() <= super.currentTick
//                    && super.currentTick <= schedule.getStartTick() + schedule.getDuration()) {
//                // determine activator
//                // System.out.format("current tick: %s\n", super.currentTick);
//                boolean activator;
//                if ((schedule.getStartTick() == super.currentTick) || (schedule.getDuration() == super.getTicksSinceLastUpdate())) {
//                    activator = !super.isOn;
//                    super.activateOrDeactivate(activator);
//                }
//
//                break;
//            }
//        }
        while (this.scheduleIndex < this.schedules.size() && !isValidSchedule(schedules.get(this.scheduleIndex))) {
            ++this.scheduleIndex;
        }
        if (this.scheduleIndex == this.schedules.size()) {
            return;
        }
        Schedule schedule = this.schedules.get(this.scheduleIndex);

        if (schedule.getStartTick() == super.currentTick) {
            if (isOn) {
                super.activateOrDeactivate(false);
            } else {
                super.activateOrDeactivate(true);
            }
        }

        if (schedule.getStartTick() + schedule.getDuration() == super.currentTick && super.isOn) {
            if (isOn) {
                super.activateOrDeactivate(false);
            } else {
                super.activateOrDeactivate(true);
            }
        }
    }

    public boolean isValidSchedule(Schedule schedule) {
        return schedule.getStartTick() != 0 && schedule.getStartTick() + schedule.getDuration() >= super.currentTick;
    }
}

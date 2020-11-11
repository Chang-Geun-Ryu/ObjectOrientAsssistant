package academy.pocu.comp2500.lab8;

import java.util.ArrayList;

public class Sprinkler extends SmartDevice implements ISprayable {
    private ArrayList<Schedule> schedules;
    private int scheduleIndex;
    private final int SPRAY_AMOUNT = 15;

    public Sprinkler() {
        super(DeviceType.SPRINKLER);
        this.schedules = new ArrayList<>();
        this.scheduleIndex = 0;
    }

    public ArrayList<Schedule> getSchedules() {
        return this.schedules;
    }

    public void addSchedule(Schedule schedule) {
        this.schedules.add(schedule);
    }

    @Override
    public void onTick() {
        super.increaseTicks();
        while (this.scheduleIndex < this.schedules.size() && !isValidSchedule(schedules.get(this.scheduleIndex))) {
            this.increaseScheduleIndex();
        }
        if (this.scheduleIndex == this.schedules.size()) {
            return;
        }
        Schedule schedule = this.schedules.get(this.scheduleIndex);

        if (schedule.getStartTick() == this.getTicks()) {
            super.changeState();
            super.updateTicksSinceLastUpdate();
        }

        if (schedule.getStartTick() + schedule.getDuration() == this.getTicks() && super.isOn()) {
            super.changeState();
            super.updateTicksSinceLastUpdate();
        }
    }

    @Override
    public void spray(Planter planter) {
        if (super.isOn()) {
            planter.setWaterAmount(planter.getWaterAmount() + this.SPRAY_AMOUNT);
        }
    }


    public boolean isValidSchedule(Schedule schedule) {
        return schedule.getStartTick() != 0 && schedule.getStartTick() + schedule.getDuration() >= super.getTicks();
    }

    public void increaseScheduleIndex() {
        ++this.scheduleIndex;
    }


}

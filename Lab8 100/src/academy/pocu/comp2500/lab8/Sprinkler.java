package academy.pocu.comp2500.lab8;

import java.util.ArrayList;

public class Sprinkler extends SmartDevice implements ISprayable {
    private ArrayList<Schedule> schedules;
    private int scheduleIndex;
    private final int SPRAY_AMOUNT = 15;

    public Sprinkler() {
        super(EDeviceKind.SPRINKLER);
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

        if (schedule.getOnTick() == this.getTicks()) {
            super.changeState();
            super.updateTicksSinceLastUpdate();
        }

        if (schedule.getOffTick() == this.getTicks() && super.isOn()) {
            super.changeState();
            super.updateTicksSinceLastUpdate();
        }
    }

    @Override
    public void spray(Planter planter) {
        if (super.isOn()) {
            planter.increaseWaterAmount(this.SPRAY_AMOUNT);
        }
    }


    public boolean isValidSchedule(Schedule schedule) {
        return schedule.getOnTick() != 0 && schedule.getOffTick() >= super.getTicks();
    }

    public void increaseScheduleIndex() {
        ++this.scheduleIndex;
    }

}

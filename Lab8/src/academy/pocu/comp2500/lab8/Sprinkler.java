package academy.pocu.comp2500.lab8;

import java.util.ArrayList;

public class Sprinkler extends SmartDevice implements ISprayable {
    private static final int AMOUNT_OF_WATER_SPRAYING_IN_LITRE = 15;
    private int currentTicks;
    private ArrayList<Schedule> schedules;
    private int indexOfSchedules;
    private int ticksSinceLastUpdate;

    public Sprinkler() {
        super.smartDeviceType = SmartDeviceType.SPRINKLER;
        this.schedules = new ArrayList<Schedule>();
    }

    public void addSchedule(Schedule schedule) {
        this.schedules.add(schedule);
    }

    @Override
    public boolean isOn() {
        return super.isOn;
    }

    @Override
    public void onTick() {
        ++this.currentTicks;
        if (!super.isOn) {
            for (int index = indexOfSchedules; index < this.schedules.size(); ++index) {
                if (this.schedules.get(indexOfSchedules).getTicksWhenOn() + this.schedules.get(indexOfSchedules).getTicksWhenOff() < currentTicks
                        || this.schedules.get(indexOfSchedules).getTicksWhenOn() == 0) {
                    ++this.indexOfSchedules;
                }
            }
        }

        if (this.indexOfSchedules >= this.schedules.size()) {
            ++this.ticksSinceLastUpdate;
            return;
        }

        if (super.isOn) {
            if (this.ticksSinceLastUpdate + 1 == this.schedules.get(indexOfSchedules).getTicksWhenOff()) {
                super.isOn = false;
                this.ticksSinceLastUpdate = 0;
            } else {
                ++this.ticksSinceLastUpdate;
            }
        } else {
            if (currentTicks == this.schedules.get(this.indexOfSchedules).getTicksWhenOn()) {
                super.isOn = true;
                this.ticksSinceLastUpdate = 0;
            } else {
                ++this.ticksSinceLastUpdate;
            }
        }
    }

    @Override
    public int getTicksSinceLastUpdate() {
        return this.ticksSinceLastUpdate;
    }

    @Override
    public void spray(Planter planter) {
        planter.sprayWater(AMOUNT_OF_WATER_SPRAYING_IN_LITRE);
    }
}

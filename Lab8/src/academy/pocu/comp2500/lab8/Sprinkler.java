package academy.pocu.comp2500.lab8;

import java.util.ArrayList;

public class Sprinkler extends SmartDevice implements ISprayable {
    private final static int SPRAY_AMOUNT_PER_TICK = 15;

    private final ArrayList<Schedule> schedules;
    private Schedule currentSchedule;

    public Sprinkler() {
        this.schedules = new ArrayList<>();
        this.eSmartDeviceType = ESmartDeviceType.SPRINKER;
    }

    @Override
    public void onTick() {
        currentTick++;
        ArrayList<Schedule> tempSchedule = new ArrayList<>(schedules);
        if (!isOn) {
            currentSchedule = null;
        }

        //스케쥴 선택 조건 -> 이전의 스케쥴이 끝나야 다음 스케쥴을 찾을 수 있도록 수정해야됨
        if (currentSchedule == null && !isOn) {
                ArrayList<Schedule> removeItems = new ArrayList<>();

                for (Schedule schedule : schedules) {
                    removeItems.add(schedule);

                    if (this.currentTick < schedule.getTickOffTick()) {
                        currentSchedule = schedule;
                        break;
                    }
                }

            schedules.removeAll(removeItems);

        }

        preDeviceState = isOn;

        //스프링클러 작동조건
        if (currentSchedule != null) {
            if (currentTick == currentSchedule.getTickOnNumber() && !isOn) {
                isOn = true;
            } else if (currentTick >= currentSchedule.getTickOffTick() && isOn) {
                schedules.remove(currentSchedule);
                isOn = false;
            }
        }

        //갱신 되었는지 하여 LastUpdate Tick
        if (isOn == preDeviceState) {
            deviceStateChangedTick++;
        } else {
            deviceStateChangedTick = 0;
        }

    }

    @Override
    public int getTicksSinceLastUpdate() {
        return deviceStateChangedTick;
    }

    public void addSchedule(Schedule schedule) {
        this.schedules.add(schedule);
    }

    @Override
    public void spray(Planter planter) {
        onTick();
        if (isOn) {
            planter.addWaterAmount(SPRAY_AMOUNT_PER_TICK);
        }
    }
}

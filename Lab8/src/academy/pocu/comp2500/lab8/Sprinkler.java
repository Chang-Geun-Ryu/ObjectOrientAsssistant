package academy.pocu.comp2500.lab8;

import java.util.ArrayList;

public class Sprinkler extends SmartDevice implements ISprayable {
    private static final int SPRAY_AMOUNT = 15;
    private ArrayList<Schedule> schedules = new ArrayList<>();

    public Sprinkler() {
        super();
    }

    public void addSchedule(Schedule schedule) {
        // 유효하지 않은 스케줄
        if (schedule.getStartTick() == 0) {
            return;
        }

        // 첫 스케줄
        if (schedules.isEmpty()) {
            schedules.add(schedule);
            return;
        }

        // 기존 스케줄과 겹치지 않는 경우에만 스케줄에 추가
        Schedule lastSchedule = schedules.get(schedules.size() - 1);
        int lastStopTick = lastSchedule.getStopTick();
        int newStartTick = schedule.getStartTick();

        if (newStartTick > lastStopTick) {
            schedules.add(schedule);
        }
    }

    @Override
    public void spray(Planter planter) {
        if (isOn()) {
            planter.addWater(SPRAY_AMOUNT);
        }
    }

    @Override
    public void onTick() {
        tick++;
        ticksSinceLastUpdate++;

        // 지난 스케줄 삭제
        schedules.removeIf(schedule -> tick > schedule.getStopTick());

        // 스케줄이 비어있는 경우
        if (schedules.isEmpty()) {
            updateOn(false);
            return;
        }

        // on/off 여부
        Schedule schedule = schedules.get(0);
        int startTick = schedule.getStartTick();
        int stopTick = schedule.getStopTick();

        if (!isOn() && tick == startTick) {
            // 꺼짐 -> 켜짐
            updateOn(true);
        } else if (isOn() && tick == stopTick) {
            // 켜짐 -> 꺼짐
            updateOn(false);
        }
    }
}

package academy.pocu.comp2500.lab8;

public class Schedule {
    private int startTick;
    private int repeat;

    public Schedule(int startTick, int repeat) {
        this.startTick = startTick;
        this.repeat = repeat;
    }

    public int getStartTick() {
        return startTick;
    }

    public int getRepeat() {
        return repeat;
    }

    public int getStopTick() {
        return startTick + repeat;
    }
}

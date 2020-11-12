package academy.pocu.comp2500.lab8;

public class Schedule {
    private final int startTick;
    private final int duration;

    public Schedule(int startTick, int duration) {
        this.startTick = startTick;
        this.duration = duration;
    }

    public int getStartTick() {
        return this.startTick;
    }

    public int getDuration() {
        return this.duration;
    }
}

package academy.pocu.comp2500.lab8;

public class Schedule {
    private int tick;
    private int keep;

    public Schedule(int tick, int keep) {
        this.tick = tick;
        this.keep = keep;
    }

    public int getStartTick() {
        return this.tick;
    }

    public int getKeep() {
        return this.keep;
    }
}

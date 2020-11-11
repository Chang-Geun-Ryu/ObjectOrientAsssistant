package academy.pocu.comp2500.lab8;

public class Schedule {
    private int startTick;
    private int workingTick;
    public Schedule(int startTick, int workingTick) {
        this.startTick = startTick;
        this.workingTick = workingTick;
    }

    public int getOnTick() {
        return startTick;
    }

    public int getOffTick() {
        return this.startTick + this.workingTick;
    }

}

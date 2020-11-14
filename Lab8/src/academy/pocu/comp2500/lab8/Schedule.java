package academy.pocu.comp2500.lab8;

public class Schedule {
    private int tickOnNumber;
    private int tickOffCount;

    public Schedule(int tickOnNumber, int tickOffCount) {
        this.tickOnNumber = tickOnNumber;
        this.tickOffCount = tickOffCount;
    }

    public int getTickOnNumber() {
        return tickOnNumber;
    }

    public int getTickOffTick() {
        return tickOnNumber + tickOffCount;
    }
}

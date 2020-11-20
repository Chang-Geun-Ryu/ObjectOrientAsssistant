package academy.pocu.comp2500.lab8;

public class Schedule {
    private int ticksWhenOn;
    private int ticksWhenOff;

    public Schedule(int ticksWhenOn, int ticksWhenOff) {
        this.ticksWhenOn = ticksWhenOn;
        this.ticksWhenOff = ticksWhenOff;
    }

    public int getTicksWhenOn() {
        return this.ticksWhenOn;
    }

    public int getTicksWhenOff() {
        return this.ticksWhenOff;
    }
}

package academy.pocu.comp2500.lab8;

public abstract class SmartDevice {
    protected int tick;
    protected int ticksSinceLastUpdate;
    private boolean on;

    public final boolean isOn() {
        return on;
    }

    public abstract void onTick();

    public final int getTicksSinceLastUpdate() {
        return ticksSinceLastUpdate;
    }

    protected final void updateOn(boolean on) {
        if (this.on != on) {
            ticksSinceLastUpdate = 0;
        }

        this.on = on;
    }
}

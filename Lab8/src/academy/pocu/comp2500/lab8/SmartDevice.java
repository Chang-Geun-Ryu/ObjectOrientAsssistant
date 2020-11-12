package academy.pocu.comp2500.lab8;

public abstract class SmartDevice {
    protected boolean isOn;
    protected int switchTick;
    protected int tick;

    public boolean isOn() {
        return this.isOn;
    }

    public abstract void onTick();

    public abstract void addInstall(Planter planter);

    public int getTicksSinceLastUpdate() {
        return this.tick - this.switchTick;
    }

}

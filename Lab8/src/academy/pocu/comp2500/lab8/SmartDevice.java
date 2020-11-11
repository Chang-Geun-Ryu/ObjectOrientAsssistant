package academy.pocu.comp2500.lab8;

public abstract class SmartDevice {
    protected DeviceType type;
    protected boolean isOn;
    protected int currentTick;
    protected int tickLastUpdated;

    protected SmartDevice() {
        this.isOn = false;
    }

    public enum DeviceType {
        DRAINER,
        SPRINKLER
    }

    public DeviceType getType() {
        return this.type;
    }

    public boolean isOn() {
        return this.isOn;
    }

    public int getCurrentTick() {
        return this.currentTick;
    }

    public abstract void onTick();

    public int getTicksSinceLastUpdate() {
        return this.currentTick - this.tickLastUpdated;
    }

    protected void activateOrDeactivate(boolean activator) {
        this.isOn = activator;
        this.tickLastUpdated = currentTick;
    }
}

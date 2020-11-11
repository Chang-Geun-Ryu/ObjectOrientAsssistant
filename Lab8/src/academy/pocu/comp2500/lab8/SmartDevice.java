package academy.pocu.comp2500.lab8;

public abstract class SmartDevice {
    private DeviceType deviceKind;
    private int ticks;
    private boolean isOn;
    private int ticksSinceLastUpdate;

    public SmartDevice(DeviceType deviceKind) {
        this.ticks = 0;
        this.isOn = false;
        this.ticksSinceLastUpdate = 0;
        this.deviceKind = deviceKind;
    }

    public boolean isOn() {
        return this.isOn;
    }

    public void changeState() {
        if (this.isOn) {
            this.isOn = false;
        } else {
            this.isOn = true;
        }
    }

    protected void increaseTicks() {
        ++this.ticks;
    }

    public abstract void onTick();
    public int getTicksSinceLastUpdate() {
        return this.ticks - this.ticksSinceLastUpdate;
    }

    public int getTicks() {
        return ticks;
    }

    protected void updateTicksSinceLastUpdate() {
        this.ticksSinceLastUpdate = this.ticks;
    }

    public DeviceType getDeviceKind() {
        return this.deviceKind;
    }

    public enum DeviceType {
        DRAINER,
        SPRINKLER
    }

    /*
    protected DeviceType type;
    protected boolean isOn;
    protected int currentTick;
    protected int tickLastUpdated;

    protected SmartDevice() {
        this.isOn = false;
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
    */
}

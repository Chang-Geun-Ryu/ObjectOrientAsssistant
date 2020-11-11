package academy.pocu.comp2500.lab8;

public abstract class SmartDevice {


    private EDeviceKind deviceKind;
    private int ticks;
    private EState state;
    private int ticksSinceLastUpdate;

    public SmartDevice(EDeviceKind deviceKind) {
        this.ticks = 0;
        this.state = EState.OFF;
        this.ticksSinceLastUpdate = 0;
        this.deviceKind = deviceKind;
    }

    public boolean isOn() {
        return this.state == EState.ON;
    }

    public void changeState() {
        switch (this.state) {
            case ON:
                this.state = EState.OFF;
                break;
            case OFF:
                this.state = EState.ON;
                break;
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

    public EDeviceKind getDeviceKind() {
        return this.deviceKind;
    }




}

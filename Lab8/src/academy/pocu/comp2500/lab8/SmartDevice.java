package academy.pocu.comp2500.lab8;

public abstract class SmartDevice {
    protected boolean isOn;
    protected int currentTick;
    protected int deviceStateChangedTick;
    protected boolean preDeviceState;
    protected ESmartDeviceType eSmartDeviceType;

    public boolean isOn() {
        return isOn;
    }

    public abstract void onTick();

    public abstract int getTicksSinceLastUpdate();

    public ESmartDeviceType geteSmartDeviceType() {
        return eSmartDeviceType;
    }
}

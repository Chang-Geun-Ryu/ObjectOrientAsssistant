package academy.pocu.comp2500.lab8;

public abstract class SmartDevice {
    protected boolean isOn;
    protected SmartDeviceType smartDeviceType;

    public abstract boolean isOn();

    public abstract void onTick();

    public abstract int getTicksSinceLastUpdate();

}

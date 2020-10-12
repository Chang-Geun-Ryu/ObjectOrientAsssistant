package academy.pocu.comp2500.lab4;

import java.util.HashMap;

public class Entry {

    public static int entryCallStack = 0;

    private String entryKey;
    private String entryValue;
    private int entryCallNumber;

    public Entry(String entryKey, String entryValue) {

        updateCallNumber();

        this.entryKey = entryKey;
        this.entryValue = entryValue;

    }

    public String getEntryKey() {
        updateCallNumber();
        return this.entryKey;
    }

    public String getEntryKeyNoUpdate() {
        return this.entryKey;
    }

    public String getEntryValue() {
        updateCallNumber();
        return this.entryValue;
    }

    public void setEntryValue(String value) {
        updateCallNumber();
        this.entryValue = value;
    }

    public int getEntryCallNumber() {
        return entryCallNumber;
    }

    private void updateCallNumber() {
        entryCallStack++;
        this.entryCallNumber = entryCallStack;
    }
}

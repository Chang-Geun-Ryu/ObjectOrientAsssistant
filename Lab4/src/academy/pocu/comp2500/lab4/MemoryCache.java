package academy.pocu.comp2500.lab4;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class MemoryCache {

    private static ArrayList<MemoryCache> instances = new ArrayList<MemoryCache>();
    private static int maxInstanceCount;
    private static boolean maxInstanceSetting = false;
    private static EvictionPolicy policyType;
    private static int callStack = 0;

    private String hardDiskName;
    private ArrayList<Entry> entryList;

    private int maxEntryCount;
    private boolean maxEntrySetting = false;
    private int callNumber;

    private MemoryCache(String hardDiskName) {

        if (policyType == null) {
            policyType = EvictionPolicy.LEAST_RECENTLY_USED;
        }

        this.hardDiskName = hardDiskName;
        this.entryList = new ArrayList<Entry>();
//        this.maxEntryCount = Integer.MAX_VALUE;
        this.callNumber = callStack;

    }

    public static MemoryCache getInstance(String hardDiskName) {

        callStack++;

        boolean isExist = false;
        for (int i = 0; i < instances.size(); i++) {

            if (instances.get(i).hardDiskName.equals(hardDiskName)) {
                isExist = true;
                break;
            }
        }

        if (!isExist) {
            if (maxInstanceSetting) {
                if (maxInstanceCount == instances.size()) {
                    removeInstance();
                }
            }

            MemoryCache instance = new MemoryCache(hardDiskName);
            instances.add(instance);
        }


        int returnIndex = 0;
        for (int i = 0; i < instances.size(); i++) {

            if (instances.get(i).hardDiskName.equals(hardDiskName)) {
                instances.get(i).callNumber = callStack;
                returnIndex = i;
            }

        }

        return instances.get(returnIndex);

    }

    private static void removeInstance() {

        if (instances.size() <= 1) {
            instances.clear();
            return;
        }

        switch (policyType) {

            case FIRST_IN_FIRST_OUT:
                instances.remove(0);
                return;

            case LAST_IN_FIRST_OUT:
                instances.remove(instances.size() - 1);
                return;

            default:
                int oldedstIndex = 0;
                for (int i = 0; i < instances.size(); i++) {

                    if (instances.get(i).callNumber < instances.get(oldedstIndex).callNumber) {
                        oldedstIndex = i;
                    }

                }

                instances.get(oldedstIndex).entryList.clear();
                instances.remove(oldedstIndex);

                return;

        }
    }

    public static void setMaxInstanceCount(int maxCount) {

        if (maxCount < 0) {
            return;
        }

        maxInstanceCount = maxCount;
        maxInstanceSetting = true;

        while (instances.size() > maxInstanceCount) {
            removeInstance();
        }

    }

    public static void clear() {
        instances = new ArrayList<MemoryCache>();
    }

//    public static int getMaxInstanceCount() {
//        return maxInstanceCount;
//    }


    public void setEvictionPolicy(EvictionPolicy type) {
        policyType = type;
    }

    public void setMaxEntryCount(int count) {

        if (count < 0) {
            return;
        }

        this.maxEntryCount = count;
        maxEntrySetting = true;

        while (entryList.size() > maxEntryCount) {
            removeEntry();
        }

    }

    public String getEntryOrNull(String key) {

        for (int i = 0; i < entryList.size(); i++) {

            if (entryList.get(i).getEntryKeyNoUpdate().equals(key)) {
                return entryList.get(i).getEntryValue();
            }
        }

        return null;
    }

    public void addEntry(String key, String value) {

        //객체생성전 있는지없는지 엔트리 리스트에 있는지 없는지 판단
        //있으면 value 업데이트, 없으면 그냥 추가가

        for (int i = 0; i < entryList.size(); i++) {

            if (entryList.get(i).getEntryKeyNoUpdate().equals(key)) {
                entryList.get(i).setEntryValue(value);
                return;
            }

        }

        //리스트에 없는값만 아래 코드 적용
        if (maxEntrySetting) {

            if (maxEntryCount == entryList.size()) {
                removeEntry();
            }
        }

        Entry entry = new Entry(key, value);
        this.entryList.add(entry);

    }

    private void removeEntry() {

        if (entryList.size() <= 1) {
            entryList.clear();
            return;
        }

        switch (policyType) {

            case FIRST_IN_FIRST_OUT:
                entryList.remove(0);
                return;

            case LAST_IN_FIRST_OUT:
                entryList.remove(entryList.size() - 1);
                return;

            default:
                int oldedstIndex = 0;

                for (int i = 0; i < entryList.size(); i++) {

                    if (entryList.get(i).getEntryCallNumber() < entryList.get(oldedstIndex).getEntryCallNumber()) {
                        oldedstIndex = i;
                    }

                }

                entryList.remove(oldedstIndex);
                return;

        }
    }


//    public String getHardDisk() {
//        return this.hardDiskName;
//    }
//
//    public EvictionPolicy getEvictionPolicy() {
//        return policyType;
//    }
//
//    public int getMaxEntryCount() {
//
//        if (maxEntryCount != Integer.MAX_VALUE) {
//            return this.entryList.size();
//        } else {
//            return this.maxEntryCount;
//        }
//
//    }

}
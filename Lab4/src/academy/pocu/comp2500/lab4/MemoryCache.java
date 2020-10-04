package academy.pocu.comp2500.lab4;

import java.time.OffsetDateTime;
import java.time.temporal.ChronoField;
import java.util.HashMap;

public class MemoryCache {
    static private HashMap<String, MemoryCache> instances = new HashMap<String, MemoryCache>();
    static private int instancesSize = 0;

    private int usingOrder;
    private OffsetDateTime usingTime;
    private HashMap<String, Entry> memory;
    private int memorySize;
    private EvictionPolicy policy = EvictionPolicy.LEAST_RECENTLY_USED;


    private MemoryCache() {
        this.memory = new HashMap<String, Entry>();
        this.usingTime = OffsetDateTime.now();
        this.usingOrder = 0;
        this.memorySize = 0;
    }

    static final public MemoryCache getInstance(String name) {
        if (MemoryCache.instances.containsKey(name)) {
            MemoryCache instance = MemoryCache.instances.get(name);

            MemoryCache.updateUsingOrders();
            instance.usingOrder = 0;
            instance.usingTime = OffsetDateTime.now();

            return instance;
        } else {
            MemoryCache.updateUsingOrders();
            MemoryCache.deleteInstance(1);
            MemoryCache newInstance = new MemoryCache();
            MemoryCache.instances.put(name, newInstance);

            return newInstance;
        }
    }



    static final private void deleteInstance(int addSize) {
        if (MemoryCache.instancesSize == 0 || MemoryCache.instancesSize > MemoryCache.instances.size() + addSize) {
            return;
        }

        int repeatCount = MemoryCache.instances.size() + addSize - MemoryCache.instancesSize;

        for(int i = 0; i < repeatCount; i++) {
            String deleteKey = "";
            for (String key: MemoryCache.instances.keySet()) {
                if (deleteKey == "") {
                    deleteKey = key;
                    continue;
                }

                if (MemoryCache.instances.get(deleteKey).usingOrder < MemoryCache.instances.get(key).usingOrder) {
                    deleteKey = key;
                }

//                if (MemoryCache.instances.get(deleteKey).usingTime.getLong(ChronoField.NANO_OF_DAY)
//                        > MemoryCache.instances.get(key).usingTime.getLong(ChronoField.NANO_OF_DAY)) {
//                    deleteKey = key;
//                }
            }

            MemoryCache.instances.remove(deleteKey);
        }
    }

    static final public void clear() {
        MemoryCache.instances.clear();
    }

    static final public void setMaxInstanceCount(int size) {
        MemoryCache.instancesSize = size;
        MemoryCache.deleteInstance(0);
    }

    static final private void updateUsingOrders() {
        for (String key: MemoryCache.instances.keySet()) {
            MemoryCache.instances.get(key).usingOrder++;
        }
    }


    final private void deleteEntry(int addSize) {
        if (this.memorySize == 0 || this.memorySize >= this.memory.size() + addSize) {
            return;
        }

        int repeatCount = this.memory.size() + addSize - this.memorySize;

        for(int i = 0; i < repeatCount; i++) {

            if (this.policy == EvictionPolicy.FIRST_IN_FIRST_OUT) {
                shiftCreateOrder(true, true, addSize);
            } else if (this.policy == EvictionPolicy.LAST_IN_FIRST_OUT) {
                shiftCreateOrder(false, true, addSize);
            } else {
                String deleteKey = "";
                for (String key : this.memory.keySet()) {
                    if (deleteKey == "") {
                        deleteKey = key;
                        continue;
                    }

                    if (this.memory.get(deleteKey).getUsingOrder() < this.memory.get(key).getUsingOrder()) {
                        deleteKey = key;
                    }
                }
                int deleteOrder = this.memory.get(deleteKey).getCreateOrder();
                this.memory.remove(deleteKey);
                shiftCreateOrderAt(deleteOrder);
            }
        }
    }

    final public void setEvictionPolicy(EvictionPolicy policy) {
        MemoryCache.updateUsingOrders();
        this.usingOrder = 0;
        this.policy = policy;
    }

    final public void addEntry(String key, String entry) {
        MemoryCache.updateUsingOrders();
        this.usingOrder = 0;
        if (this.memory.containsKey(key)) {
            updateUsingOrder();
            this.memory.get(key).setZeroUsingOrder();
            this.memory.get(key).setValue(entry);
        } else {
            updateUsingOrder();
            deleteEntry(1);
//            if (this.policy != EvictionPolicy.FIRST_IN_FIRST_OUT) {
                shiftCreateOrder(true, false, 0);
//            }

            this.memory.put(key, new Entry(entry));
        }
    }

    final public String getEntryOrNull(String key) {
        MemoryCache.updateUsingOrders();
        this.usingOrder = 0;
        if (this.memory.get(key) != null) {
            updateUsingOrder();
            this.memory.get(key).setZeroUsingOrder();
            return this.memory.get(key).getValue();
        } else {
            return null;
        }
    }

    final private void updateUsingOrder() {
        for (String key: this.memory.keySet()) {
            this.memory.get(key).updateOrder();
        }
    }

    final private void shiftCreateOrder(boolean shift, boolean delete, int addSize) {
        String deleteKey = "";

        if (delete) {
            for (String key: this.memory.keySet()) {
                if (shift) {
                    if (this.memory.get(key).getCreateOrder() + 1 > this.memorySize - addSize) {
                        deleteKey = key;
                    }
                } else {
                    if (this.memory.get(key).getCreateOrder() == 0) {
                        deleteKey = key;
                    }
                }
            }

            this.memory.remove(deleteKey);

            if (shift == false) {
                for (String key: this.memory.keySet()) {
                    this.memory.get(key).downShiftCreateOrder();
                }
            }
        } else {
            for (String key: this.memory.keySet()) {
                if (shift) {
                    if (this.memory.get(key).upShiftCreateOrder() > this.memorySize) {
                        deleteKey = key;
                    }
                } else {
                    if (this.memory.get(key).downShiftCreateOrder() < 0) {
                        deleteKey = key;
                    }
                }
            }
        }
    }

    final private void shiftCreateOrderAt(int at) {
        for (String key: this.memory.keySet()) {
            if (this.memory.get(key).getCreateOrder() > at) {
                this.memory.get(key).downShiftCreateOrder();
            }
        }
    }

    final public void setMaxEntryCount(int size) {
        MemoryCache.updateUsingOrders();
        this.usingOrder = 0;
        this.memorySize = size;
        deleteEntry(0);
    }
}

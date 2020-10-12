//package academy.pocu.comp2500.lab4;
//
//import static org.junit.Assert.*;
//
//import org.junit.Test;
//
//public class MemoryCacheTest {
//
//    @Test
//    public void testGetHardisk() {
//        MemoryCache memCacheA = MemoryCache.getInstance("A");
//        String a = memCacheA.getHardDisk();
//        assertEquals("A", a);
//    }
//
//    @Test
//    public void testGetInstance() {
//        MemoryCache memCacheA = MemoryCache.getInstance("A");
//        MemoryCache memCacheB = MemoryCache.getInstance("B");
//        MemoryCache memCacheC = MemoryCache.getInstance("C");
//
//        assertEquals(true, (memCacheA != memCacheB) && memCacheA != memCacheC);
//        assertEquals(true, memCacheB != memCacheC);
//    }
//
//    @Test
//    public void testClear() {
//        MemoryCache memCacheA = MemoryCache.getInstance("A");
//        MemoryCache memCacheB = MemoryCache.getInstance("B");
//        MemoryCache memCacheC = MemoryCache.getInstance("C");
//
//        MemoryCache.clear();
//        assert (memCacheA != MemoryCache.getInstance("A"));
//        assert (memCacheB != MemoryCache.getInstance("B"));
//        assert (memCacheC != MemoryCache.getInstance("C"));
//    }
//
//    @Test
//    public void testSetMaxInstanceCount() {
//
//        MemoryCache memCacheA = MemoryCache.getInstance("A");
//        MemoryCache memCacheB = MemoryCache.getInstance("B");
//        MemoryCache memCacheC = MemoryCache.getInstance("C");
//        MemoryCache.setMaxInstanceCount(3);
//        MemoryCache memCacheD = MemoryCache.getInstance("D"); // memCacheA가 제거됨
//        //   memCacheA = null;
//        assertEquals(null, memCacheA);
//    }
//
//    @Test
//    public void testGetMaxInstanceCount() {
//        MemoryCache.setMaxInstanceCount(3);
//        int count = MemoryCache.getMaxInstanceCount();
//        assertEquals(3, count);
//    }
//
//    @Test
//    public void testSetEvictionPolicy() {
//        MemoryCache memCache = MemoryCache.getInstance("A");
//
//        memCache.setEvictionPolicy(EvictionPolicy.FIRST_IN_FIRST_OUT);
//        memCache.setEvictionPolicy(EvictionPolicy.LAST_IN_FIRST_OUT);
//        memCache.setEvictionPolicy(EvictionPolicy.LEAST_RECENTLY_USED);
//
//        assertEquals(EvictionPolicy.LEAST_RECENTLY_USED, memCache.getEvictionPolicy());
//    }
//
//    @Test
//    public void testGetEvictionPolicy() {
//        MemoryCache memCache = MemoryCache.getInstance("A");
//        EvictionPolicy e = memCache.getEvictionPolicy();
//        assertEquals(EvictionPolicy.LEAST_RECENTLY_USED, e);
//    }
//
//    @Test
//    public void testAddEntry() {
//        MemoryCache memCache = MemoryCache.getInstance("A");
//
//        memCache.addEntry("key1", "value1");
//        assertEquals("value1", memCache.getEntryOrNull("key1"));
//
//        memCache.addEntry("key1", "value11");
//        memCache.addEntry("key2", "value2");
//
//        assertEquals("value11", memCache.getEntryOrNull("key1"));
//        assertEquals("value2", memCache.getEntryOrNull("key2"));
//    }
//
//    @Test
//    public void testSetMaxEntryCount() {
//        MemoryCache memCache = MemoryCache.getInstance("A");
//        memCache.setMaxEntryCount(3);
//
//        memCache.addEntry("key1", "value1");
//        memCache.addEntry("key2", "value2");
//        memCache.addEntry("key3", "value3");
//
//        memCache.addEntry("key4", "value4"); // 캐시로부터 key1이 제거됨
//        assertEquals(null, memCache.getEntryOrNull("key1"));
//    }
//
//    @Test
//    public void testGetMaxEntryCount() {
//        MemoryCache memCacheA = MemoryCache.getInstance("A");
//        memCacheA.addEntry("key1", "value1");
//        memCacheA.addEntry("key2", "value2");
//        memCacheA.addEntry("key3", "value3");
//        int count = memCacheA.getMaxEntryCount();
//        assertEquals(3, count);
//    }
//
//    @Test
//    public void testGetEntryOrNull() {
//        MemoryCache memCache = MemoryCache.getInstance("A");
//
//        memCache.addEntry("key1", "value1");
//
//        String value = memCache.getEntryOrNull("key1"); // value: value1
//        String valueNull = memCache.getEntryOrNull("keyNull");
//
//        assertEquals("value1", value);
//        assertEquals(null, valueNull);
//    }
//
//}
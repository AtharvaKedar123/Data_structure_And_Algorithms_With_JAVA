import java.util.LinkedHashMap;
import java.util.Map;

public class LRUEasy {

    static class LRUCache<K, V> extends LinkedHashMap<K, V> {

        private int capacity;

        public LRUCache(int capacity) {
            super(capacity, 0.75f, true);  // true = access order
            this.capacity = capacity;
        }

        // Remove oldest entry if size exceeds capacity
        @Override
        protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
            return size() > capacity;
        }
    }

    public static void main(String[] args) {

        LRUCache<Integer, String> cache = new LRUCache<>(3);

        cache.put(1, "A");
        cache.put(2, "B");
        cache.put(3, "C");

        System.out.println("Cache: " + cache);

        // Access key 1 (makes it most recently used)
        cache.get(1);

        // Add new item → removes least recently used
        cache.put(4, "D");

        System.out.println("After adding 4: " + cache);
    }
}
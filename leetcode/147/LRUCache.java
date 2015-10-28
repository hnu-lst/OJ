import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by HNULST on 2015/10/28.
 */
public class LRUCache extends LinkedHashMap<Integer, Integer> {

    private int capacity;

    public LRUCache(int capacity) {
        super(16, 0.75f, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        Integer v = super.get(key);
        if (v != null) {
            return v.intValue();
        } else {
            return -1;
        }
    }

    public void set(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > this.capacity;
    }
}

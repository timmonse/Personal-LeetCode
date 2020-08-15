import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache_146 {
    Map<Integer, Integer> map;
    int capacity;

    public LRUCache_146(int capacity) {
        map = new LinkedHashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        int value = map.getOrDefault(key, -1);
        if (value == -1) return -1;
        refresh(key, value);
        return value;
    }

    public void put(int key, int value) {
        // If the value exists in the map, remove it and re-add it
        if (map.containsKey(key)) refresh(key, value);
        else if (map.size() == capacity) {
            int oldKey = map.keySet().iterator().next();
            map.remove(oldKey);
            map.put(key,value);
        } else {
            map.put(key,value);
        }

    }

    public void refresh(int key, int value) {
        map.remove(key);
        map.put(key, value);
    }
}

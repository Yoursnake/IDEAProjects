/*
Design and implement a data structure for Least Recently Used (LRU)
 cache. It should support the following operations: get and put.

get(key) - Get the value (will always be positive) of the key
if the key exists in the cache, otherwise return -1.

put(key, value) - Set or insert the value if the key is not
already present. When the cache reached its capacity, it should
invalidate the least recently used item before inserting a new
item.

The cache is initialized with a positive capacity.

Follow up:
Could you do both operations in O(1) time complexity?

Example:

LRUCache cache = new LRUCache( 2 );

cache.put(1, 1);
cache.put(2, 2);
cache.get(1);       // returns 1
cache.put(3, 3);    // evicts key 2
cache.get(2);       // returns -1 (not found)
cache.put(4, 4);    // evicts key 1
cache.get(1);       // returns -1 (not found)
cache.get(3);       // returns 3
cache.get(4);       // returns 4
 */


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

// 13.7% wait improve
public class LeetCode146LRUCache {
    HashMap<Integer, Integer> map;
    List<Integer> list;
    int capacity;

    public LeetCode146LRUCache(int capacity) {
        map = new HashMap<>();
        list = new ArrayList<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            resortList(list, key);
            return map.get(key);
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            map.put(key, value);
            resortList(list, key);
            return;
        }

        if (map.size() == capacity) {
            int leastUseKey = list.get(0);
            list.remove(0);
            map.remove(leastUseKey);
        }

        map.put(key, value);
        list.add(key);
    }

    private void resortList(List<Integer> list, int key) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == key) {
                list.remove(i);
                list.add(key);
                break;
            }
        }
    }
}

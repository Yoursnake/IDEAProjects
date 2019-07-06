/**
 * Created by shengliyi on 2017/3/4.
 */

public class Main {
    public static void main(String[] args) {
        LeetCode146LRUCache cache = new LeetCode146LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // returns 1
//        System.out.println(cache.get(1));
        cache.put(3, 3);    // evicts key 2
        cache.get(2);       // returns -1 (not found)
//        System.out.println(cache.get(2));
        cache.put(4, 4);    // evicts key 1
        cache.get(1);       // returns -1 (not found)
        System.out.println(cache.get(2));
//        cache.get(3);       // returns 3
//        cache.get(4);       // returns 4
    }
}

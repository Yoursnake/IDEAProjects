/*
Design a data structure that supports all following operations in average O(1) time.

Note: Duplicate elements are allowed.
insert(val): Inserts an item val to the collection.
remove(val): Removes an item val from the collection if present.
getRandom: Returns a random element from current collection of elements. The probability of each element being returned is linearly related to the number of same value the collection contains.
Example:

// Init an empty collection.
RandomizedCollection collection = new RandomizedCollection();

// Inserts 1 to the collection. Returns true as the collection did not contain 1.
collection.insert(1);

// Inserts another 1 to the collection. Returns false as the collection contained 1. Collection now contains [1,1].
collection.insert(1);

// Inserts 2 to the collection, returns true. Collection now contains [1,1,2].
collection.insert(2);

// getRandom should return 1 with the probability 2/3, and returns 2 with the probability 1/3.
collection.getRandom();

// Removes 1 from the collection, returns true. Collection now contains [1,2].
collection.remove(1);

// getRandom should return 1 and 2 both equally likely.
collection.getRandom();
*/

import java.util.*;

//// HashMap + HashMap: 22ms 74.77%
//// Mine
//public class LeetCode381InsertDeleteGetRandomO1Duplicatesallowed {
//	private List<Integer> list;
//	private Map<Integer, List<Integer>> locMap;         // 每个元素的所有索引组成一个 list
//	private Map<Integer, Map<Integer, Integer>> idxMap; // 每个元素的元素索引在索引 list 中的位置
//	private Random random;
//
//	/** Initialize your data structure here. */
//    public LeetCode381InsertDeleteGetRandomO1Duplicatesallowed() {
//        list = new ArrayList<>();
//        locMap = new HashMap<>();
//	    idxMap = new HashMap<>();
//        random = new Random();
//    }
//
//    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
//    public boolean insert(int val) {
//    	// locMap.get(val) 是一个list，表示存储 val 元素的所有索引
//	    // idxMap.get(val) 是一个map，表示 localMap.get(val) 中每个元素在 list 中的索引
//        if (locMap.containsKey(val)) {
//			list.add(val);
//			locMap.get(val).add(list.size() - 1);
//			idxMap.get(val).put(list.size() - 1, locMap.get(val).size() - 1);
//        	return false;
//        } else {
//        	list.add(val);
//        	locMap.put(val, new ArrayList<>(Arrays.asList(list.size() - 1)));
//	        idxMap.put(val, new HashMap<>());
//	        idxMap.get(val).put(list.size() - 1, 0);
//        	return true;
//        }
//    }
//
//    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
//    public boolean remove(int val) {
//        if (!locMap.containsKey(val)) return false;
//
//        List<Integer> idxs = locMap.get(val);
//        int idx = idxs.get(idxs.size() - 1);	// 取最后一个索引作为被替代的索引，即删除的索引
//        idxs.remove(idxs.size() - 1);
//
//        idxMap.get(val).remove(idx);            // 把删除的索引从对应元素的 map 中删除
//
//        if (idxs.size() == 0) {
//        	locMap.remove(val);
//	        idxMap.remove(val);
//        }
//
//	    if (idx != list.size() - 1) {
//		    int lastIdx = list.size() - 1;
//		    int lastVal = list.get(lastIdx);
//		    list.set(idx, lastVal);			// 替代
//
//		    // 将最后一个数的索引修改
//		    List<Integer> lastIdxs = locMap.get(lastVal);
//		    int tmp = idxMap.get(lastVal).get(lastIdx); // 最后一个数在索引list 中的位置
//		    lastIdxs.set(tmp, idx);     // 改变 list 中替换后数字的索引
//		    idxMap.get(lastVal).remove(lastIdx);    // 将原来的索引删除
//		    idxMap.get(lastVal).put(idx, tmp);      // 换成新的索引
//	    }
//
//	    list.remove(list.size() - 1);	// 删除最后一个数
//
//        return true;
//    }
//
//    /** Get a random element from the collection. */
//    public int getRandom() {
//        int idx = random.nextInt(list.size());
//        return list.get(idx);
//    }
//}

// LinkedHashSet + HashMap: 14ms 94.5%
// 参考：https://leetcode.com/problems/insert-delete-getrandom-o1-duplicates-allowed/discuss/85540/Java-HaspMap-LinkedHashSet-ArrayList-(155-ms)
public class LeetCode381InsertDeleteGetRandomO1Duplicatesallowed {
	private List<Integer> list;
	private Map<Integer, LinkedHashSet<Integer>> locMap;         // 每个元素的所有索引组成一个 list
	private Random random;

	/** Initialize your data structure here. */
    public LeetCode381InsertDeleteGetRandomO1Duplicatesallowed() {
        list = new ArrayList<>();
        locMap = new HashMap<>();
        random = new Random();
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
	    boolean contain = locMap.containsKey(val);
	    if (!contain) locMap.put(val, new LinkedHashSet<>());

	    list.add(val);
	    locMap.get(val).add(list.size() - 1);
	    return !contain;
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
	    boolean contain = locMap.containsKey(val);
	    if (!contain) return false;

	    int idx = locMap.get(val).iterator().next();    // val链表的第一个索引
	    locMap.get(val).remove(idx);        // 把val链表第一个索引删除
	    if (locMap.get(val).isEmpty()) locMap.remove(val);
	    if (idx != list.size() - 1) {
		    int lastIdx = list.size() - 1;
		    int lastVal = list.get(lastIdx);
		    list.set(idx, lastVal);
		    locMap.get(lastVal).remove(lastIdx);
		    locMap.get(lastVal).add(idx);
	    }
	    list.remove(list.size() - 1);
	    return true;
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        int idx = random.nextInt(list.size());
        return list.get(idx);
    }
}
/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
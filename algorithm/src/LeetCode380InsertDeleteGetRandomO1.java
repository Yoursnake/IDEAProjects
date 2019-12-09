/*
Design a data structure that supports all following operations 
in average O(1) time.

insert(val): Inserts an item val to the set if not already present.
remove(val): Removes an item val from the set if present.
getRandom: Returns a random element from current set of elements. 
Each element must have the same probability of being returned.
Example:

// Init an empty set.
RandomizedSet randomSet = new RandomizedSet();

// Inserts 1 to the set. Returns true as 1 was inserted successfully.
randomSet.insert(1);

// Returns false as 2 does not exist in the set.
randomSet.remove(2);

// Inserts 2 to the set, returns true. Set now contains [1,2].
randomSet.insert(2);

// getRandom should return either 1 or 2 randomly.
randomSet.getRandom();

// Removes 1 from the set, returns true. Set now contains [2].
randomSet.remove(1);

// 2 was already in the set, so return false.
randomSet.insert(2);

// Since 2 is the only number in the set, getRandom always return 2.
randomSet.getRandom();
*/

import java.util.*;

// HashMap + ArrayList: 11ms 97%
public class LeetCode380InsertDeleteGetRandomO1 {
	private List<Integer> list;
	private Map<Integer, Integer> locMap;	// 表示某数在 list 中的索引位置
	private Random random;

	/** Initialize your data structure here. */
    public LeetCode380InsertDeleteGetRandomO1() {
    	list = new ArrayList<>();
        locMap =  new HashMap<>();
        random = new Random();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (locMap.containsKey(val)) return false;

        list.add(val);
        locMap.put(val, list.size() - 1);

        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!locMap.containsKey(val)) return false;

        // 将 list 中最后一个数和要删除的数调换位置，然后删掉最后一个数
        int lastNum = list.get(list.size() - 1);	// list 中最后一个数
        int idx = locMap.get(val);
        list.set(idx, lastNum);
        list.remove(list.size() - 1);
        locMap.put(lastNum, idx);
        locMap.remove(val);

        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        int idx = random.nextInt(list.size());

        return list.get(idx);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
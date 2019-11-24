/*
Given a non-empty array of integers, return the k most frequent elements.

Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
Example 2:

Input: nums = [1], k = 1
Output: [1]
Note:

You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
Your algorithm's time complexity must be better than O(n log n), where n
is the array's size.
*/

import java.util.*;

public class LeetCode347TopKFrequentElements {
	// // Heap: O(nlogk + n) 16ms 53.56%
	// public List<Integer> topKFrequent(int[] nums, int k) {
	// 	Map<Integer, Integer> map = new HashMap<>();
	// 	List<Integer> res = new ArrayList<>();

	// 	for (int num : nums) {
	// 		if (!map.containsKey(num)) map.put(num, 1);
	// 		else map.put(num, map.get(num) + 1);
	// 	}

	// 	// 维护一个最小堆（堆顶元素最小）
	// 	PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((o1, o2) -> (o1.getValue() - o2.getValue()));

	// 	for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
	// 		pq.offer(entry);
	// 		if (pq.size() > k) pq.poll();   // 保证 heap 中元素只有 k 个
	// 	}

	// 	while (!pq.isEmpty()) {
	// 		res.add(pq.poll().getKey());
	// 	}

	// 	return res;
	// }

	// Bucket Sort: O(n) 11ms 89.5%
	public List<Integer> topKFrequent(int[] nums, int k) {
		List<Integer> res = new LinkedList<>();

		Map<Integer, Integer> map = new HashMap<>();
		for (int num : nums) {
			if (!map.containsKey(num)) map.put(num, 1);
			else map.put(num, map.get(num) + 1);
		}

		List<Integer>[] buckets = new List[nums.length + 1];
		for (Integer n : map.keySet()) {
			int freq = map.get(n);
			if (buckets[freq] == null) buckets[freq] = new LinkedList<>();
			buckets[freq].add(n);
		}

		for (int i = buckets.length - 1; i > 0 && k > 0; i--) {
			List<Integer> list = buckets[i];
			if (list != null) {
				res.addAll(list);
				k -= list.size();
			}
		}

		return res;
	}
}

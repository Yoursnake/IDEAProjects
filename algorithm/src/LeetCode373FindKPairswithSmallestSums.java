/*
You are given two integer arrays nums1 and nums2 sorted in ascending order and an integer k.

Define a pair (u,v) which consists of one element from the first array and one element from the second array.

Find the k pairs (u1,v1),(u2,v2) ...(uk,vk) with the smallest sums.

Example 1:

Input: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
Output: [[1,2],[1,4],[1,6]] 
Explanation: The first 3 pairs are returned from the sequence: 
             [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
Example 2:

Input: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
Output: [1,1],[1,1]
Explanation: The first 2 pairs are returned from the sequence: 
             [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
Example 3:

Input: nums1 = [1,2], nums2 = [3], k = 3
Output: [1,3],[2,3]
Explanation: All possible pairs are returned from the sequence: [1,3],[2,3]
*/

import java.util.*;

public class LeetCode373FindKPairswithSmallestSums {
	// // PriorityQueue/Heap brute force: O(mnlogk) 113ms 5.4%
	// public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
	// 	if (nums1.length == 0 || nums2.length == 0) return Collections.EMPTY_LIST;

	// 	List<List<Integer>> res = new ArrayList<>();
	// 	PriorityQueue<List<Integer>> pq = new PriorityQueue(new Comparator<List<Integer>>() {
	// 		public int compare(List<Integer> l1, List<Integer> l2) {
	// 			return (l2.get(0) + l2.get(1)) - (l1.get(0) + l1.get(1));	// 维护一个最大堆，以便在新增数据时维持堆的大小
	// 		}
	// 	});

	// 	int commonLen = Math.min(nums1.length, nums2.length);
	// 	for (int i = 0; i < nums1.length; i++) {
	// 		for (int j = 0; j < nums2.length; j++) {
	// 			pq.offer(new ArrayList<>(Arrays.asList(nums1[i], nums2[j])));
	// 			if (pq.size() > k) pq.poll();	// 将堆的大小控制在 k
	// 		}
	// 	}

	// 	while (!pq.isEmpty()) {
	// 		res.add(pq.poll());
	// 	}

	// 	return res;
	// }

	// O(klogk) 6ms 68.5%
	// 参考：https://leetcode.com/problems/find-k-pairs-with-smallest-sums/discuss/84551/simple-Java-O(KlogK)-solution-with-explanation
	// 本质是 k 个 list 的归并排序，可见网站中的 review
	public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
		if (nums1.length == 0 || nums2.length == 0) return Collections.EMPTY_LIST;

		List<List<Integer>> res = new ArrayList<>();
		// 最小堆
		PriorityQueue<List<Integer>> pq = new PriorityQueue<>((l1, l2) -> (l1.get(0) + l1.get(1) - l2.get(0) -l2.get(1)));
		for (int i = 0; i < nums1.length && i < k; i++) pq.offer(new ArrayList<>(Arrays.asList(nums1[i], nums2[0], 0)));

		while (k-- > 0 && !pq.isEmpty()) {
			List<Integer> list = pq.poll();
			res.add(new ArrayList<>(Arrays.asList(list.get(0), list.get(1))));
			if (list.get(2) + 1 < nums2.length) 
				pq.offer(new ArrayList<>(Arrays.asList(list.get(0), nums2[list.get(2) + 1], list.get(2) + 1)));
		}

		return res;
	}
}
/*
Given an integer array of size n, find all elements 
that appear more than ⌊ n/3 ⌋ times.

Note: The algorithm should run in linear time and 
in O(1) space.

Example 1:

Input: [3,2,3]
Output: [3]

Example 2:

Input: [1,1,1,3,3,2,2,2]
Output: [1,2]
*/

import java.util.ArrayList;
import java.util.List;

public class LeetCode229MajorityElementII {
	// // HashMap: 13%. O(n) - O(n)
	// public List<Integer> majorityElement(int[] nums) {
	// 	if (nums.length == 0) return Collections.EMPTY_LIST;

	// 	Map<Integer, Integer> map = new HashMap<>();
	// 	Set<Integer> hasMarked = new HashSet<>();
	// 	List<Integer> res = new ArrayList<>();

	// 	for (int num : nums) {
	// 		if (map.getOrDefault(num, 0) + 1 > nums.length / 3) {
	// 			if (!hasMarked.contains(num)) {
	// 				hasMarked.add(num);
	// 				res.add(num);
	// 			} 
	// 		}

	// 		map.put(num, map.getOrDefault(num, 0) + 1);
	// 	}

	// 	return res;
	// }

	// Moore Voting: 73%
	// note: 一个数组中大于 n/3 的数不会超过 2 个
	public List<Integer> majorityElement(int[] nums) {
		List<Integer> res = new ArrayList<>();
		int cnt1 = 0, cnt2 = 0;
		int a = 0, b = 0;

		for (int num : nums) {
		    // 必须选考虑 num，再考虑 cnt
            if (num == a) {
                cnt1++;
            } else if (num == b) {
                cnt2++;
            } else if (cnt1 == 0) {
				a = num;
				cnt1 = 1;
			} else if (cnt2 == 0) {
				b = num;
				cnt2 = 1;
			} else {
				cnt1--;
				cnt2--;
			}
		}

		cnt1 = 0;
		cnt2 = 0;
		for (int num : nums) {
			if (num == a) cnt1++;
			else if (num == b) cnt2++; // 这个 else 可以避免计算重复的数
		}

		if (cnt1 > nums.length / 3) res.add(a);
		if (cnt2 > nums.length / 3) res.add(b);

		return res;
	}
}
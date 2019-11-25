/*
Given two arrays, write a function to compute their intersection.

Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2,2]
Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [4,9]
Note:

Each element in the result should appear as many times as it shows in both arrays.
The result can be in any order.
*/

import java.util.*;

public class LeetCode350IntersectionofTwoArraysII {
	// 2ms 92%
	public int[] intersect(int[] nums1, int[] nums2) {
		List<Integer> list = new ArrayList<>();
		Arrays.sort(nums1);
		Arrays.sort(nums2);

		int i = 0, j = 0;
		while (i < nums1.length && j < nums2.length) {
			while (i < nums1.length && j < nums2.length && nums1[i] < nums2[j]) i++;
			while (i < nums1.length && j < nums2.length && nums1[i] > nums2[j]) j++;

			if (i >= nums1.length || j >= nums2.length) break;

			if (nums1[i] == nums2[j]) {
				list.add(nums1[i]);
				i++;
				j++;
			}
		}

		int[] res = new int[list.size()];
		for (int k = 0; k < list.size(); k++) {
			res[k] = list.get(k);
		}

		return res;
	}
}
/*
Given an array of numbers nums, in which exactly two elements 
appear only once and all the other elements appear exactly 
twice. Find the two elements that appear only once.

Example:

Input:  [1,2,1,3,2,5]
Output: [3,5]

Note:

The order of the result is not important. So in the above 
example, [5, 3] is also correct.

Your algorithm should run in linear runtime complexity. 
Could you implement it using only constant space complexity?
*/

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class LeetCode260SingleNumberIII {
	// // HashSet: 35.11% O(n) - O(n)
	// public int[] singleNumber(int[] nums) {
	// 	Set<Integer> set = new HashSet<>();
	// 	int[] res = new int[2];

	// 	for (int num : nums) {
	// 		if (!set.contains(num)) set.add(num);
	// 		else set.remove(num);
	// 	}

	// 	Iterator<Integer> it = set.iterator();
	// 	int i = 0;
	// 	while (it.hasNext()) res[i++] = it.next();

	// 	return res;
	// }

	// xor: 99.66%
	// 参考 LeetCode136，关键在于将数组分成两份，每份包含 single num
	// 先将所有数据异或，结果就是两个 single num 的异或
	// 由于两个 single num 不同，异或结果必定有个位为 1，通过 1 所在的位
	// 作为分界点将数组分成两份然后分别求异或即可。
	public int[] singleNumber(int[] nums) {
		int diff = 0;

		for (int num : nums) diff ^= num;

		// 这一步非常巧妙，得到的结果为从右往左第一个 1 所在的位的值
		diff &= -diff;

		int[] res = {0, 0};
		for (int num : nums) {
			if ((num & diff) == 0) res[0] ^= num;
			else res[1] ^= num;
		}

		return res;
	}
}
/*
You are given an integer array nums and you have to return a 
new counts array. The counts array has the property where 
counts[i] is the number of smaller elements to the right of nums[i].

Example:

Input: [5,2,6,1]
Output: [2,1,1,0] 

Explanation:
To the right of 5 there are 2 smaller elements (2 and 1).
To the right of 2 there is only 1 smaller element (1).
To the right of 6 there is 1 smaller element (1).
To the right of 1 there is 0 smaller element.
*/

import java.util.*;

public class LeetCode315CountofSmallerNumbersAfterSelf {
	// // 枚举：O(n^2) 6.7% 490ms
	// public List<Integer> countSmaller(int[] nums) {
	// 	List<Integer> res = new ArrayList<>();

	// 	for (int i = 0; i < nums.length; i++) {
	// 		int count = 0;

	// 		for (int j = i + 1; j < nums.length; j++) {
	// 			if (nums[j] < nums[i]) count++;
	// 		}
	// 		res.add(count);
	// 	}

	// 	return res;
	// }


	/* BinaryIndexTree: 54% 11ms
	private class BinaryIndexTree {
		private int[] data;

		BinaryIndexTree(int n) {
			data = new int[n + 1];
		}

		int lowBit(int idx) {
			return idx & (-idx);
		}

		void add(int i, int delta) {
			while (i < data.length) {
				data[i] += delta;
				i += lowBit(i);
			}
		}

		int sum(int i) {
			int res = 0;

			while (i > 0) {
				res += data[i];
				i -= lowBit(i);
			}

			return res;
		}
	}

	// BinaryIndexTree: 54% 11ms
	// 先把数组排序，然后把每个数字的 rank 存储到 map 中，然后一边构建 BIT 一边计算最小数
	// BIT 计算的前缀和为排名前 n 的数一共出现的次数。
	// 从数组右边开始添加到 BIT 中，添加前计算这个数前面出现过数的次数，然后在该树对应的 rank 的索引加 1
	// 参考自：https://zxi.mytechroad.com/blog/algorithms/array/leetcode-315-count-of-smaller-numbers-after-self/
	public List<Integer> countSmaller(int[] nums) {
		int[] sorted = Arrays.copyOf(nums, nums.length);
		Arrays.sort(sorted);

		Map<Integer, Integer> ranks = new HashMap<>();
		int rank = 1;
		for (int i = 0; i < sorted.length; i++) {
			if (i == 0 || sorted[i] != sorted[i - 1]) ranks.put(sorted[i], rank++);
		}

		BinaryIndexTree bit = new BinaryIndexTree(nums.length);
		List<Integer> res = new LinkedList<>();
		for (int i = nums.length - 1; i >= 0; i--) {
			int cnt = bit.sum(ranks.get(nums[i]) - 1);
			res.add(0, cnt);
			bit.add(ranks.get(nums[i]), 1);
		}

		return res;
	}
	*/

	private class CountNode {
		private int leftCount;
		private int selfCount;
		private int val;
		private CountNode left;
		private CountNode right;

		public CountNode(int val) {
			this.val = val;
			this.leftCount = 0;
			this.selfCount = 1;
		}

		public int insert(int val) {
			if (val < this.val) {
				this.leftCount++;

				if (this.left == null) {
					this.left = new CountNode(val);
					return 0;
				} else {
					return this.left.insert(val);	
				} 
			} else if (val > this.val) {
				if (this.right == null) {
					this.right = new CountNode(val);
					return this.leftCount + this.selfCount;
				} else {
					return this.leftCount + this.selfCount + this.right.insert(val);	
				} 
			} else {
				this.selfCount++;
				return this.leftCount;
			}
		}
	}

	// BinarySearchTree: 98% 4ms
	// 构造一个 CountNode 包含三个属性，自己的值，左子树的数一共出现的次数，本身出现的次数。然后将 nums 从右到左 insert 到树中
	// 关键在于 insert 函数
	// If the number exists, return leftCount
	// If the number will insert to a left leaf, return 0
	// If the number will insert to a right leaf, return leftCount + selfCount
	// If the number will insert to a right subtree, return leftCount + selfCount + insert(right, n)
	// If the number will insert to a left subtree, return insert(left, n)
	public List<Integer> countSmaller(int[] nums) {
		if (nums == null || nums.length < 1) return Collections.EMPTY_LIST;

		List<Integer> res = new LinkedList<>();
		CountNode root = new CountNode(nums[nums.length - 1]);
		res.add(0, 0);

		for (int i = nums.length - 2; i >= 0; i--) {
			int cnt = root.insert(nums[i]);
			res.add(0, cnt);
		}

		return res;
	}
}
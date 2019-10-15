/*
Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

The update(i, val) function modifies nums by updating the element at index i to val.

Example:

Given nums = [1, 3, 5]

sumRange(0, 2) -> 9
update(1, 2)
sumRange(0, 2) -> 8

Note:

The array is only modifiable by the update function.
You may assume the number of calls to update and sumRange function is distributed evenly.
*/

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */

// // 9% 213ms
// public class LeetCode307RangeSumQueryMutable {
// 	private int[] cumsum;

// 	// O(n)
//     public LeetCode307RangeSumQueryMutable(int[] nums) {
//     	if (nums == null || nums.length == 0) return;

//         cumsum = new int[nums.length];
//         cumsum[0] = nums[0];

//         for (int i = 1; i < nums.length; i++) cumsum[i] = cumsum[i - 1] + nums[i];
//     }
    
//     // O(n)
//     public void update(int i, int val) {
//     	int diff = 0;

//     	if (i == 0) diff = val - cumsum[i];
//     	else diff = val - (cumsum[i] - cumsum[i - 1]);

//         for (int j = i; j < cumsum.length; j++) cumsum[j] += diff;
//     }
    
//     // O(1)
//     public int sumRange(int i, int j) {
//         if (i == 0) return cumsum[j];
//         else return cumsum[j] - cumsum[i - 1];
//     }
// }

// Binary Index Tree: 98% 52ms
// 参考：https://blog.csdn.net/qq508618087/article/details/51303552
public class LeetCode307RangeSumQueryMutable {
	private int[] nums;
	private int[] bit;

	// O(nlogn)
    public LeetCode307RangeSumQueryMutable(int[] nums) {
    	if (nums == null || nums.length == 0) return;

        this.nums = nums;
        this.bit = new int[nums.length + 1];

        for (int i = 1; i <= nums.length; i++) add(i, nums[i - 1]);
    }
    
	private int lowbit(int index) {
		return index & (-index);
	}

	// 每个节点表示本身与其左子树节点的和
	private void add(int index, int num) {
		while (index < bit.length) {
			bit[index] += num;
			index += lowbit(index);
		}
	}

	// 前 i 个数就是把节点当右节点然后不断往上爬求和
	private int sum(int index) {
		int ans = 0;

		while (index > 0) {
			ans += bit[index];
			index -= lowbit(index);
		}

		return ans;
	}

    // O(logn)
    public void update(int i, int val) {
    	add(i + 1, val - nums[i]);
		nums[i] = val;    	
    }
    
    // O(logn)
    public int sumRange(int i, int j) {
        return sum(j + 1) - sum(i);
    }
}

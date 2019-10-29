/*
Given two arrays of length m and n with digits 0-9 representing two numbers. 
Create the maximum number of length k <= m + n from digits of the two. The 
relative order of the digits from the same array must be preserved. Return 
an array of the k digits.

Note: You should try to optimize your time and space complexity.

Example 1:

Input:
nums1 = [3, 4, 6, 5]
nums2 = [9, 1, 2, 5, 8, 3]
k = 5
Output:
[9, 8, 6, 5, 3]

Example 2:

Input:
nums1 = [6, 7]
nums2 = [6, 0, 4]
k = 5
Output:
[6, 7, 6, 0, 4]

Example 3:

Input:
nums1 = [3, 9]
nums2 = [8, 9]
k = 3
Output:
[9, 8, 9]
*/

public class LeetCode321CreateMaximumNumber {
	// greed: 71% 9ms
	// 假设 k 个数是从 nums1 中取 i 个数，nums2 中取 k-i 个数
	// 先确定 i 的范围 [max(0, k-nums2.length), min(k, nums1.length)]
	// 然后从 nums1 中找 i 个数组成最大的数组，nums2 中找 k-i 个数组成最大的数组（贪心）
	// 然后合并两个数组组成最大的数组，找到最大的数组即可
	public int[] maxNumber(int[] nums1, int[] nums2, int k) {
     	int low = Math.max(0, k - nums2.length);
     	int high = Math.min(k, nums1.length);

     	int[] res = {};

		for (int i = low; i <= high; i++) {
     		int[] n1 = findMaxNumber(nums1, i);
     		int[] n2 = findMaxNumber(nums2, k - i);
     		int[] tmp = mergeMaxNumber(n1, n2);

     		if (compare(tmp, 0, res, 0) > 0) res = tmp;
     	}

     	return res;
    }

    // 将两个数组合并成一个最大的数组
    private int[] mergeMaxNumber(int[] nums1, int[] nums2) {
    	int[] res = new int[nums1.length + nums2.length];
    	int idx = 0, idx1 = 0, idx2 = 0;

    	while (idx1 < nums1.length && idx2 < nums2.length) {
    		// 比较 nums1 和 nums2，使用大的数
    		if (compare(nums1, idx1, nums2, idx2) > 0) {
    			res[idx++] = nums1[idx1++];
    		} else {
    			res[idx++] = nums2[idx2++];
    		}
    	}

    	while (idx1 < nums1.length) res[idx++] = nums1[idx1++];
	    while (idx2 < nums2.length) res[idx++] = nums2[idx2++];

    	return res;
    }

    // 比较两个数组从特定索引以后的大小
    private int compare(int[] nums1, int idx1, int[] nums2, int idx2) {
    	while (idx1 < nums1.length && idx2 < nums2.length) {
    		if (nums1[idx1] > nums2[idx2]) {
    			return 1;
    		} else if (nums1[idx1] < nums2[idx2]) {
    			return -1;
    		} else {
    			idx1++;
    			idx2++;
    		}
    	}

    	if (idx1 < nums1.length) return 1;
    	else if (idx2 < nums2.length) return -1;
    	else return 0;
    }

    // 从 nums 中找 k 个数组成的最大值
    private int[] findMaxNumber(int[] nums, int k) {
    	if (k == 0) return new int[0];

    	int[] res = new int[k];
    	int curIdx = 0;
    	int drop = nums.length - k;		// 可以丢弃的个数

    	for (int i = 0; i < nums.length; i++) {
    		if (drop != 0) {
    			// 注意要保证 drop > 0
    			while (drop > 0 && curIdx > 0 && nums[i] > res[curIdx - 1]) {
    				curIdx--;
    				drop--;
    			}
    		} 

    		if (curIdx != k) res[curIdx++] = nums[i];
    		else drop--;    // 这一步很关键，没有加入到 nums 中也要 drop--
    	}

    	return res;
    }
}
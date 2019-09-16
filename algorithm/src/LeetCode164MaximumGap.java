/*
Given an unsorted array, find the maximum difference between the successive
elements in its sorted form.

Return 0 if the array contains less than 2 elements.

Example 1:

Input: [3,6,9,1]
Output: 3
Explanation: The sorted form of the array is [1,3,6,9], either
             (3,6) or (6,9) has the maximum difference 3.
Example 2:

Input: [10]
Output: 0
Explanation: The array contains less than 2 elements, therefore return 0.

Note:

You may assume all elements in the array are non-negative integers and fit in
the 32-bit signed integer range.
Try to solve it in linear time/space.
 */

public class LeetCode164MaximumGap {
//    // wait improve
//    public int maximumGap(int[] nums) {
//        if (nums.length < 2) return 0;
//
//        int maxGap = 0;
//        Arrays.sort(nums);
//        for (int i = 0; i < nums.length - 1; i++) {
//            int currGap = nums[i + 1] - nums[i];
//            if (currGap > maxGap)maxGap = currGap;
//        }
//
//        return maxGap;
//    }

    // bucket sort   100%
    public int maximumGap(int[] nums) {
        if (nums.length == 0) return 0;
        int minVal = Integer.MAX_VALUE;
        int maxVal = Integer.MIN_VALUE;

        // 先遍历一遍找最大值和最小值
        for (int num : nums) {
            if (num < minVal) minVal = num;
            if (num > maxVal) maxVal = num;
        }

        if (minVal == maxVal) return 0;

        // 桶的长度和桶的数量，桶长：将 nums 中元素从 min 到 max 平均分布的长度
        int bucketLen = (int)Math.ceil((maxVal - minVal) * 1.0 / (nums.length - 1));
        int bucketNum = (maxVal - minVal)/ bucketLen + 1;

        // bucket[i][0] 表示 i 桶的最小值，bucket[i][1] 表示 i 桶的最大值
        int[][] bucket = new int[bucketNum][];
        for (int i = 0; i < nums.length; i++) {
            // 计算 nums[i] 所在的桶的索引
            int index = (nums[i] - minVal) / bucketLen;
            if (bucket[index] == null) {
                bucket[index] = new int[2];
                bucket[index][0] = nums[i];
                bucket[index][1] = nums[i];
            } else {
                bucket[index][0] = Math.min(bucket[index][0], nums[i]);
                bucket[index][1] = Math.max(bucket[index][1], nums[i]);
            }
        }

        int pre = 0;    // 表示上一次有值的索引
        int maxGap = 0;
        for (int i = 0; i < bucket.length; i++) {
            if (bucket[i] == null) continue;
            // bucket[0][1] 一定不为空，因为 minVal 一定在 0 桶中
            maxGap = Math.max(maxGap, bucket[i][0] - bucket[pre][1]);
            pre = i;
        }

        return maxGap;
    }
}
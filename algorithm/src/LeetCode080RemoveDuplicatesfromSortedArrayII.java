/*
Example 1:

Given nums = [1,1,1,2,2,3],

Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3 respectively.

It doesn't matter what you leave beyond the returned length.

Example 2:

Given nums = [0,0,1,1,1,1,2,3,3],

Your function should return length = 7, with the first seven elements of nums being modified to 0, 0, 1, 1, 2, 3 and 3 respectively.

It doesn't matter what values are set beyond the returned length.
 */

public class LeetCode080RemoveDuplicatesfromSortedArrayII {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 1) return nums.length;

        int valIndex = 1;       // 赋值指针
        int forwardIndex = 1;   // 前进指针
        int len = nums.length;
        int flag = 1;       // 表示当前元素存在个数
        int lastVal = nums[0];

        while (forwardIndex < len) {
            if (nums[forwardIndex] == lastVal){
                flag++;
            } else {
                lastVal = nums[forwardIndex];
                flag = 1;
            }

            if (flag < 3) {
                nums[valIndex] = nums[forwardIndex];
                valIndex++;
            }

            forwardIndex++;
        }

        return valIndex;
    }
}

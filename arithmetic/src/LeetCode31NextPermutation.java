/*
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1
*/

public class LeetCode31NextPermutation {
    public void nextPermutation(int[] nums) {
        int dsIndex = 0;
        int gtIndex = 0;
        int dsEndValue;
        int gtValue = 0;

        // 找逆序到第几个索引
        for (int i = nums.length - 1; i >= 1; i--) {
            if (nums[i] > nums[i - 1]) {
                dsIndex = i;
                break;
            }
        }

        // 如果整个数列为逆序，则翻转序列
        if (dsIndex == 0) {
            reverse(nums, 0, nums.length - 1);
            return;
        }

        // 逆序序列的前一个元素
        dsEndValue = nums[dsIndex - 1];

        // 找逆序中比dsEndValue大的值
        for (int i = nums.length - 1; i >= dsIndex; i--) {
            if (nums[i] > dsEndValue) {
                gtIndex = i;
                gtValue = nums[i];
                break;
            }
        }

        // 交换元素
        nums[gtIndex] = dsEndValue;
        nums[dsIndex - 1] = gtValue;

        reverse(nums, dsIndex, nums.length - 1);
    }

    private void reverse(int[] nums, int begin, int end) {
        for (int i = begin; i <= (begin + end) / 2; i++) {
            int temp = nums[i];
            nums[i] = nums[end - (i - begin)];
            nums[end - (i - begin)] = temp;
        }
    }
}

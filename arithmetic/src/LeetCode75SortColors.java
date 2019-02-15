/*
Example:

Input: [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]

 */

public class LeetCode75SortColors {
//    // 扫两遍
//    public void sortColors(int[] nums) {
//        int[] colorNum = new int[3];
//
//        for (int i = 0; i < nums.length; i++) {
//            colorNum[nums[i]]++;
//        }
//
//        int flag = 0;
//        for (int i = 0; i < nums.length; i++) {
//            while (colorNum[flag] == 0) flag++;
//            nums[i] = flag;
//            colorNum[flag]--;
//        }
//    }

    // 扫一遍
    public void sortColors(int[] nums) {
        int i = -1, j = -1, k = -1;
        for (int index = 0; index < nums.length; index++) {
            if (nums[index] == 0) {
                nums[++k] = 2;
                nums[++j] = 1;
                nums[++i] = 0;
            } else if (nums[index] == 1) {
                nums[++k] = 2;
                nums[++j] = 1;
            } else {
                nums[++k] = 2;
            }
        }
    }
}

/**
 * Created by shengliyi on 2017/3/4.
 */

public class Main {

    public static void main(String[] args) {

        int[] nums = {1, 3, 5, 6};
        int target = 0;
        int a = new LeetCode35SearchInsertPosition().searchInsert(nums, target);
        System.out.println(a);
    }
}

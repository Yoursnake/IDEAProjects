public class LeetCode33SearchRotatedSortedArray {
    public int search(int[] nums, int target) {

        // 对长度为 0 和 1 的数组单独考虑
        if (nums.length == 0) {
            return -1;
        } else if (nums.length == 1) {
            if (nums[0] == target) {
                return 0;
            } else {
                return -1;
            }
        }

        int end = nums.length - 1;
        // 首先找到旋转点的索引（即最小值）
        int rotateIndex = findRotateIndex(nums, 0, nums.length - 1);


        if (target == nums[end]) {
            return end;
        } else if (target < nums[end]) {
            // 如果target < 最后一个数，表明target在第一段数中
            return findTarget(nums, target, rotateIndex, end);
        } else {
            // 如果target > 最后一个数，表明target在第二段数中
            return findTarget(nums, target, 0, rotateIndex - 1);
        }
    }

    private int findTarget(int[] nums, int target, int begin, int end) {
        // 如果 begin > end 则找不到（边界条件）
        if (begin > end) {
            return -1;
        }

        int mid = (begin + end) / 2;
        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] > target) {
            return findTarget(nums, target, begin, mid - 1);
        } else{
            return findTarget(nums, target, mid + 1, end);
        }
    }

    private int findRotateIndex(int[] nums, int begin, int end) {

        // 如果没有旋转则返回 0
        if (!isRotate(nums)) {
            return 0;
        }

        int mid = (begin + end) / 2;
        // 如果 mid 等于 0 有不同的策略
        if (mid == 0) {
            if (nums[mid] > nums[mid + 1])
                return mid + 1;
        } else {
            if (nums[mid] < nums[mid - 1])
                return mid;
        }

        if (nums[mid] > nums[end]) {
            // 如果 mid > end 表明旋转点在 mid ~ end 间
            return findRotateIndex(nums, mid + 1, end);
        } else {
            // 如果 mid < end 表明旋转点在 0 ~ mid 间
            return findRotateIndex(nums, begin, mid - 1);
        }
    }

    private boolean isRotate(int[] nums) {

        // 如果所有数都满足升序则没有旋转
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                return true;
            }
        }

        return false;
    }
}

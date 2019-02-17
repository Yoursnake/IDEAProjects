///*
//Example 1:
//
//Input: nums = [2,5,6,0,0,1,2], target = 0
//Output: true
//
//Example 2:
//
//Input: nums = [2,5,6,0,0,1,2], target = 3
//Output: false
// */
//public class LeetCode81SearchinRotatedSortedArrayII {
//    public boolean search(int[] nums, int target) {
//        if (nums.length == 0) return false;
//        if (nums.length == 1) return target == nums[0];
//
//        int pivot = findPivot(nums, 0, nums.length - 1);
//
//        if (target < nums[0]) {
//            return findTarget(nums, target, pivot + 1, nums.length - 1);
//        } else {
//            return findTarget(nums, target, 0, pivot);
//        }
//    }
//
//    private boolean findTarget(int[] nums, int target, int low, int high) {
//        if (low > high) return false;
//
//        int mid = (low + high) / 2;
//        if (nums[mid] == target) {
//            return true;
//        } else if (nums[mid] < target) {
//            return findTarget(nums, target, mid + 1, high);
//        } else {
//            return findTarget(nums, target, low, mid - 1);
//        }
//    }
//
//
//    private int findPivot(int[] nums, int low, int high) {
////        if (high < low) return nums.length - 1;
////
////        int mid = (low + high) / 2;
////
////        if (mid + 1 < nums.length) {
////            if (nums[mid] > nums[mid + 1]) {
////                return mid;
////            }
////        } else {
////            if (nums[mid - 1] > nums[mid]) {
////                return mid - 1;
////            }
////        }
////
////        if (nums[mid] <= nums[low]) {
////            return findPivot(nums, low, mid - 1);
////        } else {
////            return findPivot(nums, mid + 1, high);
////        }
//
//    }
//
//}

/**
 * Created by shengliyi on 2017/3/8.
 */
public class MergeSort {

    public static void mergeSort(int[] nums) {
        mergeSort(nums, 0, nums.length-1);
    }

    public static void mergeSort(int[] nums, int left, int right) {
        if (left < right) {
            int m = (left+right)/2;
            mergeSort(nums, left, m);
            mergeSort(nums, m+1, right);
            merge(nums, left, m, right);
        }
    }

    /*合并函数*/
    public static void merge(int nums[], int left, int mid ,int right) {
        int[] temp = new int[right-left+1];
        int i = left, j = mid + 1;
        int k = 0; //temp 的下标
        while ((i <= mid) && (j <= right)){
            if (nums[i] < nums[j]) temp[k++] = nums[i++];
            else temp[k++] = nums[j++];
        }
        while (i <= mid) temp[k++] = nums[i++];
        while (j <= right) temp[k++] = nums[j++];
        for (int l = left; l <= right; l++) {
            nums[l] = temp[l - left];
        }
    }
}

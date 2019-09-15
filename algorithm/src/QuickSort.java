public class QuickSort {
    public void quickSort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    private void quickSort(int[] nums, int left, int right) {
        if (left >= right) return;

        int mid = partition(nums, left, right);
        quickSort(nums, left, mid - 1);
        quickSort(nums, mid + 1, right);
    }

    private int partition(int[] nums, int left, int right) {

        int key = nums[left];
        int lPoint = left;
        int rPoint = right;

        while (lPoint < rPoint) {
            while (nums[rPoint] >= key && lPoint < rPoint) rPoint--;
            while (nums[lPoint] <= key && lPoint < rPoint) lPoint++;

            if (lPoint < rPoint) {
                int temp = nums[lPoint];
                nums[lPoint] = nums[rPoint];
                nums[rPoint] = temp;
            } else {
                nums[left] = nums[rPoint];
                nums[rPoint] = key;
            }
        }

        return rPoint;
    }
}

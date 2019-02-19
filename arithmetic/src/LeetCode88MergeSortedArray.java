/*
Example:

Input:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3

Output: [1,2,2,3,5,6]
 */

public class LeetCode88MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int len = nums1.length;
        int[] tempNums = new int[len];
        int index1 = 0;
        int index2 = 0;
        int indexTemp = 0;

        while (index1 < m && index2 < n) {
            if (nums1[index1] < nums2[index2]) {
                tempNums[indexTemp++] = nums1[index1++];
            } else {
                tempNums[indexTemp++] = nums2[index2++];
            }
        }

        while (index1 < m) {
            tempNums[indexTemp++] = nums1[index1++];
        }

        while (index2 < n) {
            tempNums[indexTemp++] = nums2[index2++];
        }

        for (int i = 0; i < len; i++) {
            nums1[i] = tempNums[i];
        }
    }
}

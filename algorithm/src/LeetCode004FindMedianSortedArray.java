/**
 * Created by shengliyi on 2017/4/15.
 */
public class LeetCode004FindMedianSortedArray {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // 将 nums1 和 nums2 中的数按大小依次放在新数组 combination 中，只放入一半，则 combination 最后的值即为 median
        // 每次找最大值都用不在 order 的数组的值和在 order 的数组的值比较
        int m = nums1.length;
        int n = nums2.length;
        double sumCount = m + n;
        int combineLength = (int)Math.ceil(sumCount / 2) + 1; // combineLength的长度
        double median = 0;
        double preMedian = 0;
        double nextMedian = 0;

        int a = 0, b = 0; // a b 表示当前 nums1 和 num2 的游标
        if (nums1.length == 0) {
            nums1 = new int[]{Integer.MAX_VALUE};
        }
        if (nums2.length == 0) {
            nums2 = new int[]{Integer.MAX_VALUE};
        }

        int[] combination = new int[combineLength];
        for (int i = 0; i < combineLength; i++) {
            if (a < m && b < n) {
                if (nums1[a] < nums2[b]) {
                    combination[i] = nums1[a];
                    a++;
                } else {
                    combination[i] = nums2[b];
                    b++;
                }
            } else if (a >= m) {
                combination[i] = nums2[b];
                b++;
            } else if (b >= n) {
                combination[i] = nums1[a];
                a++;
            }

        }

        preMedian = combination[combineLength - 2];
        nextMedian = combination[combineLength - 1];
        if ((m + n) % 2 != 0)
            median = preMedian;
        else
            median = (preMedian + nextMedian) / 2;

        return median;
    }

}

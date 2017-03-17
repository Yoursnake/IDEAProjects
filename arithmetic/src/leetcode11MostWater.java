/**
 * Created by shengliyi on 2017/3/17.
 */
public class leetcode11MostWater {

    public static int maxArea(int[] height) {
        int maxArea = 0;
        int length = height.length;

        // 此方法时间复杂度为 O(n^2)
        // for (int i = 0; i < length - 1; i++) {
        //     for (int j = i + 1; j < length; j++) {
        //         int area;
        //         int minHeight;
        //         minHeight = height[i]<height[j]?height[i]:height[j];
        //         area = minHeight*(j - i);
        //         if (area > maxArea) maxArea = area;
        //     }
        //  }

        // 此方法时间复杂度为 O(log n)
        int left = 0, right = length - 1;
        while (left < right) {
            int area;
            int minHeight;
            minHeight = height[left]<height[right]?height[left]:height[right];
            area = minHeight*(right - left);
            if (area > maxArea) maxArea = area;
            if (height[left] < height[right]) left++;
            else right--;
        }
        return maxArea;
    }
}

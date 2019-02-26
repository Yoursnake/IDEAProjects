/*
Example:

Input: [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
 */

import java.util.ArrayList;
import java.util.List;

public class LeetCode42TrappingRainWater {
    public int trap(int[] height) {
        if (height.length <= 2) return 0;

        int currMax = height[0];    // 存储当前最大值
        int result = 0;             // 存储结果
        List<Integer> list = new ArrayList<>(); // 当前最大值后面的数字

        for (int i = 1; i < height.length; i++) {
            if (height[i] < currMax) {
                list.add(height[i]);

                // 如果最后一个没有能够大于当前最大值，则反转list + currMax
                // 这样再调用一次函数能保证最后一个大于当前最大值
                if (i == height.length - 1) {
                    int[] tempHeight = new int[list.size() + 1];
                    for (int j = 0; j < list.size(); j++) {
                        tempHeight[j] = list.get(list.size() - 1 - j);
                    }
                    tempHeight[list.size()] = currMax;
                    result += trap(tempHeight);
                }
            } else {
                for (int j = 0; j < list.size(); j++) {
                    result += (currMax - list.get(j));
                }
                list.clear();
                currMax = height[i];    // 更新当前最大值
            }
        }

        return result;
    }

//    // DP 方法
//    public int trap(int[] height) {
//        int length = height.length;
//        //leftMax数组
//        int[] left = new int[length];
//        //rightMax数组
//        int[] right = new int[length];
//
//        int leftMax = 0;
//        int rightMax = 0;
//        for(int i = 0 ; i<length ; i++){
//            leftMax = left[i] = Math.max(leftMax,    height[i]);
//            rightMax = right[length-i-1] = Math.max(rightMax, height[length-i-1]);
//        }
//        int result = 0;
//        for(int j = 0 ; j<length ; j++){
//            result += Math.min(left[j], right[j]) - height[j];
//        }
//        return result;
//    }
}

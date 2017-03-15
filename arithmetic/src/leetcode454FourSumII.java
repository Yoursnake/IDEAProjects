import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by shengliyi on 2017/3/12.
 */
public class leetcode454FourSumII {

    public static int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
//        int length = A.length;
//        int count = 0;
//        //Arrays.sort(A);
//        //Arrays.sort(B);
//        Arrays.sort(C);
//        Arrays.sort(D);
//        for (int i = 0;i < length;i++) {
//            for (int j = 0;j < length;j++) {
//                int left = 0;
//                int right = length-1;
//                while (left < length && right >= 0) {
//                    int sum = A[i] + B[j] + C[left] + D[right];
//                    if (sum == 0) {
//                        count++;
//                        if (left < length-1){
//                            int tempLeft = left;
//                            while (C[tempLeft] == C[tempLeft+1]) {
//                                count++;
//                                tempLeft++;
//                            }
//                        }
//                        if (right > 0){
//                            int tempRight = right;
//                            while (D[tempRight] == D[tempRight-1]) {
//                                count++;
//                                tempRight--;
//                            }
//                        }
//
//                        left++;
//                        right--;
//                    }
//                    else if (sum < 0) left++;
//                    else right--;
//                }
//            }
//        }
//        return count;
        int count = 0;
        Map<Integer,Integer> ab = new HashMap<>();
        for (int a:A) {
            for (int b:B) {
                ab.put(a+b,ab.getOrDefault(a+b,0)+1);
            }
        }

        for (int c:C) {
            for (int d:D) {
                int temp = -c-d;
                count += ab.getOrDefault(temp,0);
            }
        }
        return count;
    }
}

/*
Example 1:

Input: n = 3, k = 3
Output: "213"

Example 2:

Input: n = 4, k = 9
Output: "2314"
 */

import java.util.ArrayList;
import java.util.List;

public class LeetCode60PermutationSequence {
//    // 方法1 : 回溯法找出所有字符串，然后找第 k 个
//    public String getPermutation(int n, int k) {
//        List<Character> nums = new ArrayList<>();
//        List<String> permutations = new ArrayList<>();
//        String curr = "";
//
//        for (int i = 0; i < n; i++) {
//            nums.add((char)(i + '1'));
//        }
//
//        getAllPermutations(permutations, curr, nums);
//        return permutations.get(k - 1);
//    }
//
//    void getAllPermutations(List<String> permutations, String curr, List<Character> nums) {
//        if (nums.size() == 0) {
//            permutations.add(curr);
//            return;
//        }
//
//        for (int i = 0; i < nums.size(); i++) {
//            String tempCurr = curr + nums.get(i);
//            List<Character> tempNums = new ArrayList<>(nums);
//            tempNums.remove(i);
//            getAllPermutations(permutations, tempCurr, tempNums);
//        }
//    }

    // 方法2 : 使用递归求解，每次算当前剩余数字中的首位变化一位需要的数，然后求倍数，
    // 这样当前首位就是剩余数字中索引为倍数的数（注意能整除的情况就行）
    public String getPermutation(int n, int k) {
        String result = new String("");
        List<Character> nums = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            nums.add((char)(i + '1'));
        }

        result = getPermutation(nums, k);

        return result;
    }

    String getPermutation(List<Character> nums, int remainder) {
        int numsLen = nums.size();  // 即 n
        if (numsLen == 1) {
            return nums.get(0) + "";
        }

        int divisor = factorial(numsLen - 1);
        int multiple = remainder / divisor;

        // 当能整除时就放出一位，作为余数
        if (remainder % divisor == 0) {
            multiple--;
            remainder = divisor;
        } else {
            remainder = remainder % divisor;
        }

        char addChar = nums.get(multiple);
        nums.remove(multiple);
        return addChar + getPermutation(nums, remainder);
    }

    // 阶乘
    int factorial(int n) {
        int result = 1;

        for (int i = 2; i <= n; i++) {
            result *= i;
        }

        return result;
    }
}

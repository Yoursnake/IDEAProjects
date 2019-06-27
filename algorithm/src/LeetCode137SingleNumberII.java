/*
Given a non-empty array of integers, every element appears three times
except for one, which appears exactly once. Find that single one.

Note:

Your algorithm should have a linear runtime complexity. Could you
implement it without using extra memory?

Example 1:

Input: [2,2,3,2]
Output: 3
Example 2:

Input: [0,1,0,1,0,1,99]
Output: 99
 */

public class LeetCode137SingleNumberII {
//    // use set 35.90%
//    public int singleNumber(int[] nums) {
//        HashMap<Integer, Integer> map = new HashMap<>();
//
//        for (int num : nums) {
//            int count = map.getOrDefault(num, 0) + 1;
//            if (count == 3) map.remove(num);
//            else map.put(num, count);
//        }
//
//        Set<Integer> set = map.keySet();
//        Iterator<Integer> it = set.iterator();
//        return it.next();
//    }

    // without using extra space 58.71%
    public int singleNumber(int[] nums) {
        int result = 0;

        // int 最多 32 位，检查每位数目，如果数目不是 3 的倍数，证明该位是那个特殊数的
        for (int i = 0; i < 32; i++) {
            int sum = 0;

            for (int num : nums) {
                if (((num >> i) & 1) == 1) sum++;
            }

            if (sum % 3 != 0) result |= 1 << i;
        }

        return result;
    }
}

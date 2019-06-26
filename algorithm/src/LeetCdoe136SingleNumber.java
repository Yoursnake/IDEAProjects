/*
Given a non-empty array of integers, every element appears twice except for one.
Find that single one.

Note:

Your algorithm should have a linear runtime complexity. Could you implement it
without using extra memory?

Example 1:

Input: [2,2,1]
Output: 1
Example 2:

Input: [4,1,2,1,2]
Output: 4
 */

public class LeetCdoe136SingleNumber {
//    // use set 33.52%
//    public int singleNumber(int[] nums) {
//        HashSet<Integer> set = new HashSet<>();
//
//        for (int num : nums) {
//            if (set.contains(num)) set.remove(num);
//            else set.add(num);
//        }
//
//        Iterator<Integer> it = set.iterator();
//        return it.next();
//    }

    // without using extra space
    // 使用异或 x^x=0，x^0=x 且 A XOR B XOR B = A xor  0 = A
    public int singleNumber(int[] nums) {
        int a = nums[0];
        for (int i = 1; i < nums.length; i++) {
            a ^= nums[i];
        }
        return a;
    }
}

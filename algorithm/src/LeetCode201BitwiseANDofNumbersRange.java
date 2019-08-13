/*
Given a range [m, n] where 0 <= m <= n <= 2147483647, return the
bitwise AND of all numbers in this range, inclusive.

Example 1:

Input: [5,7]
Output: 4

Example 2:

Input: [0,1]
Output: 0
 */

public class LeetCode201BitwiseANDofNumbersRange {
//    // 12% 只找 m 中的 1，如果加上 plusNum 小于等于 n 证明该位为 0
//    public int rangeBitwiseAnd(int m, int n) {
//        if (m == n) return m;
//
//        // 去 long 防止越界
//        long mCopy = m;
//        long plusNum = (mCopy % 2 == 1) ? 1 : 2;    // 加多少可以进当前位
//        int result = 0;
//        int count = 1;  // 当前在 m 的第几位
//
//        while (mCopy != 0) {
//            if (mCopy % 2 == 1 && m + plusNum > n)
//                result += (1 << (count - 1));
//
//            mCopy = mCopy >> 1;
//            count++;
//            plusNum += (mCopy % 2 == 1) ? 0 : 1 << (count - 1);
//        }
//
//        return result;
//    }

    // 100% 本质是找最长二进制首部
    public int rangeBitwiseAnd(int m, int n) {
        int i = 0;

        while (m != n) {
            m = m >> 1;
            n = n >> 1;
            i++;
        }

        return m << i;
    }
}

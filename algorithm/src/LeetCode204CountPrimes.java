/*
Count the number of prime numbers less than a non-negative
number, n.

Example:

Input: 10
Output: 4
Explanation: There are 4 prime numbers less than 10, they
are 2, 3, 5, 7.
 */

public class LeetCode204CountPrimes {
//    // 暴力枚举 5%
//    public int countPrimes(int n) {
//        int result = 0;
//
//        for (int i = 2; i < n; i++) {
//            if (isPrime(i)) result++;
//        }
//
//        return result;
//    }
//
//    private boolean isPrime(int n) {
//        if (n < 2) return false;
//
//        for (int i = 2; i <= Math.sqrt(n); i++) {
//            if (n % i == 0) return false;
//        }
//
//        return true;
//    }

    // 埃拉托斯特尼筛法 69.56%
    public int countPrimes(int n) {
        boolean[] notPrimes = new boolean[n];
        int result = 0;

        for (int i = 2; i < n; i++) {
            if (notPrimes[i]) continue;

            result++;
            for (int j = 2; i * j < n; j++) {
                notPrimes[i * j] = true;
            }
        }

        return result;
    }
}

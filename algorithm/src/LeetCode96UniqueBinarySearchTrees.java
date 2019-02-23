/*
Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?

Example:

Input: 3
Output: 5
Explanation:
Given n = 3, there are a total of 5 unique BST's:

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3

 */

public class LeetCode96UniqueBinarySearchTrees {

    // dp 做法
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;      // 0 个元素算一种情况
        dp[1] = 1;      // 1 个元素只有一种情况

        for (int i = 2; i < n + 1; i++) {
            for (int j = 0; j < i; j++) {
                // dp[j] 表示左子树中一共有 j 个元素
                // dp[i - 1 - j] 表示右子树中一个有 i - 1 - j 个元素
                // 两者相加等于 i - 1 个元素，因为一个元素要作为根节点
                dp[i] += dp[j] * dp[i - 1 - j];
            }
        }

        return dp[n];
    }

//    // 递归做法，时间复杂度较高，应改为 dp
//    public int numTrees(int n) {
//        if (n < 1) return 0;
//        else return findNum(1, n);
//    }
//
//    private int findNum(int left, int right) {
//        if (left >= right) return 1;
//
//        int result = 0;
//
//        for (int i = left; i <= right; i++) {
//            int leftNum = findNum(left, i - 1);
//            int rightNum = findNum(i + 1, right);
//
//            result += leftNum * rightNum;
//        }
//
//        return result;
//    }
}

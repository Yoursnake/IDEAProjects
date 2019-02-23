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
}

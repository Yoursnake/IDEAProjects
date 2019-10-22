/*
Given n balloons, indexed from 0 to n-1. Each balloon is painted with a number on 
it represented by array nums. You are asked to burst all the balloons. If the you 
burst balloon i you will get nums[left] * nums[i] * nums[right] coins. Here left 
and right are adjacent indices of i. After the burst, the left and right then 
becomes adjacent.

Find the maximum coins you can collect by bursting the balloons wisely.

Note:

You may imagine nums[-1] = nums[n] = 1. They are not real therefore you can not burst them.
0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100

Example:

Input: [3,1,5,8]
Output: 167 
Explanation: nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
             coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
*/

public class LeetCode312BurstBalloons {
//	// DFS + HashMap: TLE
//	public int maxCoins(int[] nums) {
//		List<Integer> numsList = new ArrayList<>(nums.length);
//		Map<List<Integer>, Integer> map = new HashMap<>();
//
//		for (int num : nums) numsList.add(num);
//
//		int res = findMaxDFS(numsList, map);
//		return res;
//	}
//
//	private int findMaxDFS(List<Integer> nums, Map<List<Integer>, Integer> map) {
//		if (nums.size() == 0) return 0;
//		if (nums.size() == 1) return nums.get(0);
//		if (map.containsKey(nums)) return map.get(nums);
//
//		int max = 0;
//		int size = nums.size();
//
//		for (int i = 0; i < size; i++) {
//			int left = (i == 0) ? 1 : nums.get(i - 1);
//			int right = (i == size - 1) ? 1 : nums.get(i + 1);
//			int mid = nums.get(i);
//
//			nums.remove(i);
//			int val = left * mid * right + findMaxDFS(nums, map);
//			if (val > max) max = val;
//			nums.add(i, mid);
//		}
//
//
//		map.put(new ArrayList<>(nums), max);
//
//		return max;
//	}

//	// DP:6.5% 14ms
//	public int maxCoins(int[] nums) {
//		List<Integer> list = new ArrayList<>();
//		int n = nums.length;
//		int[][] dp = new int[n + 2][n + 2];
//
//		list.add(1);
//		for (int num : nums) list.add(num);
//		list.add(1);
//
//		for (int l = 1; l <= n; l++) {
//			for (int i = 1; i <= n - l + 1; i++) {
//				int j = i + l - 1;
//
//				for (int k = i; k <= j; k++) {
//					dp[i][j] = Math.max(dp[i][j],
//						dp[i][k - 1] + dp[k + 1][j] + nums[k] * nums[i - 1] * nums[j + 1]);
//				}
//			}
//		}
//
//		return dp[1][n];
//	}

	// DP:19% 8ms   dp[i][j] = max(dp[i][k-1] + nums[i-1]*nums[k]*nums[j+1] + dp[k+1][j]) i<=k<=j
	// | i-1 | i | i+1 | ... | k-1 | k | k+1 | ... | j-1 | j | j+1 |     
	// dp[i][j] 表示 i 到 j 的 maxCoins，表达式表示先打破 i 到 k-1 和 k+1 到 j，最后打破 k
	public int maxCoins(int[] nums) {
		int n = nums.length;
		int[][] dp = new int[n][n];

		for (int l = 1; l <= n; l++) {
			for (int i = 0; i <= n - l; i++) {
				int j = i + l - 1;

				for (int k = i; k <= j; k++) {
					int left = (i == 0) ? 1 : nums[i - 1];
					int right = (j == n - 1) ? 1 : nums[j + 1];
					int leftVal = (k == i) ? 0 : dp[i][k - 1];
					int rightVal = (k == j) ? 0 : dp[k + 1][j];

					dp[i][j] = Math.max(dp[i][j],
							leftVal + rightVal + left * nums[k] * right);
				}
			}
		}

		return dp[0][n - 1];
	}
}
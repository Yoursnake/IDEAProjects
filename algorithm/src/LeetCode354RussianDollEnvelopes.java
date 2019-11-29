/*
You have a number of envelopes with widths and heights given as 
a pair of integers (w, h). One envelope can fit into another if 
and only if both the width and height of one envelope is greater 
than the width and height of the other envelope.

What is the maximum number of envelopes can you Russian doll? 
(put one inside other)

Note:
Rotation is not allowed.

Example:

Input: [[5,4],[6,4],[6,7],[2,3]]
Output: 3 
Explanation: The maximum number of envelopes you can Russian doll 
is 3 ([2,3] => [5,4] => [6,7]).
*/

import java.util.*;

public class LeetCode354RussianDollEnvelopes {
	// // DP: O(n^2) 390ms 5.4%
	// // 先对 width 进行排序，然后借鉴 368 or 300 题的思想
	// public int maxEnvelopes(int[][] envelopes) {
	// 	if (envelopes == null || envelopes.length == 0) return 0;

	// 	Arrays.sort(envelopes, new Comparator<int[]>() {
	// 		@Override
	// 		public int compare(int[] o1, int[] o2) {
	// 			if (o1[0] != o2[0]) {
	// 				return o1[0] - o2[0];
	// 			} else {
	// 				return o1[1] - o2[1];
	// 			}
	// 		}
	// 	});

	// 	int[] dp = new int[envelopes.length];
	// 	int max = 1;
	// 	Arrays.fill(dp, 1);

	// 	for (int i = 1; i < dp.length; i++) {
	// 		for (int j = i - 1; j >= 0; j--) {
	// 			if (envelopes[i][0] != envelopes[j][0] &&
	// 					envelopes[i][1] > envelopes[j][1]) {
	// 				dp[i] = Math.max(dp[i], dp[j] + 1);
	// 			}
	// 		}

	// 		max = Math.max(max, dp[i]);
	// 	}

	// 	return max;
	// }

	// Divide 二分法：O(nlogn) 14ms 70%
	// 借鉴 300 题思想，先对 width 进行排序，注意如果 width 一样的话，对 height 要进行相反的排序，之后就可以做 LIS 问题了
	public int maxEnvelopes(int[][] envelopes) {
		if (envelopes == null || envelopes.length == 0) return 0;

		Arrays.sort(envelopes, new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				if (o1[0] != o2[0]) {
					return o1[0] - o2[0];
				} else {
					return o2[1] - o1[1];	// 这一步是关键
				}
			}
		});

		List<Integer> list = new ArrayList<>();

		for (int[] envelope : envelopes) {
			// 如果新来的比 list 末尾元素大，则 add 到 list
			if (list.size() == 0 || list.get(list.size() - 1) < envelope[1]) {
				list.add(envelope[1]);
			} else {
				int left = 0, right = list.size();
				while (left < right) {
					int mid = left + (right - left) / 2;
					if (list.get(mid) < envelope[1]) left = mid + 1;
					else right = mid;
				}

				list.set(left, envelope[1]);
			}
		}

		return list.size();
	}
}
/*
Given an integer n, return 1 - n in lexicographical order.

For example, given 13, return: [1,10,11,12,13,2,3,4,5,6,7,8,9].

Please optimize your algorithm to use less time and space. 
The input size may be as large as 5,000,000.
*/

import java.util.*;

public class LeetCode386LexicographicalNumbers {

	// DFS: 2ms 86%
	public List<Integer> lexicalOrder(int n) {
		List<Integer> res = new ArrayList<>();
		addNumDFS(res, n, 1);
		return res;
	}

	private void addNumDFS(List<Integer> res, int n, int curr) {
		if (curr > n) return;

		// 必须从 0~9
		for (int i = 0; i <= 9 && curr + i <= n; i++) {
            if (curr == 1 && i == 9) break;		// 这一步很重要，只有在 curr 为 1 时不能加 9，否则会多一个 10
            
			res.add(curr + i);	// 先添加位数少的数，如果 * 10 仍小于 n，则先处理 * 10 的数
			if ((curr + i) * 10 <= n) {
				addNumDFS(res, n, (curr + i) * 10);
			}
		}
	}
}
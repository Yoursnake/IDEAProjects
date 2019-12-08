/*
Given a n x n matrix where each of the rows and columns are sorted 
in ascending order, find the kth smallest element in the matrix.

Note that it is the kth smallest element in the sorted order, 
not the kth distinct element.

Example:

matrix = [
   [ 1,  5,  9],
   [10, 11, 13],
   [12, 13, 15]
],
k = 8,

return 13.

Note:
You may assume k is always valid, 1 ≤ k ≤ n2.
*/

import java.util.*;

public class LeetCode378KthSmallestElementinaSortedMatrix {
	// // Merge Sort: O(kn) 39ms 18%
	// public int kthSmallest(int[][] matrix, int k) {
	// 	int n = matrix.length;
	// 	int[] points = new int[n];
	// 	int res = 0;

	// 	while (k-- > 0) {
	// 		int currMin = Integer.MAX_VALUE;
	// 		int minIdx = -1;
	// 		for (int i = 0; i < n; i++) {
	// 			if (points[i] == n) continue;

	// 			if (currMin > matrix[i][points[i]]) {
	// 				currMin = matrix[i][points[i]];
	// 				minIdx = i;
	// 			}
	// 		}

	// 		points[minIdx]++;
	// 		if (k == 0) res = currMin;
	// 	}

	// 	return res;
	// }

	// // PriorityQueue: O(klogk) 40ms 18%
	// public int kthSmallest(int[][] matrix, int k) {
	// 	int n = matrix.length;
	// 	PriorityQueue<List<Integer>> pq = new PriorityQueue<>(
	// 			(l1, l2) -> (l1.get(2) - l2.get(2))
	// 		);

	// 	// List 中三个元素   0: 第几行  1: 第几列  2 对应的值是多少
	// 	for (int i = 0; i < n; i++) pq.offer(new ArrayList<>(Arrays.asList(0, i, matrix[0][i])));

	// 	// 这边只循环到 k - 1，最后一个元素就是 pq.poll()
	// 	for (int i = 0; i < k - 1; i++) {
	// 		List<Integer> list = pq.poll();	// 把最小的元素剔除
	// 		if (list.get(0) == n - 1) continue;	// 如果一列元素用完，就跳过
	// 		pq.offer(new ArrayList<>(Arrays.asList(list.get(0) + 1, list.get(1), matrix[list.get(0) + 1][list.get(1)])));
	// 	}

	// 	return pq.poll().get(2);
	// }

	// // PriorityQueue: O(klogk) 17ms 53%   自己写的数据结构比 ArrayList 快不少
	// // 类似：LeetCode373
	// // 参考：https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/discuss/85173/Share-my-thoughts-and-Clean-Java-Code
	// public int kthSmallest(int[][] matrix, int k) {
	// 	int n = matrix.length;
	// 	PriorityQueue<Tuple> pq = new PriorityQueue<>(
	// 			(t1, t2) -> (t1.val - t2.val)
	// 		);

	// 	// List 中三个元素   0: 第几行  1: 第几列  2 对应的值是多少
	// 	for (int i = 0; i < n; i++) pq.offer(new Tuple(0, i, matrix[0][i]));

	// 	// 这边只循环到 k - 1，最后一个元素就是 pq.poll()
	// 	for (int i = 0; i < k - 1; i++) {
	// 		Tuple t = pq.poll();	// 把最小的元素剔除
	// 		if (t.x == n - 1) continue;	// 如果一列元素用完，就跳过
	// 		pq.offer(new Tuple(t.x + 1, t.y, matrix[t.x + 1][t.y]));
	// 	}

	// 	return pq.poll().val;
	// }

	// private class Tuple {
	// 	int x;
	// 	int y;
	// 	int val;

	// 	public Tuple(int x, int y, int val) {
	// 		this.x = x;
	// 		this.y = y;
	// 		this.val = val;
	// 	}
	// }

	// Divide: O(nlogn) 1ms 86%
	// 类似：LeetCode287
	// 参考：https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/discuss/85173/Share-my-thoughts-and-Clean-Java-Code
	public int kthSmallest(int[][] matrix, int k) {
		int n = matrix.length;
		int left = matrix[0][0], right = matrix[n - 1][n - 1] + 1; // [left, right)

		while (left < right) {
			int mid = left + (right - left) / 2;
			int j = n - 1;
			int cnt = 0;	// 所有数中比 mid 小的数的总个数

			// 每次循环相当于计算一行中比 mid 小的数的个数
			for (int i = 0; i < n; i++) {
				while (j >=0 && matrix[i][j] > mid) j--;
				cnt += (j + 1);
			}

			// 如果比 mid 小的总个数小于 k，表明 mid 太小了，则范围应该在 [mid + 1, right]
			// 否则范围在 [left, mid)
			if (cnt < k) left = mid + 1;
			else right = mid;
		}

		return left;
	}
}
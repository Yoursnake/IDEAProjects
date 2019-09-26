/*
Write a program to find the n-th ugly number.

Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. 

Example:

Input: n = 10
Output: 12
Explanation: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.

Note:  

1 is typically treated as an ugly number.
n does not exceed 1690.
*/

import java.util.List;
import java.util.ArrayList;

public class LeetCode264UglyNumberII {

	// 32.30% 16ms
	// idx2 表示第一个乘 2 大于 list 中最大丑数的数的索引，idx3 idx5 同理
	public int nthUglyNumber(int n) {
		List<Integer> list = new ArrayList<>();
		list.add(1);
		int idx2 = 0, idx3 = 0, idx5 = 0;

		while (list.size() < n) {
			int tmp = Math.min(Math.min(list.get(idx2) * 2, list.get(idx3) * 3), list.get(idx5) * 5);
			list.add(tmp);
			if (tmp == list.get(idx2) * 2) idx2++;
			if (tmp == list.get(idx3) * 3) idx3++;
			if (tmp == list.get(idx5) * 5) idx5++;
		}

		return list.get(list.size() - 1);
	}
}
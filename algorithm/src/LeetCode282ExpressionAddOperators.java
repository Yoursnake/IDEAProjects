/*
Given a string that contains only digits 0-9 and a target value, 
return all possibilities to add binary operators (not unary) +, 
-, or * between the digits so they evaluate to the target value.

Example 1:

Input: num = "123", target = 6
Output: ["1+2+3", "1*2*3"] 

Example 2:

Input: num = "232", target = 8
Output: ["2*3+2", "2+3*2"]

Example 3:

Input: num = "105", target = 5
Output: ["1*0+5","10-5"]

Example 4:

Input: num = "00", target = 0
Output: ["0+0", "0-0", "0*0"]

Example 5:

Input: num = "3456237490", target = 9191
Output: []
*/

import java.util.*;

public class LeetCode282ExpressionAddOperators {

//	// DFS: 5% 367ms
//	public List<String> addOperators(String num, int target) {
//		List<String> res = new ArrayList<>();
//		List<String> tmp = new ArrayList<>();
//
//		DFS(num, target, "", res, 1);
//
//		for (String s : res) {
//			if (s.charAt(0) == '+') tmp.add(s.substring(1));
//		}
//
//		return tmp;
//	}
//
//	private void DFS(String num, long target, String curr, List<String> res, long last) {
//		if (num.length() == 0) {
//			if (target == 0) res.add(curr);
//			return;
//		}
//
//		for (int i = 0; i < num.length(); i++) {
//			long tmp = Long.parseLong(num.substring(0, i + 1));	// 使用 long 型防止越界
//
//			DFS(num.substring(i + 1), target - tmp, curr + "+" + tmp, res, tmp);
//			DFS(num.substring(i + 1), target + tmp, curr + "-" + tmp, res, -tmp);
//			DFS(num.substring(i + 1) , target + last - last * tmp, curr + "*" + tmp, res, last * tmp);
//
//			if (tmp == 0) break;	// 如果此时数字为 0 不继续往下遍历
//		}
//	}

	// DFS: 40.7% 130ms -> 70.7% 95ms
	public List<String> addOperators(String num, int target) {
		List<String> res = new ArrayList<>();

		DFS(num, 0, target, "", res, 1);

		return res;
	}

	private void DFS(String num, int pos, long target, String curr, List<String> res, long last) {
		if (pos == num.length()) {
			if (target == 0) res.add(curr);
			return;
		}

		long tmp = 0;
		for (int i = pos; i < num.length(); i++) {
//			long tmp = Long.parseLong(num.substring(pos, i + 1));
//			for (int j = pos; j < i + 1; j++) tmp = tmp * 10 + (num.charAt(j) - '0');
			tmp = tmp * 10 + (num.charAt(i) - '0');     // 这样避免了每次的 substring 和 parseLong 的时间损耗

			if (pos == 0) {
				DFS(num, i + 1, target - tmp, curr + tmp, res, tmp);
			} else {
				DFS(num, i + 1, target - tmp, curr + "+" + tmp, res, tmp);
				DFS(num, i + 1, target + tmp, curr + "-" + tmp, res, -tmp);
				DFS(num, i + 1, target + last - tmp * last, curr + "*" + tmp, res, tmp * last);
			}

			if (tmp == 0) break;        // 如果此时数字为 0 不继续往下遍历
		}
	}
}
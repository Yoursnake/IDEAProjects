/*
Remove the minimum number of invalid parentheses in order to make 
the input string valid. Return all possible results.

Note: The input string may contain letters other than the parentheses ( and ).

Example 1:

Input: "()())()"
Output: ["()()()", "(())()"]
Example 2:

Input: "(a)())()"
Output: ["(a)()()", "(a())()"]
Example 3:

Input: ")("
Output: [""]
*/

import java.util.*;

public class LeetCode301RemoveInvalidParentheses {
	/****************************BFS*********************************/
	// // BFS: 20.4% 56ms
	// public List<String> removeInvalidParentheses(String s) {
	// 	if (s == null || s.length() == 0) return new ArrayList<String>(Arrays.asList(""));

	// 	List<String> res = new ArrayList<>();
	// 	Set<String> set = new HashSet<>();
	// 	Queue<String> queue = new LinkedList<>();
	// 	boolean found = false;

	// 	queue.offer(s);

	// 	while (!queue.isEmpty()) {
	// 		String curr = queue.poll();

	// 		if (judgeValid(curr)) {
	// 			res.add(curr);
	// 			found = true;
	// 		}

	// 		if (found) continue;	// 当找到，说明所有结果只可能出现在这一层（删去同样数量的括号），确保删去最少的括号

	// 		for (int i = 0; i < curr.length(); i++) {
	// 			if (curr.charAt(i) != '(' && curr.charAt(i) != ')') continue;

	// 			String removeStr = curr.substring(0, i) + curr.substring(i + 1, curr.length());

	// 			if (!set.contains(removeStr)) {
	// 				queue.offer(removeStr);
	// 				set.add(removeStr);
	// 			}
	// 		}
	// 	}

	// 	return res;
	// }

	// private boolean judgeValid(String s) {
	// 	int cnt = 0;

	// 	for (int i = 0; i < s.length(); i++) {
	// 		if (s.charAt(i) == '(') cnt++;
	// 		else if (s.charAt(i) == ')') cnt--;

	// 		if (cnt < 0) return false;
	// 	}

	// 	return cnt == 0;
	// }

	/****************************DFS1*********************************/
	// // DFS1: 56.6% 5ms  每次递归的前提是当前不合法括号小于上一次的不合法括号
	// public List<String> removeInvalidParentheses(String s) {
	// 	if (s == null || s.length() == 0) return new ArrayList<String>(Arrays.asList(""));

	// 	List<String> res = new ArrayList<>();
	// 	Set<String> set = new HashSet<>();

	// 	DFS(s, res, set, numInvalid(s), 0);

	// 	return res;
	// }

	// private void DFS(String s, List<String> res, Set<String> set, int num, int start) {
	// 	if (num == 0) {
	// 		res.add(s);
	// 		return;
	// 	}

	// 	// 保存 start 可以有效减少重复遍历，14ms -> 5ms
	// 	for (int i = start; i < s.length(); i++) {
	// 		String removeStr = s.substring(0, i) + s.substring(i + 1, s.length());

	// 		if (!set.contains(removeStr)) {
	// 			int newNum = numInvalid(removeStr);
	// 			// 通过比较新的字符串比删前的字符串的不合理括号小来剪枝（确保了删除最少数量的括号）
	// 			if (newNum < num) DFS(removeStr, res, set, newNum, i);	
	// 			set.add(removeStr);					
	// 		}
	// 	}
	// }

	// // 计算不合法的括号数量（包括左右）
	// private int numInvalid(String s) {
	// 	int left = 0, right = 0;

	// 	for (int i = 0; i < s.length(); i++) {
	// 		if (s.charAt(i) == '(') {
	// 			left++;
	// 		} else if (s.charAt(i) == ')') {
	// 			if (left == 0) {
	// 				right++;
	// 			} else {
	// 				left--;
	// 			}
	// 		}
	// 	}

	// 	return left + right;
	// }

	/****************************DFS2*********************************/
	// // DFS2: 68% 4ms	每次递归的前提是左括号不合法数量或右括号不合法数量为正，加入 list 前还要判断一次字符串是否合法
	// public List<String> removeInvalidParentheses(String s) {
	// 	if (s == null || s.length() == 0) return new ArrayList<String>(Arrays.asList(""));

	// 	int left = 0, right = 0;	// 表示不合法的左右括号数量
	// 	List<String> res = new ArrayList<>();

	// 	for (char c : s.toCharArray()) {
	// 		if (c == '(') {
	// 			left++;
	// 		} else if (c == ')') {
	// 			if (left == 0) right++;
	// 			else left--;
	// 		}
	// 	}

	// 	DFS(s, res, left, right, 0);

	// 	return res;
	// }

	// private void DFS(String s, List<String> res, int left, int right, int start) {
	// 	// 只有等不合法的左右括号数量都为 0 时，才有机会判断字符串是否合法
	// 	if (left == 0 && right == 0) {
	// 		if (judgeValid(s)) res.add(s);
	// 		return;
	// 	}

	// 	for (int i = start; i < s.length(); i++) {
	// 		if (i != start && s.charAt(i) == s.charAt(i - 1)) continue;	// 每次只删除第一个括号，防止重复

	// 		if (left > 0 && s.charAt(i) == '(') {
	// 			DFS(s.substring(0, i) + s.substring(i + 1, s.length()), res, left - 1, right, i);
	// 		}

	// 		if (right > 0 && s.charAt(i) == ')') {
	// 			DFS(s.substring(0, i) + s.substring(i + 1, s.length()), res, left, right - 1, i);
	// 		}
	// 	}
	// }

	// private boolean judgeValid(String s) {
	// 	int cnt = 0;

	// 	for (char c : s.toCharArray()) {
	// 		if (c == '(') cnt++;
	// 		else if (c == ')') cnt--;
				
	// 		if (cnt < 0) return false;
	// 	}

	// 	return cnt == 0;
	// }

	/****************************DFS3*********************************/
	// DFS3: 100% 1ms    奇妙的递归思想，先正着删除右括号，然后把字符串反过来删除左括号
	public List<String> removeInvalidParentheses(String s) {
		if (s == null || s.length() == 0) return new ArrayList<String>(Arrays.asList(""));

		List<String> res = new ArrayList<>();

		DFS(s, res, 0, 0, new char[] {'(', ')'});

		return res;
	}

	// last_i 表示判断（是否合法）到第几位，last_j 表示上次删到了第几位，char[] p 很关键，用于翻转字符串后进行递归
	private void DFS(String s, List<String> res, int last_i, int last_j, char[] p) {
		int cnt = 0;	// 用于判断括号是否合法

		for (int i = last_i; i < s.length(); i++) {
			if (s.charAt(i) == p[0]) cnt++;
			else if (s.charAt(i) == p[1]) cnt--;

			if (cnt >= 0) continue;		// cnt 如果小于 0 说明不合法，前面需要删除一个括号

			for (int j = last_j; j <= i; j++) {
				if (j != last_j && s.charAt(j) == s.charAt(j - 1)) continue;	// 只删除第一个括号，防止重复

				if (s.charAt(j) == p[1]) {
					DFS(s.substring(0, j) + s.substring(j + 1, s.length()), res, i, j, p);
				} 
			}
			return;	// 进入第二层循环的都是右括号多的情况，删除后可直接返回
		}

		String rev = new StringBuilder(s).reverse().toString();

		// p[0] 如果为 '(' 表明还未进行翻转后的删除，因此进行一次翻转字符串的递归
		if (p[0] == '(') DFS(rev, res, 0, 0, new char[] {')', '('});
		else res.add(rev);
	}
}
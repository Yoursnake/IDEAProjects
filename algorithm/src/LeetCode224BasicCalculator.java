/*
Implement a basic calculator to evaluate a simple expression string.

The expression string may contain open ( and closing parentheses ), 
the plus + or minus sign -, non-negative integers and empty spaces .

Example 1:

Input: "1 + 1"
Output: 2

Example 2:

Input: " 2-1 + 2 "
Output: 3

Example 3:

Input: "(1+(4+5+2)-3)+(6+8)"
Output: 23

Note:
You may assume that the given expression is always valid.
Do not use the eval built-in library function.
*/

import java.util.Stack;

public class LeetCode224BasicCalculator {

	// Stack: 72.88%
	public int calculate(String s) {
		Stack<Integer> stack = new Stack<>();
		int res = 0;
		int sign = 1;	// 表示符号 1 为 +，-1为 -，计算方式为 res = res + sign * curr
		int curr = 0;
		s = s + " ";	// 为了能在循环中直接计算出结果

		for (char c : s.toCharArray()) {
			if (Character.isDigit(c)) {
				curr = curr * 10 + (c - '0');
			} else {
				res += sign * curr;
				curr = 0;

				switch (c) {
					case '+': sign = 1; break;
					case '-': sign = -1; break;
					case '(':
						stack.push(res);
						stack.push(sign);
						res = 0;
						sign = 1;
						break;
					case ')':
						int num1 = stack.pop();
						int num2 = stack.pop();
						res = num2 + num1 * res;
						break;
					default: break;
				}
			}
		}

		return res;
	}
}
/*
The expression string contains only non-negative integers, 
+, -, *, / operators and empty spaces . The integer division 
should truncate toward zero.

Example 1:

Input: "3+2*2"
Output: 7

Example 2:

Input: " 3/2 "
Output: 1

Example 3:

Input: " 3+5 / 2 "
Output: 5

Note:

You may assume that the given expression is always valid.
Do not use the eval built-in library function.
*/

public class LeetCode227BasicCalculatorII {
	// // Stack: 68.44%
	// public int calculate(String s) {
	// 	Stack<Integer> stack = new Stack<>();
	// 	int res = 0;
	// 	char sign = '+';
	// 	int curr = 0;
	// 	s = s + "+";

	// 	for (char c : s.toCharArray()) {
	// 		if (c == ' ') continue;

	// 		if (Character.isDigit(c)) {
	// 			curr = curr * 10 + (c - '0');
	// 		} else {
	// 			switch (sign) {
	// 				case '+': stack.push(curr); break;
	// 				case '-': stack.push(-curr); break;
	// 				case '*': stack.push(stack.pop() * curr); break;
	// 				case '/': stack.push(stack.pop() / curr); break;
	// 			}

	// 			curr = 0;
	// 			sign = c;
	// 		}
	// 	}

	// 	for (int i : stack) res += i;

	// 	return res;
	// }

	// 96.20%
	public int calculate(String s) {
		int res = 0;
		int curr = 0;
		int pre = 0;
		char sign = '+';
		s = s + "+";

		for (char c : s.toCharArray()) {
			if (c == ' ') continue;

			if (Character.isDigit(c)) {
				curr = curr * 10 + (c - '0');
			} else {
				switch (sign) {
					case '+': 
						res += curr;
						pre = curr;
						break;
					case '-':
						res -= curr;
						pre = -curr;
						break;
					case '*':
						res = res - pre + pre * curr;
						pre = pre * curr;
						break;
					case '/':
						res = res - pre + pre / curr;
						pre = pre / curr;
						break;	
				}

				curr = 0;
				sign = c;
			}
		}

		return res;
	}
}
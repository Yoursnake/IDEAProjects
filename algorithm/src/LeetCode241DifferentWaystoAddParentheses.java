/*
Given a string of numbers and operators, return all possible results 
from computing all the different possible ways to group numbers and 
operators. The valid operators are +, - and *.

Example 1:

Input: "2-1-1"
Output: [0, 2]
Explanation: 
((2-1)-1) = 0 
(2-(1-1)) = 2
Example 2:

Input: "2*3-4*5"
Output: [-34, -14, -10, -10, 10]
Explanation: 
(2*(3-(4*5))) = -34 
((2*3)-(4*5)) = -14 
((2*(3-4))*5) = -10 
(2*((3-4)*5)) = -10 
(((2*3)-4)*5) = 10
*/

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class LeetCode241DifferentWaystoAddParentheses {

	Map<String, List<Integer>> map = new HashMap<>();

	// Divide and conquer: 100% 使用 map 存储中间结果
	public List<Integer> diffWaysToCompute(String input) {
		List<Integer> res = new ArrayList<>();
		if (map.containsKey(input)) return map.get(input);

		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);

			if (!Character.isDigit(c)) {
				List<Integer> left = diffWaysToCompute(input.substring(0, i));
				List<Integer> right = diffWaysToCompute(input.substring(i + 1, input.length()));

				for (int j = 0; j < left.size(); j++) {
					for (int k = 0; k < right.size(); k++) {
						switch (c) {
							case '+': res.add(left.get(j) + right.get(k)); break;
							case '-': res.add(left.get(j) - right.get(k)); break;
							case '*': res.add(left.get(j) * right.get(k)); break;
						}
					}
				}
			}
		}

		if (res.isEmpty()) res.add(Integer.parseInt(input));
		map.put(input, res);

		return res;
	}
}
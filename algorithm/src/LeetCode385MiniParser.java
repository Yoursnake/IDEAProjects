/*
Given a nested list of integers represented as a string, implement 
a parser to deserialize it.

Each element is either an integer, or a list -- whose elements may 
also be integers or other lists.

Note: You may assume that the string is well-formed:

- String is non-empty.
- String does not contain white spaces.
- String contains only digits 0-9, [, - ,, ].

Example 1:

Given s = "324",

You should return a NestedInteger object which contains a single integer 324.

Example 2:

Given s = "[123,[456,[789]]]",

Return a NestedInteger object containing a nested list with 2 elements:

1. An integer containing value 123.
2. A nested list containing two elements:
    i.  An integer containing value 456.
    ii. A nested list with one element:
         a. An integer containing value 789.
*/

import java.util.*;

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 * // Constructor initializes an empty nested list.
 * public NestedInteger();
 * <p>
 * // Constructor initializes a single integer.
 * public NestedInteger(int value);
 * <p>
 * // @return true if this NestedInteger holds a single integer, rather than a nested list.
 * public boolean isInteger();
 * <p>
 * // @return the single integer that this NestedInteger holds, if it holds a single integer
 * // Return null if this NestedInteger holds a nested list
 * public Integer getInteger();
 * <p>
 * // Set this NestedInteger to hold a single integer.
 * public void setInteger(int value);
 * <p>
 * // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 * public void add(NestedInteger ni);
 * <p>
 * // @return the nested list that this NestedInteger holds, if it holds a nested list
 * // Return null if this NestedInteger holds a single integer
 * public List<NestedInteger> getList();
 * }
 */
public class LeetCode385MiniParser {
	public class NestedInteger {
		private Integer val;
		private List<NestedInteger> list;

		// Constructor initializes an empty nested list.
		public NestedInteger() {
			this.val = null;
			this.list = new ArrayList<>();
		}

		// Constructor initializes a single integer.
		public NestedInteger(int value) {
			this.val = value;
			this.list = null;
		}

		// @return true if this NestedInteger holds a single integer, rather than a nested list.
		public boolean isInteger() {
			return this.val != null;
		}

		// @return the single integer that this NestedInteger holds, if it holds a single integer
		// Return null if this NestedInteger holds a nested list
		public Integer getInteger() {
			if (isInteger()) return val;
			else return null;
		}

		// Set this NestedInteger to hold a single integer.
		public void setInteger(int value) {
			this.val = value;
			this.list = null;
		}

		// Set this NestedInteger to hold a nested list and adds a nested integer to it.
		public void add(NestedInteger ni) {
			this.val = null;
			this.list.add(ni);
		}

		// @return the nested list that this NestedInteger holds, if it holds a nested list
		// Return null if this NestedInteger holds a single integer
		public List<NestedInteger> getList() {
			if (!isInteger()) return list;
			else return null;
		}
	}

	// // DFS recursive: 1ms 100%
	// public NestedInteger deserialize(String s) {
	// 	if (s == null || s.length() == 0) return new NestedInteger();

	// 	if (!s.startsWith("[")) {
	// 		NestedInteger ni = new NestedInteger(Integer.parseInt((s)));
	// 		return ni;
	// 	}

	// 	NestedInteger ni = deserializeDFS(s, 1);	// 第一个字符一定是 '[' 所以从索引 1 开始
	// 	return ni;
	// }

	// private int i;	// 表示指针位置

	// private NestedInteger deserializeDFS(String s, int index) {
	// 	NestedInteger ni = new NestedInteger();
	// 	List<NestedInteger> list = new ArrayList<>();
	// 	int last = 0;
	// 	boolean flag = true; // true 表示正数，false 表示负数
	// 	boolean lastUsed = true;	// 表示数字是否被使用

	// 	a:
	// 	for (i = index; i < s.length(); i++) {
	// 		switch (s.charAt(i)) {
	// 			case '-':
	// 				flag = false;
	// 				break;
	// 			case '[':
	// 				NestedInteger next = deserializeDFS(s, i + 1);
	// 				ni.add(next);
	// 				break;
	// 			case ']':
	// 				if (!lastUsed) {
	// 					ni.add(new NestedInteger(last));
	// 					last = 0;
	// 					flag = true;
	// 					lastUsed = true;
	// 				}
	// 				break a;	// 直接跳出循环，每次递归只遍历到第一个 ]
	// 			case ',':
	// 				if (!lastUsed) {
	// 					ni.add(new NestedInteger(last));
	// 					last = 0;
	// 					flag = true;
	// 					lastUsed = true;
	// 				}
	// 				break;
	// 			default:
	// 				if (flag == true) last = (last * 10) + (s.charAt(i) - '0');
	// 				else last = (last * 10) - (s.charAt(i) - '0');
	// 				lastUsed = false;
	// 		}
	// 	}

	// 	return ni;
	// }

	// DFS Stack iterative: 5ms 69.74%
	public NestedInteger deserialize(String s) {
		if (s == null || s.length() == 0) return new NestedInteger();
		if (!s.startsWith("[")) return new NestedInteger(Integer.parseInt(s));

		NestedInteger curr = null;
		Stack<NestedInteger> stack = new Stack<>();
		String num = null;

		int l = 0;
		for (int r = 0; r < s.length(); r++) {
			char c = s.charAt(r);
			switch (c) {
				case '[':
					if (curr != null) {
						stack.push(curr);
					}
					curr = new NestedInteger();
					l = r + 1;
					break;
				case ']':
					num = s.substring(l, r);
					if (!num.isEmpty()) {
						curr.add(new NestedInteger(Integer.parseInt(num)));
					}
					if (!stack.isEmpty()) {
						NestedInteger pop = stack.pop();
						pop.add(curr);
						curr = pop;
					}
					l = r + 1;
					break;
				case ',':
					if (s.charAt(r - 1) != ']') {
						num = s.substring(l, r);
						curr.add(new NestedInteger(Integer.parseInt(num)));
					}
					l = r + 1;
			}
		}

		return curr;
	}
}
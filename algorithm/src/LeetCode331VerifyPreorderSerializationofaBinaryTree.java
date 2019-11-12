/*
One way to serialize a binary tree is to use pre-order traversal. When we 
encounter a non-null node, we record the node's value. If it is a null node, 
we record using a sentinel value such as #.

     _9_
    /   \
   3     2
  / \   / \
 4   1  #  6
/ \ / \   / \
# # # #   # #
For example, the above binary tree can be serialized to the string 
"9,3,4,#,#,1,#,#,2,#,6,#,#", where # represents a null node.

Given a string of comma separated values, verify whether it is a 
correct preorder traversal serialization of a binary tree. Find an 
algorithm without reconstructing the tree.

Each comma separated value in the string must be either an integer 
or a character '#' representing null pointer.

You may assume that the input format is always valid, for example 
it could never contain two consecutive commas such as "1,,3".

Example 1:

Input: "9,3,4,#,#,1,#,#,2,#,6,#,#"
Output: true

Example 2:

Input: "1,#"
Output: false

Example 3:

Input: "9,#,#,1"
Output: false
*/

import java.util.Stack;

public class LeetCode331VerifyPreorderSerializationofaBinaryTree {
	// // stack: 10ms 16% 看见两个 '#' （叶子节点）就把叶子赋为 '#'，最终如果 stack 中只有一个 '#' 说明合法
	// public boolean isValidSerialization(String preorder) {
	// 	Stack<Character> stack = new Stack<>();

	// 	for (int i = 0; i < preorder.length(); i++) {
	// 		char c = preorder.charAt(i);
	// 		if (c == ',') continue;
	// 		stack.push(c);  // 数字的话只要随便push进一个数字就行了
	// 		while (Character.isDigit(preorder.charAt(i))) i++;

	// 		while (stack.size() >= 3 && stack.peek() == '#'
	// 				&& stack.get(stack.size() - 2) == '#'
	// 				&& stack.get(stack.size() - 3) != '#') {
	// 			stack.pop();
	// 			stack.pop();
	// 			stack.pop();
	// 			stack.push('#');
	// 		}
	// 	}

	// 	return stack.size() == 1 && stack.peek() == '#';
	// }

	// 4ms 93%
	// 利用树的入度等于出度的原理
	// 如果在遍历过程中的某时刻，系统的入度>出度，则说明当前序列中出现过的
	// 所有分支节点的“空闲分支”均已用完，后序节点没有办法挂载到之前出现的节
	// 点之上，从而判定先序遍历的序列是不合法的。
	// 参考：https://www.cnblogs.com/271934Liao/p/7039520.html
	public boolean isValidSerialization(String preorder) {
		int diff = 1;	// 表示 当前出度-当前入度
		String[] split = preorder.split(",");

		for (String s : split) {
			if (--diff < 0) return false;
			if (!s.equals("#")) diff += 2;
		}

		return diff == 0;
	}

}
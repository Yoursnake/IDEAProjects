/*
Example 1:
Input: "()"
Output: true

Example 2:
Input: "()[]{}"
Output: true

Example 3:
Input: "(]"
Output: false

Example 4:
Input: "([)]"
Output: false

Example 5:
Input: "{[]}"
Output: true
 */

import java.util.Stack;

public class LeetCode20ValidParentheses {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '[')
                stack.push(']');
            else if (c == '{')
                stack.push('}');
            else {
                if (stack.pop() != c || stack.empty()) {
                    return false;
                }
            }
        }

        return stack.isEmpty(); // 如果是空则为合理
    }

//    public boolean isValid(String s) {
//        if (s.length() == 0) return true;
//        if (s.length() == 1) return false;
//
//        char[] chars = s.toCharArray();
//        Stack<Character> stack = new Stack<>();
//        Set<Character> left = new HashSet<>();
//        Set<Character> right = new HashSet<>();
//        left.add('(');
//        left.add('[');
//        left.add('{');
//        right.add(')');
//        right.add('}');
//        right.add(']');
//
//        for (char c : chars) {
//            if (left.contains(c)) {
//                stack.push(c);     // 如果是左括号，就入栈
//            } else if (right.contains(c)) {
//                if (stack.empty()) {
//                    return false;   // 是右括号是空栈表示有错
//                } else {
//                    char pop = stack.pop();
//                    switch (pop) {
//                        case '(':
//                            if (c != ')') return false;
//                            break;
//                        case '[':
//                            if (c != ']') return false;
//                            break;
//                        case '{':
//                            if (c != '}') return false;
//                            break;
//                    }
//                }
//            }
//        }
//
//        if (!stack.empty()) return false;   // 如果最后栈还没有空就是错
//
//        return true;
//    }
}

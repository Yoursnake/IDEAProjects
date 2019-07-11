/*
Example 1:

Input: "/home/"
Output: "/home"
Explanation: Note that there is no trailing slash after the last directory name.

Example 2:

Input: "/../"
Output: "/"
Explanation: Going one level up from the root directory is a no-op, as the root level is the highest level you can go.

Example 3:

Input: "/home//foo/"
Output: "/home/foo"
Explanation: In the canonical path, multiple consecutive slashes are replaced by a single one.

Example 4:

Input: "/a/./b/../../c/"
Output: "/c"

Example 5:

Input: "/a/../../b/../c//.//"
Output: "/c"

Example 6:

Input: "/a//b////c/d//././/.."
Output: "/a/b/c"
 */

import java.util.Stack;

public class LeetCode071SimplifyPath {
    public String simplifyPath(String path) {
        String[] ss = path.split("/");
        Stack<String> stack = new Stack<>();
        String result = "";

        for (String s : ss) {
            if (s.equals("")) continue;
            if (s.equals(".")) continue;
            if (s.equals("..")) {
                if (stack.isEmpty()) {
                    continue;
                } else {
                    stack.pop();
                    continue;
                }
            }

            stack.push(s);
        }

        while (!stack.isEmpty()) {
            result = "/" + stack.pop() + result;
        }

        if (result.equals("")) result = "/";

        return result;
    }
}

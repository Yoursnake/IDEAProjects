/*
Suppose we abstract our file system by a string in the following manner:

The string "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext" represents:

dir
    subdir1
    subdir2
        file.ext
The directory dir contains an empty sub-directory subdir1 and a 
sub-directory subdir2 containing a file file.ext.

The string "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext" represents:

dir
    subdir1
        file1.ext
        subsubdir1
    subdir2
        subsubdir2
            file2.ext
The directory dir contains two sub-directories subdir1 and subdir2. subdir1 
contains a file file1.ext and an empty second-level sub-directory subsubdir1. 
subdir2 contains a second-level sub-directory subsubdir2 containing a file file2.ext.

We are interested in finding the longest (number of characters) absolute path 
to a file within our file system. For example, in the second example above, 
the longest absolute path is "dir/subdir2/subsubdir2/file2.ext", and its 
length is 32 (not including the double quotes).

Given a string representing the file system in the above format, return the length 
of the longest absolute path to file in the abstracted file system. If there is no 
file in the system, return 0.

Note:
The name of a file contains at least a . and an extension.
The name of a directory or sub-directory will not contain a ..
Time complexity required: O(n) where n is the size of the input string.

Notice that a/aa/aaa/file1.txt is not the longest file path, if there is another 
path aaaaaaaaaaaaaaaaaaaaa/sth.png.
*/

import java.util.Stack;

public class LeetCode388LongestAbsoluteFilePath {
	private class Sequence {
		private String s;
		private int len;

		public Sequence(String s, int len) {
			this.s = s;
			this.len = len;
		}
	}

	// DFS Stack: O(n) 1ms 97%
	public int lengthLongestPath(String input) {
		Stack<Sequence> stack = new Stack<>();
		int maxLength = 0;
		input += "\n";

		int l = 0;
		for (int r = 0; r < input.length(); r++) {
			char c = input.charAt(r);
			if (c == '\n') {
				String s = input.substring(l, r);
				int tableNum = countTable(s);
				while (tableNum != stack.size()) stack.pop();

				int currLen = 0;
				if (stack.isEmpty()) {
					currLen = s.length() - tableNum;
				} else {
					currLen = stack.peek().len + 1 + s.length() - tableNum;
				}

				stack.push(new Sequence(s, currLen));
				if (s.contains(".")) maxLength = Math.max(maxLength, currLen);

				l = r + 1;
			}
		}

		return maxLength;
	}

	// 计算 s 开头有多少个 '\t'
	private int countTable(String s) {
		int cnt = 0;

		for (char c : s.toCharArray()) {
			if (c == '\t') cnt++;
			else break;
		}

		return cnt;
	}
}
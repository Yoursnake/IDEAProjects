/*
Given a string, find the first non-repeating character in it 
and return it's index. If it doesn't exist, return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode",
return 2.

Note: You may assume the string contain only lowercase letters.
*/

import java.util.*;

public class LeetCode387FirstUniqueCharacterinaString {
	// // O(n) 7ms 90%  two-pass
	// public int firstUniqChar(String s) {
	// 	// 用 map 表示 26 个字母在 s 中的索引，如果没有则为 -1，如果重复则为 -2
 //        int[] map = new int[26];
 //        Arrays.fill(map, -1);
        
 //        for (int i = 0; i < s.length(); i++) {
 //            char c = s.charAt(i);
 //           	// -1 表示未赋值，可以进行赋值，否则表示已经赋值过了，重复赋值，将 map 改为 -2
 //            if (map[c - 'a'] == -1) map[c - 'a'] = i;
 //            else map[c - 'a'] = -2;
 //        }
        
 //        int min = Integer.MAX_VALUE;
 //        // 找其中不是重复的且出现过的最小值
 //        for (int i : map) {
 //            if (i < min && i != -2 && i != -1) min = i;
 //        }
        
 //        return (min == Integer.MAX_VALUE) ? -1 : min;
 //    }

	// HashSet + LinkedHashMap: 28ms 59.35%		one-pass
	public int firstUniqChar(String s) {
		Map<Integer, Integer> map = new LinkedHashMap<>();
		Set<Integer> set = new HashSet<>();

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (set.contains(c)) {
				// set.remove(c);	// 这边不能把 set 删除，因为可能之后会出现第三个 c
				if (map.containsKey(c)) map.remove(c);
			} else {
				set.add(c);
				map.put(c, i);
			}
		}

		return map.size() == 0 ? -1 : map.iterator().next().getValue();
	}
}
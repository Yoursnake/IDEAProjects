/*
Example:

Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
Output:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class LeetCode49GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        List<List<String>> result = new ArrayList<>();

        for (String str : strs) {
            char[] str2char = str.toCharArray();
            Arrays.sort(str2char);      // 对字符数组也能排序
            String temp = new String(str2char);

            if (map.containsKey(temp)) {
                map.get(temp).add(str);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(temp, list);
            }
        }

        for (List<String> list : map.values()) {
            result.add(list);
        }

        return result;
    }
}

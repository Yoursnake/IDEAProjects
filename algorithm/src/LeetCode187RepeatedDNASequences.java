/*
All DNA is composed of a series of nucleotides abbreviated as A, C,
G, and T, for example: "ACGAATTCCG". When studying DNA, it is
sometimes useful to identify repeated sequences within the DNA.

Write a function to find all the 10-letter-long sequences
(substrings) that occur more than once in a DNA molecule.

Example:

Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"

Output: ["AAAAACCCCC", "CCCCCAAAAA"]
 */

import java.util.*;

public class LeetCode187RepeatedDNASequences {
//    // 使用 Set : 59.08% - 71.43%
//    public List<String> findRepeatedDnaSequences(String s) {
//        Set<String> visited = new HashSet<>();
//        Set<String> result = new HashSet<>();
//
//        for (int i = 0; i < s.length() - 9; i++) {
//            String curr = s.substring(i, i + 10);
//            if (!visited.contains(curr)) visited.add(curr);
//            else result.add(curr);
//        }
//
//        return new ArrayList<>(result);
//    }

    // 将字符串编码后存储为整数，减少内存 18.44% - 88.78%
    public List<String> findRepeatedDnaSequences(String s) {
        Set<Integer> visited = new HashSet<>();
        Set<String> result = new HashSet<>();
        HashMap<Character, Integer> map = new HashMap<>();

        map.put('A', 0);    // 00
        map.put('C', 1);    // 01
        map.put('G', 2);    // 10
        map.put('T', 3);    // 11

        for (int i = 0; i < s.length() - 9; i++) {
            int curr = 0;
            for (int j = i; j < i + 10; j++) {
                curr <<= 2;
                curr |= map.get(s.charAt(j));
            }

            if (!visited.contains(curr)) visited.add(curr);
            else result.add(s.substring(i, i + 10));
        }

        return new ArrayList<>(result);
    }
}

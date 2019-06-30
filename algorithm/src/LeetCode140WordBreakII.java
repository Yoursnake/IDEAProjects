/*
Given a non-empty string s and a dictionary wordDict containing a list of
non-empty words, add spaces in s to construct a sentence where each word is
a valid dictionary word. Return all such possible sentences.

Note:

The same word in the dictionary may be reused multiple times in the
segmentation.
You may assume the dictionary does not contain duplicate words.

Example 1:

Input:
s = "catsanddog"
wordDict = ["cat", "cats", "and", "sand", "dog"]

Output:
[
  "cats and dog",
  "cat sand dog"
]

Example 2:

Input:
s = "pineapplepenapple"
wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]

Output:
[
  "pine apple pen apple",
  "pineapple pen apple",
  "pine applepen apple"
]
Explanation: Note that you are allowed to reuse a dictionary word.

Example 3:

Input:
s = "catsandog"
wordDict = ["cats", "dog", "sand", "and", "cat"]

Output:
[]
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LeetCode140WordBreakII {
    // DP + DFS 7.03%
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> result = new ArrayList<>();
        String curr = "";
        // 第 i 个表示前 i 个能到达的上一个索引 list，如果不能达到则为空
        // 注：每个 list 存储的是索引
        List<List<Integer>> trackList = new ArrayList<>();

        // 第 0 个表示前 0 个字符串初始化为 -1 表明可以达到
        trackList.add(new ArrayList<>(Collections.singletonList(-1)));

        for (int i = 1; i <= s.length(); i++) {
            List<Integer> track = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                // 如果前 j 个字符串可以达到，且字典包含索引 j~i-1 的字符串，
                // 则说明前 i 个也可以达到
                if (trackList.get(j).size() > 0 && wordDict.contains(s.substring(j, i))) {
                    track.add(j);
                }
            }
            trackList.add(track);
        }

        DFS(trackList, result, s, s.length(), curr);
        return result;
    }

    private void DFS(List<List<Integer>> trackList, List<String> result, String s, int index, String curr) {
        // index 表示现在指向的 trackList 的位置
        if (index == 0) {
            result.add(curr);
            return;
        }

        if (!curr.equals("")) curr = " " + curr;

        // 到达 index 的前面的索引
        List<Integer> beforeTracks = trackList.get(index);

        for (int beforeTrack : beforeTracks) {
            String temp = curr;
            temp = s.substring(beforeTrack, index) + curr;
            DFS(trackList, result, s, beforeTrack, temp);
        }
    }
}

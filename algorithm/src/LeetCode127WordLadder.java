/*
Given two words (beginWord and endWord), and a dictionary's word list,
find the length of shortest transformation sequence from beginWord to
endWord, such that:

Only one letter can be changed at a time.
Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
Note:

Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
You may assume no duplicates in the word list.
You may assume beginWord and endWord are non-empty and are not the same.

Example 1:

Input:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]

Output: 5

Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.

Example 2:

Input:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]

Output: 0

Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
 */

import java.util.*;

public class LeetCode127WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> queue = new LinkedList<>();
        Set<String> unvisited = new HashSet<>(wordList);    // 表示未访问的元素
        queue.offer(beginWord);
        int result = 0;     // 表示当前的层数

        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            result++;

            for (int i = 0; i < queueSize; i++) {
                String curr = queue.poll();
                List<String> deleteList = new ArrayList<>();    // 需要删除的元素队列

                if (curr.equals(endWord)) return result;

                for (String word : unvisited) {
//                    if (wordDiffNum(curr, word) == 1) {
                    if (isDiffOne(curr, word)) {
                        queue.offer(word);
                        deleteList.add(word);
                    }
                }

                // 不在上一个循环中删除是因为循环 List 过程中不能改变 List
                for (String word : deleteList) {
                    unvisited.remove(word);
                }
            }
        }
        return 0;
    }

    // 判断两个 String 是否只相差一个字符
    private boolean isDiffOne(String word1, String word2) {
        int diffNum = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) diffNum++;
            if (diffNum > 1) return false;
        }

        if (diffNum == 1) return true;
        else return false;
    }
}

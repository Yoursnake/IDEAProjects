/*
Given a 2D board and a list of words from the dictionary, find all words
in the board.

Each word must be constructed from letters of sequentially adjacent cell,
where "adjacent" cells are those horizontally or vertically neighboring.
The same letter cell may not be used more than once in a word.

Example:

Input:
board = [
  ['o','a','a','n'],
  ['e','t','a','e'],
  ['i','h','k','r'],
  ['i','f','l','v']
]
words = ["oath","pea","eat","rain"]

Output: ["eat","oath"]
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LeetCode212WordSearchII {
    class TrieNode {
        boolean isWord;
        TrieNode[] children;

        TrieNode() {
            this.isWord = false;
            this.children = new TrieNode[26];
        }
    }

    class Trie {
        private TrieNode root;

        Trie() {
            this.root = new TrieNode();
        }

        void addWord(String word) {
            TrieNode currNode = this.root;
            char[] chars = word.toCharArray();

            for (char c : chars) {
                if (currNode.children[c - 'a'] == null) {
                    TrieNode newNode = new TrieNode();
                    currNode.children[c - 'a'] = newNode;
                    currNode = newNode;
                } else {
                    currNode = currNode.children[c - 'a'];
                }
            }

            currNode.isWord = true;
        }
    }

    // Trie + DFS: 58.24%
    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        Set<String> result = new HashSet<>();
        boolean[][] visited = new boolean[board.length][board[0].length];

        for (String word : words) {
            trie.addWord(word);
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                DFS(trie.root, board, i, j, visited, result, new StringBuilder());
            }
        }

        return new ArrayList<>(result);
    }

    private void DFS(TrieNode currNode, char[][] board, int x, int y, boolean[][] visited, Set<String> result, StringBuilder currWord) {
        if (currNode.isWord) result.add(currWord.toString());
        if (x < 0 || y < 0 || x >= board.length || y >= board[0].length) return;
        if (visited[x][y]) return;

        visited[x][y] = true;
        char c = board[x][y];

        if (currNode.children[c - 'a'] != null) {
            currWord.append(c);
            currNode = currNode.children[c - 'a'];
            DFS(currNode, board, x - 1, y, visited, result, currWord);
            DFS(currNode, board, x + 1, y, visited, result, currWord);
            DFS(currNode, board, x, y - 1, visited, result, currWord);
            DFS(currNode, board, x, y + 1, visited, result, currWord);
            currWord.deleteCharAt(currWord.length() - 1);
        }

        visited[x][y] = false;
    }
}

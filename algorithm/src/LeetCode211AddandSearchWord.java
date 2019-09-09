/*
Design a data structure that supports the following two operations:

void addWord(word)
bool search(word)
search(word) can search a literal word or a regular expression string
containing only letters a-z or .. A . means it can represent any one letter.

Example:

addWord("bad")
addWord("dad")
addWord("mad")
search("pad") -> false
search("bad") -> true
search(".ad") -> true
search("b..") -> true

Note:
You may assume that all words are consist of lowercase letters a-z.
 */

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */

// array: 26.82%
public class LeetCode211AddandSearchWord {
    class TreeNode {
        boolean isWord;
        TreeNode[] children;

        public TreeNode() {
            this.isWord = false;
            this.children = new TreeNode[26];
        }
    }

    private TreeNode root;

    /** Initialize your data structure here. */
    public LeetCode211AddandSearchWord() {
        this.root = new TreeNode();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        char[] chars = word.toCharArray();
        TreeNode currNode = this.root;

        for (char c : chars) {
            if (currNode.children[c - 'a'] == null) {
                TreeNode newNode = new TreeNode();
                currNode.children[c - 'a'] = newNode;
                currNode = newNode;
            } else {
                currNode = currNode.children[c - 'a'];
            }
        }

        currNode.isWord = true;
    }

//    // BFS: 26.82%
//    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
//    public boolean search(String word) {
//        char[] chars = word.toCharArray();
//        TreeNode currNode = this.root;
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.offer(currNode);
//
//        for (char c : chars) {
//            int queueLen = queue.size();
//
//            if (c != '.') {
//                for (int i = 0; i < queueLen; i++) {
//                    currNode = queue.poll();
//                    if (currNode.children[c - 'a'] != null) queue.offer(currNode.children[c - 'a']);
//                }
//            } else {
//                for (int i = 0; i < queueLen; i++) {
//                    currNode = queue.poll();
//                    for (int j = 0; j < 26; j++) {
//                        if (currNode.children[j] != null) queue.offer(currNode.children[j]);
//                    }
//                }
//            }
//        }
//
//        while (!queue.isEmpty()) {
//            currNode = queue.poll();
//            if (currNode.isWord) return true;
//        }
//
//        return false;
//    }

    // DFS: 72.60%
    public boolean search(String word) {
        return this.search(this.root, 0, word);
    }

    private boolean search(TreeNode node, int index, String word) {
        if (index == word.length()) return node.isWord;

        char c = word.charAt(index);
        if (c != '.') {
            TreeNode nextNode = node.children[c - 'a'];
            if (nextNode != null) return search(nextNode, index + 1, word);
            else return false;
        } else {
            boolean result = false;
            for (int i = 0; i < 26; i++) {
                TreeNode nextNode = node.children[i];
                if (nextNode != null) result |= search(nextNode, index + 1, word);
            }
            return result;
        }
    }
}

//// hashmap: 5.23%
//public class LeetCode211AddandSearchWord {
//    class TreeNode {
//        boolean isWord;
//        HashMap<Character, TreeNode> children;
//
//        public TreeNode() {
//            this.isWord = false;
//            this.children = new HashMap<>();
//        }
//    }
//
//    private TreeNode root;
//
//    /** Initialize your data structure here. */
//    public LeetCode211AddandSearchWord() {
//        this.root = new TreeNode();
//    }
//
//    /** Adds a word into the data structure. */
//    public void addWord(String word) {
//        char[] chars = word.toCharArray();
//        TreeNode currNode = this.root;
//
//        for (char c : chars) {
//            if (!currNode.children.containsKey(c)) {
//                TreeNode newNode = new TreeNode();
//                currNode.children.put(c, newNode);
//                currNode = newNode;
//            } else {
//                currNode = currNode.children.get(c);
//            }
//        }
//
//        currNode.isWord = true;
//    }
//
//    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
//    public boolean search(String word) {
//        char[] chars = word.toCharArray();
//        TreeNode currNode = this.root;
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.offer(currNode);
//
//        for (char c : chars) {
//            int queueLen = queue.size();
//
//            if (c != '.') {
//                for (int i = 0; i < queueLen; i++) {
//                    currNode = queue.poll();
//                    if (currNode.children.containsKey(c)) queue.offer(currNode.children.get(c));
//                }
//            } else {
//                for (int i = 0; i < queueLen; i++) {
//                    currNode = queue.poll();
//                    for (char key : currNode.children.keySet()) {
//                        queue.offer(currNode.children.get(key));
//                    }
//                }
//            }
//        }
//
//        while (!queue.isEmpty()) {
//            currNode = queue.poll();
//            if (currNode.isWord) return true;
//        }
//
//        return false;
//    }
//}
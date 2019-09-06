/*
Implement a trie with insert, search, and startsWith methods.

Example:

Trie trie = new Trie();

trie.insert("apple");
trie.search("apple");   // returns true
trie.search("app");     // returns false
trie.startsWith("app"); // returns true
trie.insert("app");
trie.search("app");     // returns true
Note:

You may assume that all inputs are consist of lowercase letters a-z.
All inputs are guaranteed to be non-empty strings.
 */

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */

//// my solution use list + set: 6%
//public class LeetCode208ImplementTrie {
//    class TreeNode {
//        char val;
//        boolean isWord;
//        List<TreeNode> children;
//        Set<Character> set;     // 已经存储的叶子的字符集合
//
//        public TreeNode(char c) {
//            this.val = c;
//            this.isWord = false;
//            this.children = new ArrayList<>();
//            this.set = new HashSet<>();
//        }
//    }
//
//    private TreeNode root;
//
//    /** Initialize your data structure here. */
//    public LeetCode208ImplementTrie() {
//        this.root = new TreeNode(' ');
//    }
//
//    /** Inserts a word into the trie. */
//    public void insert(String word) {
//        char[] chars = word.toCharArray();
//        TreeNode currNode = this.root;
//
//        for (char c : chars) {
//            if (!currNode.set.contains(c)) {
//                TreeNode newNode = new TreeNode(c);
//                currNode.children.add(newNode);
//                currNode.set.add(c);
//                currNode = newNode;
//            } else {
//                for (TreeNode child : currNode.children) {
//                    if (child.val == c) {
//                        currNode = child;
//                        break;
//                    }
//                }
//            }
//        }
//
//        currNode.isWord = true;
//    }
//
//    /** Returns if the word is in the trie. */
//    public boolean search(String word) {
//        char[] chars = word.toCharArray();
//        TreeNode currNode = this.root;
//
//        for (char c : chars) {
//            if (currNode.set.contains(c)) {
//                for (TreeNode child : currNode.children) {
//                    if (child.val == c) {
//                        currNode = child;
//                        break;
//                    }
//                }
//            } else {
//                return false;
//            }
//        }
//
//        return currNode.isWord;
//    }
//
//    /** Returns if there is any word in the trie that starts with the given prefix. */
//    public boolean startsWith(String prefix) {
//        char[] chars = prefix.toCharArray();
//        TreeNode currNode = this.root;
//
//        for (char c : chars) {
//            if (currNode.set.contains(c)) {
//                for (TreeNode child : currNode.children) {
//                    if (child.val == c) {
//                        currNode = child;
//                        break;
//                    }
//                }
//            } else {
//                return false;
//            }
//        }
//
//        return true;
//    }
//}

//// use hashmap: 26.92%
//public class LeetCode208ImplementTrie {
//    class TreeNode {
//        boolean isWord;
//        Map<Character, TreeNode> map;
//
//        public TreeNode() {
//            this.isWord = false;
//            this.map = new HashMap<>();
//        }
//    }
//
//    private TreeNode root;
//
//    /** Initialize your data structure here. */
//    public LeetCode208ImplementTrie() {
//        this.root = new TreeNode();
//    }
//
//    /** Inserts a word into the trie. */
//    public void insert(String word) {
//        char[] chars = word.toCharArray();
//        TreeNode currNode = this.root;
//
//        for (char c : chars) {
//            if (!currNode.map.containsKey(c)) {
//                TreeNode newNode = new TreeNode();
//                currNode.map.put(c, newNode);
//                currNode = newNode;
//            } else {
//                currNode = currNode.map.get(c);
//            }
//        }
//
//        currNode.isWord = true;
//    }
//
//    /** Returns if the word is in the trie. */
//    public boolean search(String word) {
//        char[] chars = word.toCharArray();
//        TreeNode currNode = this.root;
//
//        for (char c : chars) {
//            if (!currNode.map.containsKey(c)) return false;
//            else currNode = currNode.map.get(c);
//        }
//
//        return currNode.isWord;
//    }
//
//    /** Returns if there is any word in the trie that starts with the given prefix. */
//    public boolean startsWith(String prefix) {
//        char[] chars = prefix.toCharArray();
//        TreeNode currNode = this.root;
//
//        for (char c : chars) {
//            if (!currNode.map.containsKey(c)) return false;
//            else currNode = currNode.map.get(c);
//        }
//
//        return true;
//    }
//}


// use array: 86.90%
public class LeetCode208ImplementTrie {
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
    public LeetCode208ImplementTrie() {
        this.root = new TreeNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
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

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        char[] chars = word.toCharArray();
        TreeNode currNode = this.root;

        for (char c : chars) {
            if (currNode.children[c - 'a'] == null) return false;
            else currNode = currNode.children[c - 'a'];
        }

        return currNode.isWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        char[] chars = prefix.toCharArray();
        TreeNode currNode = this.root;

        for (char c : chars) {
            if (currNode.children[c - 'a'] == null) return false;
            else currNode = currNode.children[c - 'a'];
        }

        return true;
    }
}
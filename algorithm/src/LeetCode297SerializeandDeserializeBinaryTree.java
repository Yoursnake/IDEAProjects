/*
Serialization is the process of converting a data structure or object 
into a sequence of bits so that it can be stored in a file or memory 
buffer, or transmitted across a network connection link to be reconstructed 
later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary tree. There 
is no restriction on how your serialization/deserialization algorithm 
should work. You just need to ensure that a binary tree can be serialized 
to a string and this string can be deserialized to the original tree structure.

Example: 

You may serialize the following tree:

    1
   / \
  2   3
     / \
    4   5

as "[1,2,3,null,null,4,5]"

Clarification: The above format is the same as how LeetCode serializes a 
binary tree. You do not necessarily need to follow this format, so please 
be creative and come up with different approaches yourself.

Note: Do not use class member/global/static variables to store states. 
Your serialize and deserialize algorithms should be stateless.
*/

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));

import java.util.*;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// // BFS: 53.92% 13ms
// public class LeetCode297SerializeandDeserializeBinaryTree {
//	public class TreeNode {
//		int val;
//		TreeNode left;
//		TreeNode right;
//		TreeNode(int x) { val = x; }
//	}
//     // Encodes a tree to a single string.
//     public String serialize(TreeNode root) {
//     	if (root == null) return "";

//         Queue<TreeNode> queue = new LinkedList<>();
//         StringBuilder res = new StringBuilder();

//         queue.offer(root);

//         while (!queue.isEmpty()) {
//         	int size = queue.size();

//         	for (int i = 0; i < size; i++) {
//         		TreeNode top = queue.poll();

//         		if (top == null) {
//         			res.append("#,");
//         		} else {
//         			res.append((top.val + ","));
//         			queue.offer(top.left);
//         			queue.offer(top.right);
//         		}
//         	}
//         }

//         res.deleteCharAt(res.length() - 1);
//         return res.toString();
//     }

//     // Decodes your encoded data to tree.
//     public TreeNode deserialize(String data) {
//     	if (data.equals("")) return null;

//         String[] nodes = data.split(",");
//         Queue<TreeNode> queue = new LinkedList<>();
//         TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
//         int point = 1;

//         queue.offer(root);
        
//         while (point < nodes.length) {
// 			int size = queue.size();

//         	for (int i = 0; i < size; i++) {
// 	        	TreeNode top = queue.poll();

// 	        	if (top != null) {
// 	        		top.left = generateNode(nodes[point++]);
// 	        		top.right = generateNode(nodes[point++]);
// 	        		queue.offer(top.left);
// 		        	queue.offer(top.right);
// 	        	}
// 	        }
//         }

//         return root;
//     }

//     private TreeNode generateNode(String s) {
//     	if (s.equals("#")) return null;
//     	else return new TreeNode(Integer.parseInt(s));
//     }
// }

// DFS: 53.92% 13ms
public class LeetCode297SerializeandDeserializeBinaryTree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
    	StringBuilder sb = new StringBuilder();

    	if (root == null) {
    		return "#,";
    	} else {
		    sb.append(root.val + ",");
		    sb.append(serialize(root.left));
		    sb.append(serialize(root.right));
	    }

    	return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
    	String[] nodes = data.substring(0, data.length() - 1).split(",");
        Deque<String> deque = new LinkedList<>(Arrays.asList(nodes));

        return buildTree(deque);
    }

    private TreeNode buildTree(Deque<String> deque) {
        if (deque.peekFirst().equals("#")) {
            deque.removeFirst();
            return null;
        }

        TreeNode root = generateNode(deque.pollFirst());
        root.left = buildTree(deque);
        root.right = buildTree(deque);

        return root;
    }

    private TreeNode generateNode(String s) {
    	if (s.equals("#")) return null;
    	else return new TreeNode(Integer.parseInt(s));
    }
}
/*
inorder = [9,3,15,20,7]
postorder = [9,15,7,20,3]
Return the following binary tree:

    3
   / \
  9  20
    /  \
   15   7

 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class LeetCode106ConstructBinaryTreefromInorderPostorderTraversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0 || postorder.length == 0) return null;
        return buildTree2(inorder, 0, inorder.length - 1, postorder, postorder.length - 1);
    }

    // 算法思想和 105 基本一致
    private TreeNode buildTree2(int[] inorder, int inStart, int inEnd, int[] postorder, int rootPostIndex) {
        if (inStart == inEnd) return new TreeNode(inorder[inStart]);

        int rootValue = postorder[rootPostIndex];
        TreeNode root = new TreeNode(rootValue);

        int rootInIndex;
        for (rootInIndex = inStart; rootInIndex <= inEnd; rootInIndex++) {
            if (inorder[rootInIndex] == rootValue) break;
        }

        if (rootInIndex < inEnd) {
            root.right = buildTree2(inorder, rootInIndex + 1, inEnd, postorder, rootPostIndex - 1);
        }

        int rightNodeNum = inEnd - rootInIndex;
        if (rootInIndex > inStart) {
            root.left = buildTree2(inorder, inStart, rootInIndex - 1, postorder, rootPostIndex - rightNodeNum - 1);
        }

        return root;
    }
}

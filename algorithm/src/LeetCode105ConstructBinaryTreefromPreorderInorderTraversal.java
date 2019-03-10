/*
For example, given

preorder = [3,9,20,15,7]
inorder = [9,3,15,20,7]
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
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class LeetCode105ConstructBinaryTreefromPreorderInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) return null;
        return buildTree2(preorder, 0, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTree2(int[] preorder, int rootPreIndex, int[] inorder, int inStart, int inEnd) {
        if (inStart == inEnd) return new TreeNode(inorder[inStart]);

        // 确定根节点的值 rootValue
        int rootValue = preorder[rootPreIndex];
        TreeNode root = new TreeNode(rootValue);

        // 找 rootValue 在 inorder 中对应索引
        // inStart ~ rootInIndex - 1 的值是左子树
        // rootInIndex + 1 ~ inEnd 是右子树
        int rootInIndex;
        for (rootInIndex = inStart; rootInIndex < inEnd; rootInIndex++) {
            if (inorder[rootInIndex] == rootValue) break;
        }

        // 找到左子树开始的第一个数
        if (rootInIndex > inStart) {
            int leftPreIndex = rootPreIndex + 1;
            root.left = buildTree2(preorder, leftPreIndex, inorder, inStart, rootInIndex - 1);
        }

        // 找到右子树开始的第一个数
        int leftNodeNum = rootInIndex - inStart;
        if (rootInIndex < inEnd) {
            int rightPreIndex = rootPreIndex + leftNodeNum + 1;
            root.right = buildTree2(preorder, rightPreIndex, inorder, rootInIndex + 1, inEnd);
        }

        return root;
    }
}

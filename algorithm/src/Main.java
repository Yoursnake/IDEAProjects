/**
 * Created by shengliyi on 2017/3/4.
 */

public class Main {
//-2147483648
    public static void main(String[] args) {
        Utils utils = new Utils();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
//
//        List<List<Integer>> result = new LeetCode103BinaryTreeZigzagLevelOrderTraversal().zigzagLevelOrder(root);

        int result = new LeetCode111MinimumDepthofBinaryTree().minDepth(root);
        System.out.println(result);

//        int[] a = null;
//        System.out.println(a.length);

    }

}

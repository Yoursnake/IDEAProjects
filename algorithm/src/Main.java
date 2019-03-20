/**
 * Created by shengliyi on 2017/3/4.
 */

public class Main {
//-2147483648
    public static void main(String[] args) {
        Utils utils = new Utils();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);
//
//        List<List<Integer>> result = new LeetCode103BinaryTreeZigzagLevelOrderTraversal().zigzagLevelOrder(root);

        new LeetCode114FlattenBinaryTreetoLinkedList().flatten(root);



//        int[] a = null;
//        System.out.println(a.length);

    }

}

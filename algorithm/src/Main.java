/**
 * Created by shengliyi on 2017/3/4.
 */


public class Main {
//-2147483648
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(6);

        boolean result = new LeetCode98ValidateBinarySearchTree().isValidBST(root);
        System.out.println(result);


    }

}

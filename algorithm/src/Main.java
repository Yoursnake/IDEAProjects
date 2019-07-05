import java.util.List;

/**
 * Created by shengliyi on 2017/3/4.
 */

public class Main {
    public static void main(String[] args) {
        LeetCode144BinaryTreePreorderTraversal.TreeNode root = new LeetCode144BinaryTreePreorderTraversal.TreeNode(1);
        root.right = new LeetCode144BinaryTreePreorderTraversal.TreeNode(2);
        root.right.left = new LeetCode144BinaryTreePreorderTraversal.TreeNode(3);

        List<Integer> result = new LeetCode144BinaryTreePreorderTraversal().preorderTraversal(root);
        System.out.println(result);
    }
}

/**
 * Created by shengliyi on 2017/3/4.
 */

public class Main {
    public static void main(String[] args) {
//        TreeNode root = new TreeNode(4);
//        root.left = new TreeNode(9);
//        root.left.left = new TreeNode(5);
//        root.left.right = new TreeNode(1);
//        root.right = new TreeNode(0);
//
//        int result = new LeetCode129SumRoot2LeafNumbers().sumNumbers(root);
//        System.out.println(result);
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};
        int result = new LeetCode134GasStation().canCompleteCircuit(gas, cost);
        System.out.println(result);
    }
}

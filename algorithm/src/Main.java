import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

//        String s = "aaaaaaa";
//        List<String> wordDict = new ArrayList<>();
//        wordDict.add("aaaa");
//        wordDict.add("aa");
////        wordDict.add("sand");
////        wordDict.add("and");
////        wordDict.add("cat");
//
//        boolean result = new LeetCode139WordBreak().wordBreak(s, wordDict);
//        System.out.println(result);

        String s = "catsanddog";
        List<String> wordDict = new ArrayList<>(Arrays.asList("cat", "cats", "and", "sand", "dog"));
        List<String> result = new LeetCode140WordBreakII().wordBreak(s, wordDict);

        System.out.println(result);
    }
}

/**
 * Created by shengliyi on 2017/3/4.
 */

public class Main {
//-2147483648
    public static void main(String[] args) {
        String s = "aaa";
        String p = "ab*ac*a";

        boolean result = new LeetCode10RegularExpressionMatching().isMatch(s, p);
        System.out.println(result);

//        String[] a = p.split("\\*");
//        for (String s1 : a) {
//            System.out.println(s1);
//        }

    }

}

/**
 * Created by shengliyi on 2017/3/4.
 */

public class Main {
//-2147483648
    public static void main(String[] args) {
        Utils utils = new Utils();

        String s = "aa";
        String p = "a*b*c*d";

//        boolean result = new LeetCode10RegularExpressionMatching().isMatch(s, p);
//        System.out.println(result);

        String[] a = p.split("\\*");
        utils.printArray(a);
    }

}

/**
 * Created by shengliyi on 2017/3/4.
 */


public class Main {
//-2147483648
    public static void main(String[] args) {
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbcbcac";

        boolean result = new LeetCode97InterleavingString().isInterleave(s1, s2, s3);
        System.out.println(result);


    }

}

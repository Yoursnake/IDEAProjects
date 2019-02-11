/**
 * Created by shengliyi on 2017/3/4.
 */

public class Main {
//-2147483648
    public static void main(String[] args) {
//        boolean[][] isUsed = new boolean[2][3];

        String a = "100";
        String b = "110010";

        String result = new LeetCode67AddBinary().addBinary(a, b);
        System.out.println(result);
    }

}

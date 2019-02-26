/**
 * Created by shengliyi on 2017/3/4.
 */

public class Main {
//-2147483648
    public static void main(String[] args) {
        Utils utils = new Utils();

        int[] height = {4,2,3};

        int result = new LeetCode42TrappingRainWater().trap(height);
        System.out.println(result);

    }

}

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shengliyi on 2017/3/4.
 */
public class Main {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> listList = ThreeSum.threeSum(nums);
        System.out.println(listList);
    }
}

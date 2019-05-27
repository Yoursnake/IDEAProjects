import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by shengliyi on 2017/3/4.
 */

public class Main {
//-2147483648
    public static void main(String[] args) {

        List<List<Integer>> triangle = new ArrayList<List<Integer>>() {{
            add(new ArrayList<>(Arrays.asList(2)));
            add(new ArrayList<>(Arrays.asList(3, 4)));
            add(new ArrayList<>(Arrays.asList(6, 5, 7)));
            add(new ArrayList<>(Arrays.asList(4, 1, 8, 3)));
        }};

        int result = new LeetCode120Triangle().minimumTotal(triangle);
        System.out.println(result);
    }

}

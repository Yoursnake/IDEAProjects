import java.util.ArrayList;
import java.util.List;

/**
 * Created by shengliyi on 2017/3/4.
 */

public class Main {
//-2147483648
    public static void main(String[] args) {

        List<String> wordList = new ArrayList<String>() {{
            add("hot");
            add("dot");
            add("dog");
            add("lot");
            add("log");
            add("cog");
        }};

//        List<String> wordList = new ArrayList<String>() {{
//            add("hot");
//            add("dot");
//            add("dog");
//            add("lot");
//            add("log");
//        }};

//        int result = new LeetCode120Triangle().minimumTotal(triangle);

//        int[] a = {3,3,5,0,0,3,1,4};
//        int[] b = {1,2,3,4,5};
//        String s = "0P";
        int result = new LeetCode127WordLadder().ladderLength("hit", "cog", wordList);
        System.out.println(result);
    }

}

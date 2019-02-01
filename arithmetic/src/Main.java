import java.util.List;

/**
 * Created by shengliyi on 2017/3/4.
 */

public class Main {

    public static void main(String[] args) {
        String[] strs = {"paw","dad","bog","day","day","mig","len","rat"};
        List<List<String>> result = new LeetCode49GroupAnagrams().groupAnagrams(strs);
        System.out.println(result);

    }
}

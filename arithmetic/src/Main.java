import java.util.ArrayList;
import java.util.List;

/**
 * Created by shengliyi on 2017/3/4.
 */

public class Main {
//-2147483648
    public static void main(String[] args) {
//        boolean[][] isUsed = new boolean[2][3];


        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1, 10));
        intervals.add(new Interval(2, 3));
        intervals.add(new Interval(4, 5));
        intervals.add(new Interval(6, 7));
        intervals.add(new Interval(8, 9));


        List<Interval> list = new LeetCode56MergeIntervals().merge(intervals);

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).start + "\t" + list.get(i).end);
        }
    }
}

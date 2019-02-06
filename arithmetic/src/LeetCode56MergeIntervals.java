/*
Example 1:

Input: [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].

Example 2:

Input: [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 */

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LeetCode56MergeIntervals {
    public List<Interval> merge(List<Interval> intervals) {

        if (intervals.size() <= 1) return intervals;

        List<Interval> result = new ArrayList<>();

        // 使用 Comparator 排序
        intervals.sort(new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if (o1.start < o2.start) return -1;
                else if (o1.start > o2.start) return 1;
                else return 0;
            }
        });

        int resStart = intervals.get(0).start;  // 表示删去interval的start
        int resEnd = intervals.get(0).end;      // 表示删去interval的end

        for (int i = 1; i < intervals.size(); i++) {
            int nowStart = intervals.get(i).start;
            int nowEnd = intervals.get(i).end;

            if (resEnd >= nowStart) {
                resEnd = Math.max(nowEnd, resEnd);
            } else {
                result.add(new Interval(resStart, resEnd));
                resStart = nowStart;
                resEnd = nowEnd;
            }

        }

        result.add(new Interval(resStart, resEnd)); // 把最后一组加上

        return result;
    }

}

class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }

}






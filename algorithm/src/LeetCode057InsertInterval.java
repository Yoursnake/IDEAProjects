/*
Example 1:

Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
Output: [[1,5],[6,9]]

Example 2:

Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
Output: [[1,2],[3,10],[12,16]]
Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
 */

import java.util.List;

public class LeetCode057InsertInterval {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        int originSize = intervals.size();
        if (originSize == 0) {
            intervals.add(newInterval);
            return intervals;
        }

        for (int i = 0; i < originSize; i++) {
            if (newInterval.start <= intervals.get(i).start) {
                intervals.add(i, newInterval);
                break;
            }
        }

        if (intervals.size() == originSize) {
            intervals.add(newInterval);
        }

        int lastStart = intervals.get(0).start;  // 表示删去interval的start
        int lastEnd = intervals.get(0).end;      // 表示删去interval的end
        int index = 1;

        while (index < intervals.size()) {
            int nowStart = intervals.get(index).start;
            int nowEnd = intervals.get(index).end;

            if (nowStart <= lastEnd) {
                intervals.remove(index);
                intervals.remove(index - 1);
                intervals.add(index - 1, new Interval(lastStart, Math.max(lastEnd, nowEnd)));

                lastEnd = Math.max(lastEnd, nowEnd);
                continue;
            }

            lastStart = nowStart;
            lastEnd = nowEnd;
            index++;
        }

        return intervals;

    }
}

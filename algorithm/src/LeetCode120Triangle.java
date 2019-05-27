/*
Given a triangle, find the minimum path sum from top to bottom.
Each step you may move to adjacent numbers on the row below.

For example, given the following triangle

[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

Note:

Bonus point if you are able to do this using only O(n) extra space,
where n is the total number of rows in the triangle.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode120Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 1) return triangle.get(0).get(0);

        List<List<Integer>> list = new ArrayList<>();
        // 第一个 list 取第一行第一个数
        list.add(new ArrayList<>(Arrays.asList(triangle.get(0).get(0))));
        int result = Integer.MAX_VALUE;

        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> curr = new ArrayList<>();

            for (int j = 0; j <= i; j++) {
                int temp;

                if (j == 0)
                    temp = list.get(i - 1).get(0) + triangle.get(i).get(0);
                else if (j == i)
                    temp = list.get(i - 1).get(i - 1) + triangle.get(i).get(i);
                else
                    temp = Math.min(list.get(i - 1).get(j - 1), list.get(i - 1).get(j)) + triangle.get(i).get(j);

                if (i != triangle.size() - 1)
                    curr.add(temp);
                else                // 最后一次直接判断大小
                    if (result > temp)
                        result = temp;
            }

            // 最后一次不需要加入队列
            if (i != triangle.size() - 1)
                list.add(curr);
        }

        return result;
    }
}

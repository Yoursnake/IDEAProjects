/*
Input: 5
Output:
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
 */

import java.util.ArrayList;
import java.util.List;

public class LeetCode118PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows == 0) return result;
        result.add(new ArrayList<Integer>() {{add(1);}});
        if (numRows == 1) return result;

        for (int i = 1; i < numRows; i++) {
            List<Integer> last = result.get(i - 1);
            List<Integer> curr = new ArrayList<>();
            curr.add(1);
            for (int j = 1; j < i; j++) {
                curr.add(last.get(j - 1) + last.get(j));
            }
            curr.add(1);
            result.add(curr);
        }

        return result;
    }
}

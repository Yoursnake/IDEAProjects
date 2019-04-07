/*
Input: 3
Output: [1,3,3,1]
 */
import java.util.ArrayList;
import java.util.List;

public class LeetCode119PascalsTriangleII {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> last = new ArrayList<Integer>() {{add(1);}};
        if (rowIndex == 0) return last;

        for (int i = 1; i <= rowIndex; i++) {
            List<Integer> curr = new ArrayList<>();
            curr.add(1);
            for (int j = 1; j < i; j++) {
                curr.add(last.get(j - 1) + last.get(j));
            }
            curr.add(1);
            last = curr;
        }

        return last;
    }
}

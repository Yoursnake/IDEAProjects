import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by shengliyi on 2017/3/4.
 */

public class Main {

    @Test
	public void LeetCode377() {
	    int[] nums = {2, 1, 3};
	    int target = 35;

	    int res = new LeetCode377CombinationSumIV().combinationSum4(nums, target);
	    System.out.println(res);
    }

    @Test
	public void LeetCode381() {
	    LeetCode381InsertDeleteGetRandomO1Duplicatesallowed obj = new LeetCode381InsertDeleteGetRandomO1Duplicatesallowed();
	    boolean param1 = obj.insert(1);
	    boolean param2 = obj.remove(1);
	    boolean param3 = obj.insert(1);
	    System.out.println(param1 + "\t" + param2 + "\t" + param3);
    }

    @Test
	public void LeetCode385() {
	    String s = "[0]";
    	new LeetCode385MiniParser().deserialize(s);
    }

    @Test
	public void LeetCode388() {
	    String input = "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext";
	    int res = new LeetCode388LongestAbsoluteFilePath().lengthLongestPath(input);
	    System.out.println(res);
    }

    @Test
    public void LeetCode390() {
    	int n = 9;
    	int res = new LeetCode390EliminationGame().lastRemaining(n);
	    System.out.println(res);
    }

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(4);
		int idx1 = Collections.binarySearch(list, 2);
		int idx2 = Collections.binarySearch(list, 3);

		System.out.println(idx1);
		System.out.println(idx2);

		Collections.sort(list, (o1, o2) -> (o2 - o1));
		int idx3 = Collections.binarySearch(list, 1, Collections.reverseOrder());
		System.out.println(idx3);
	}

}

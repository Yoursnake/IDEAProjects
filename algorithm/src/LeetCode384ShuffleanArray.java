/*
Shuffle a set of numbers without duplicates.

Example:

// Init an array with set 1, 2, and 3.
int[] nums = {1,2,3};
Solution solution = new Solution(nums);

// Shuffle the array [1,2,3] and return its result. Any permutation 
of [1,2,3] must equally likely to be returned.
solution.shuffle();

// Resets the array back to its original configuration [1,2,3].
solution.reset();

// Returns the random shuffling of array [1,2,3].
solution.shuffle();
*/

import java.util.*;

// 73ms 93%
public class LeetCode384ShuffleanArray {
	private int[] origin;
	private Random random;

	public LeetCode384ShuffleanArray(int[] nums) {
        origin = nums;
        random = new Random();
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return origin;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        List<Integer> list = new ArrayList<>();
        for (int num : origin) list.add(num);
        int[] res = new int[origin.length];

        for (int i = 0; i < origin.length; i++) {
        	res[i] = list.remove(random.nextInt(list.size()));
        }

        return res;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
public class LeetCode334IncreasingTripletSubsequence {
	// Greed: 0ms 100%
	public boolean increasingTriplet(int[] nums) {
        int a0 = Integer.MAX_VALUE, a1 = Integer.MAX_VALUE;
        
        for (int num : nums) {
            if (num <= a0) {
                a0 = num;
                continue;
            } else if (num <= a1) {
                a1 = num;
                continue;
            } else {
                return true;
            }
        }
        
        return false;
    }
}
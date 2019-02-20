public class LeetCode55JumpGame {
    public boolean canJump(int[] nums) {
        if (nums.length == 1) return true;

        int maxReach = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (maxReach < i) return false;
            maxReach = Math.max(maxReach, i + nums[i]);
            if (maxReach >= nums.length - 1) return true;
        }

        return false;
    }
}

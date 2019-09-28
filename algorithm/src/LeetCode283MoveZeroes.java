/*
Given an array nums, write a function to move all 0's to the end of it 
while maintaining the relative order of the non-zero elements.

Example:

Input: [0,1,0,3,12]
Output: [1,3,12,0,0]

Note:

You must do this in-place without making a copy of the array.
Minimize the total number of operations.
*/

public class LeetCode283MoveZeroes {
	public void moveZeroes(int[] nums) {
        int count = 0;
        
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num != 0) {
                nums[count++] = num;
            }
        }
        
        for (int i = count; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
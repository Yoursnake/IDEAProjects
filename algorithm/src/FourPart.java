/**
 * Created by shengliyi on 2017/3/9.
 */
public class FourPart {

    static boolean fourPart(int nums[]) {
        int sum = 0;
        int sum23 = 0;
        int sum1 = nums[0],sum2 = 0,sum3 = 0,sum4 = nums[nums.length-1];
        int i;
        int j=0;
        int[] sign1 = new int[nums.length];
        int[] sign2 = new int[nums.length];
        int[] sign3 = new int[nums.length];
        for (i = 1; i < nums.length-1-i; i++) {
            if (sum1 < sum4) {
                sum1 += nums[i];
            } else if (sum1 > sum4) {
                sum4 += nums[nums.length-1-i];
            } else {
                sign1[j] = i+1;
                sign3[j] = nums.length-i;
                j++;
            }
        }

        if (j == 0) return false;

        for (int k = 0; k < j; k++) {
            for (int l = sign1[k]+1; l < sign3[k]-1; l++) {
                sum23 += nums[l];
            }
            for (int l = sign1[k]+1; l < sign3[k]-1; l++) {
                if ((sum23-nums[l])/2 == sum1) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {2,5,1,1,1,1,4,1,7,3,7};
        System.out.print(fourPart(nums));
    }
}

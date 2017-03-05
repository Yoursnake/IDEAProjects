import java.util.Stack;

/**
 * Created by shengliyi on 2017/3/5.
 */
public class Find132Pattern {

    public static boolean find132pattern(int[] nums) {
        if (nums.length < 3) return false;
        int max2; //max2是第二次循环中的最大值
        for (int i = 0; i < nums.length - 2; i++) {
            max2 = nums[i + 1];
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] > nums[i] && nums[j] > max2)
                    max2 = nums[j];             //保存第二次循环中的最大值
                else if(nums[j] < max2 && nums[j] > nums[i])    //如果第二次循环遍历的数比最大值小，而且比第一次循环遍历的大，则为真
                    return true;
            }
        }
        return false;

    }

    /*用栈来实现*/
    /*思路是我们维护一个栈和一个变量third，其中third就是第三个数字，也是pattern 132中的2，
    栈里面按顺序放所有大于third的数字，也是pattern 132中的3，那么我们在遍历的时候，如果当前
    数字小于third，即pattern 132中的1找到了，我们直接返回true即可，因为已经找到了，注意我们
    应该从后往前遍历数组。如果当前数字大于栈顶元素，那么我们按顺序将栈顶数字取出，赋值给third，
    然后将该数字压入栈，这样保证了栈里的元素仍然都是大于third的，我们想要的顺序依旧存在，进一步
    来说，栈里存放的都是可以维持second > third的second值，其中的任何一个值都是大于当前的third值，
    如果有更大的值进来，那就等于形成了一个更优的second > third的这样一个组合，并且这时弹出的
    third值比以前的third值更大，为什么要保证third值更大，因为这样才可以更容易的满足当前的值
    first比third值小这个条件*/
    public static boolean find132pattern2(int[] nums) {
        if (nums.length < 3) return false;
        int third = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (third > nums[i]) {  //third先取最小值
                third = nums[i];
            }
        }

        Stack<Integer> s = new Stack<Integer>();
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] < third) return true;
            else while (!s.empty() && nums[i] > s.peek()){
                third = s.peek(); s.pop();
            }
            s.push(nums[i]);
        }
        return false;
    }
}

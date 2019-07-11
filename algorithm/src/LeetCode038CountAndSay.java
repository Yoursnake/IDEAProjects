/**
 * Created by shengliyi on 2017/3/31.
 */
public class LeetCode038CountAndSay {
    public static String countAndSay(int n) {
        if (n == 1)
            return "1";     // 递归的出口
        String lastSeq = countAndSay(- 1); // 使用递归得到之前的序列
        int length = lastSeq.length();
        String res = "";
        char currentNum = '0';
        int count = 0;
        for (int i = 0; i < length; i++) {
            /*
            如果当前的数字和之前的不同则现将之前的数字记录在res中（第一次除外）
            然后保存当前数字，对当前数字重现开始计数
            如果当前的数字和之前的相同则计数加一
             */
            if (currentNum != lastSeq.charAt(i)) {
                if (count != 0)
                    res = res + count +currentNum;
                currentNum = lastSeq.charAt(i);
                count = 1;
            } else {
                count++;
            }
        }
        // 最后将最后一段添加到res中
        res = res + count + currentNum;
        return res;
    }
}

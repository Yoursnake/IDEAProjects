import java.util.ArrayList;
import java.util.List;

/**
 * Created by shengliyi on 2017/3/15.
 */
public class LeetCode3LongestSubString {

    public int lengthOfLongestSubstring(String s) {
        int length = s.length();
        List<Character> charList = new ArrayList<>();
        char[] chars = s.toCharArray();
        int maxLength = 0;
        for (int i = 0; i < length; ) {
            int temp = i;
            for (int j = i; j < length; j++) {
                // 如果队列中存在字符，则找到该字符在队列中的位置，加上 i 就是字符在数组中的位置
                if (charList.contains(chars[j])) {
                    int a = charList.indexOf(chars[j]) + 1;
                    int b = j + 1;
                    while (charList.get(a) == charList.get(b)) {
                        a++;
                        b++;
                        if (b == charList.size()) break;
                    }
                    temp = i + a - 1;
                    break;
                }
                charList.add(chars[j]);
            }
            // 下一次遍历从队列中已存在的字符的下一个字符开始遍历
            i = temp+1;
            if (charList.size() > maxLength) {
                maxLength = charList.size();
            }
            charList.clear();
        }
        return maxLength;
    }

    //优化后的算法
    public static int lengthOfLongestSubstring2(String s) {
        int length = s.length();
        List<Character> charList = new ArrayList<>();
        char[] chars = s.toCharArray();
        int maxLength = 0;
        for (int i = 0; i < length; ) {
            int temp = i;
            for (int j = i; j < length; j++) {
                // 如果队列中存在字符，则找到该字符在队列中的位置，从当前位置的数组和列表中重复字符同时向后找，直到两个字符不相同
                if (charList.contains(chars[j])) {
                    int a = charList.indexOf(chars[j]); //找到列表中与数组当前字符重复的字符的位置
                    int b = j;                          //找到数组中当前字符的位置
                    while (charList.get(a) == chars[b]) {
                        a++;
                        b++;
                        if (a == charList.size()) break;
                        if (b == chars.length) break;
                    }
                    temp = i + a - 1;
                    break;
                }
                charList.add(chars[j]);
            }
            // 下一次遍历从队列中已存在的字符的下一个字符开始遍历
            i = temp+1;
            if (charList.size() > maxLength) {
                maxLength = charList.size();
            }
            charList.clear();
        }
        return maxLength;
    }
}

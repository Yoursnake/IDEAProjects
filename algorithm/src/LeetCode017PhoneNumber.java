import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
Input: "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */

public class LeetCode017PhoneNumber {
    HashMap<Character, String> number = new HashMap<>();

    public LeetCode17PhoneNumber() {
        number.put('2', "abc");
        number.put('3', "def");
        number.put('4', "ghi");
        number.put('5', "jkl");
        number.put('6', "mno");
        number.put('7', "pqrs");
        number.put('8', "tuv");
        number.put('9', "wxyz");
    }

    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();

        getString(digits, 0, "", list);

        return list;
    }

    public void getString(String digits, int index, String curr, List<String> list) {
        if (index == digits.length()) {
            if (curr.length() != 0)
                list.add(curr);
        } else {
            char c = digits.charAt(index);
            String alphaStr = number.get(c);
            char[] alphaChars = alphaStr.toCharArray();
            for (char alpha : alphaChars) {
                String temp = curr + alpha;
                getString(digits, index + 1, temp, list);   // 递归回溯
            }
        }
    }
}

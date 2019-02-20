/*
未完成
 */

public class LeetCode8atoi {
    public int myAtoi(String str) {
        String newStr = str.trim();
        char[] c = newStr.toCharArray();
        String numStr = "";
        int result;

        for (int i = 0; i < c.length; i++) {
            if (isNum(c[i])) {
                numStr += c[i];
            } else {
                break;
            }
        }

        if (numStr.isEmpty() || isSymbol(numStr.charAt(0)) && isSymbol(numStr.charAt(1))) {
            return 0;
        }

        if (isBeyond(numStr)) {
            if (numStr.charAt(0) == '-') {
                return -2147483648;
            } else {
                return 2147483647;
            }
        }

        int digit = numStr.length();
        if (numStr.charAt(0) == '+' || numStr.charAt(0) == '-') {
            result = str2int(numStr.substring(1, digit));
            if (numStr.charAt(0) == '-') {
                return 0 - result;
            } else {
                return result;
            }
        } else {
            return str2int(numStr);
        }


    }

    public boolean isNum(char c) {
        if (c < '0' || c > '9') {
            if (isSymbol(c)) {
                return true;
            } else {
                return false;
            }
        }
        return true;
    }

    public int str2int(String s) {
        int result = 0;
        int len = s.length();
        char[] c = s.toCharArray();

        for (int i = 0; i < len; i++) {
            result += (c[i] - '0') * (int) Math.pow(10, len - i - 1);
        }

        return result;
    }

    public boolean isBeyond(String s) {
        int digit = s.length();
        char[] numChars;
        char[] temp;
        String numStr = "";
        String posBound = "2147483647";
        String negBound = "2147483648";

        if (isSymbol(s.charAt(0))) {
            temp = s.substring(1, digit).toCharArray();
        } else {
            temp = s.toCharArray();
        }

        int point = 0;
        while (point < temp.length) {
            if (temp[point] == '0') {
                point++;
            } else {
                break;
            }
        }

        while (point < temp.length) {
            numStr += temp[point];
            point++;
        }

        numChars = numStr.toCharArray();
        digit = numChars.length;

        if (digit > 10) {
            return true;
        } else if (digit < 10) {
            return false;
        } else if (digit == 10) {
            char[] bound;
            if (s.charAt(0) == '-') {
                bound = negBound.toCharArray();
            } else {
                bound = posBound.toCharArray();
            }

            for (int i = 0; i < digit; i++) {
                if (numChars[i] > bound[i]) {
                    return true;
                } else if (numChars[i] < bound[i]) {
                    continue;
                } else {
                    return false;
                }
            }
        }

        return false;
    }

    public boolean isSymbol(char c) {
        if (c == '+' || c == '-') {
            return true;
        } else {
            return false;
        }
    }
}

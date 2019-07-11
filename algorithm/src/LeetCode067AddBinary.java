public class LeetCode067AddBinary {
    public String addBinary(String a, String b) {
        String num1;
        String num2;
        String result = "";
        int flag = 0;

        if (a.length() > b.length()) {
            num1 = a;
            num2 = b;
        } else {
            num1 = b;
            num2 = a;
        }

        for (int i = num2.length(); i < num1.length(); i++) {
            num2 = "0" + num2;
        }

        for (int i = num1.length() - 1; i >= 0; i--) {
            int curr = num1.charAt(i) - '0' + num2.charAt(i) - '0' + flag;
            flag = curr / 2;
            result = (curr % 2) + result;
        }

        if (flag == 1) result = "1" + result;
        return result;
    }
}

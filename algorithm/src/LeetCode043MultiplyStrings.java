public class LeetCode043MultiplyStrings {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        String up;
        String down;
        if (num1.length() <= num2.length()) {
            up = num2;
            down = num1;
        } else {
            up = num1;
            down = num2;
        }

        String[] mults = new String[down.length()];
        char[] upChars = up.toCharArray();
        char[] downChars = down.toCharArray();

        // 找到所有乘积结果
        int index = 0;
        for (int i = downChars.length - 1; i >= 0; i--) {
            int tempDown = downChars[i] - '0';
            int flag = 0;   // 进位

            mults[index] = "";
            for (int j = upChars.length - 1; j >= 0; j--) {
                int tempUp = upChars[j] - '0';
                int tempMult = tempUp * tempDown;
                tempMult = tempMult + flag; // 进位要先加再算该位对应的数值
                mults[index] = (tempMult % 10) + mults[index];
                flag = tempMult / 10;
            }
            if (flag != 0) {
                mults[index] = flag + mults[index];
            }

            // 在结果后面填 0
            for (int j = 0; j < index; j++) {
                mults[index] = mults[index] + "0";
            }

            index++;
        }

        // 找最长的数是几位
        int maxLength = 0;
        for (int i = 0; i < mults.length; i++) {
            if (mults[i].length() > maxLength) {
                maxLength = mults[i].length();
            }
        }

        // 在小于最长数前面补0
        for (int i = 0; i < mults.length; i++) {
            if (mults[i].length() < maxLength) {
                int tempLength = mults[i].length();
                for (int j = 0; j < maxLength - tempLength; j++) {
                    mults[i] = "0" + mults[i];
                }
            }
        }

        String result = "";
        int flag = 0;   // 进位
        // 乘积相加
        for (int i = maxLength - 1; i >= 0; i--) {
            int sum = 0;
            for (int j = 0; j < mults.length; j++) {
                sum += (mults[j].charAt(i) - '0');
            }
            sum += flag;    // 进位要先加再算该位对应的数值
            flag = sum / 10;
            result = (sum % 10) + result;
        }
        if (flag != 0) {
            result = flag + result;
        }

        return result;
    }

}

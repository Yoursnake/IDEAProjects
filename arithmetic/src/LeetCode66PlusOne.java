public class LeetCode66PlusOne {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        int curr = digits[len - 1] + 1;
        int flag = curr / 10;
        digits[len - 1] = curr % 10;

        for (int i = digits.length - 2; i >= 0; i--) {
            if (flag == 0) break;

            curr = digits[i] + flag;
            flag = curr / 10;
            digits[i] = curr % 10;
        }

        if (flag == 1) {
            int[] result = new int[len + 1];
            result[0] = 1;
            for (int i = 1; i < len + 1; i++) {
                result[i] = digits[i - 1];
            }
            return result;
        } else {
            return digits;
        }
    }
}

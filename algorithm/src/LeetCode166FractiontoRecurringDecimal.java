/*
Given two integers representing the numerator and denominator of a fraction,
return the fraction in string format.

If the fractional part is repeating, enclose the repeating part in parentheses.

Example 1:

Input: numerator = 1, denominator = 2
Output: "0.5"

Example 2:

Input: numerator = 2, denominator = 1
Output: "2"

Example 3:

Input: numerator = 2, denominator = 3
Output: "0.(6)"
 */

import java.util.HashMap;

public class LeetCode166FractiontoRecurringDecimal {
    public String fractionToDecimal(int numerator, int denominator) {
        // 先转成 long，防止越界
        long numeratorLong = numerator;
        long denominatorLong = denominator;

        // 判断是否要加负号
        boolean negFlag = false;
        if (numerator < 0 && denominator > 0
                || numerator > 0 && denominator < 0) negFlag = true;

        // 转成正数
        numeratorLong = Math.abs(numeratorLong);
        denominatorLong = Math.abs(denominatorLong);

        StringBuilder sb = new StringBuilder();

        long intPart = numeratorLong / denominatorLong;     // 整数部分，最后添加
        long remainder = numeratorLong % denominatorLong;   // 第一次的余数
        if (remainder == 0) {
            sb.append(intPart);
            if (negFlag) sb.insert(0, '-');     // 注意！
            return sb.toString();
        }

        int count = 1;
        HashMap<Long, Integer> map = new HashMap<>();
        map.put(remainder, count++);        // 将余数保存下来

        sb.append('.');
        long last = remainder * 10;
        while (true) {
            long divPart = last / denominatorLong;  // 除数部分
            sb.append(divPart);
            remainder = last % denominatorLong;     // 余数部分
            if (remainder == 0) break;
            if (map.containsKey(remainder)) {       // 如果余数重复证明开始重复
                int index = map.get(remainder);
                sb.insert(index, '(');
                sb.append(')');
                break;
            } else {
                map.put(remainder, count++);
            }
            last = remainder * 10;
        }

        sb.insert(0, intPart);
        if (negFlag) sb.insert(0, '-');     // 注意！

        return sb.toString();
    }
}

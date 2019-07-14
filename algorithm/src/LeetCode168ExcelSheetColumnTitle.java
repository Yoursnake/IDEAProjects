/*
Given a positive integer, return its corresponding column title as appear in an
Excel sheet.

For example:

    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB
    ...

Example 1:

Input: 1
Output: "A"

Example 2:

Input: 28
Output: "AB"

Example 3:

Input: 701
Output: "ZY"
 */

public class LeetCode168ExcelSheetColumnTitle {
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();

        while (n != 0) {
            int remainder = n % 26;
            if (remainder == 0) remainder = 26;
            char curr = (char) ('A' + remainder - 1);
            sb.insert(0, curr);
            n = (n - remainder) / 26;
        }

        return sb.toString();
    }
}

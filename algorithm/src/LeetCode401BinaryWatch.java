/*
A binary watch has 4 LEDs on the top which represent the hours (0-11), and the 6 LEDs on the bottom 
represent the minutes (0-59).

Each LED represents a zero or one, with the least significant bit on the right.


For example, the above binary watch reads "3:25".

Given a non-negative integer n which represents the number of LEDs that are currently on, return all 
possible times the watch could represent.

Example:

Input: n = 1
Return: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "0:32"]
Note:
- The order of output does not matter.
- The hour must not contain a leading zero, for example "01:00" is not valid, it should be "1:00".
- The minute must be consist of two digits and may contain a leading zero, for example "10:2" is not valid, 
it should be "10:02".
*/

import java.util.*;

public class LeetCode401BinaryWatch {
    public List<String> readBinaryWatch(int num) {
        int[] hours = {1, 2, 4, 8};
        int[] mins = {1, 2, 4, 8, 16, 32};
        List<String> res = new ArrayList<>();
        
        for (int hourNum = 0; hourNum <= num; hourNum++) {
            int minNum = num - hourNum;
            List<Integer> hourList = generateList(hours, hourNum);
            List<Integer> minList = generateList(mins, minNum);
            
            for (int hour : hourList) {
                if (hour >= 12) continue;
                for (int min : minList) {
                    if (min >= 60) continue;
                    res.add(String.format("%d:%02d", hour, min));
                }
            }
        }
        
        return res;
    }
    
    private List<Integer> generateList(int[] times, int num) {
        List<Integer> res = new ArrayList<>();
        dfs(0, res, times, 0, num);
        return res;
    }
    
    private void dfs(int curr, List<Integer> res, int[] times, int start, int num) {
        if (num == 0) {
            res.add(curr);
            return;
        }
        
        for (int i = start; i < times.length; i++) {
            dfs(curr + times[i], res, times, i + 1, num - 1);
        }
    }
}
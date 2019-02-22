/*
Given a string containing only digits, restore it by returning all possible valid IP address combinations.

Example:

Input: "25525511135"
Output: ["255.255.11.135", "255.255.111.35"]
 */

import java.util.ArrayList;
import java.util.List;

public class LeetCode93RestoreIPAddresses {
    public List<String> restoreIpAddresses(String s) {
        List<List<String>> ipList = new ArrayList<>();
        List<String> curr = new ArrayList<>();
        List<String> result = new ArrayList<>();

        findIpAddresses(ipList, curr, 0, s, 1);

        // 把找到的ip拼接成字符串
        for (int i = 0; i < ipList.size(); i++) {
            List<String> temp = ipList.get(i);
            String ipAddress = "";
            for (int j = 0; j < temp.size(); j++) {
                ipAddress += temp.get(j);
                if (j != temp.size() - 1) ipAddress += ".";
            }
            result.add(ipAddress);
        }

        return result;
    }

    private void findIpAddresses(List<List<String>> ipList, List<String> curr, int index,  String s ,int numIp) {
        if (numIp == 4) {
            // 最后一个ip必须小于 4 位，最后一个ip如果第一位为0则只可能有1位，否则第一位不为0
            if (s.length() - index < 4 && (s.length() - index == 1 || s.charAt(index) != '0')) {
                String Ip4 = s.substring(index, s.length());
                if (Integer.parseInt(Ip4) <= 255) {
                    curr.add(Ip4);
                    ipList.add(new ArrayList<>(curr));
                    curr.remove(curr.size() - 1);
                }
            }
            return;
        }

        for (int i = 1; i <= 3; i++) {
            if (index + i >= s.length()) return;    // 防止前面几个ip把字符串用完

            String Ipi = s.substring(index, index + i);
            if (Integer.parseInt(Ipi) <= 255) {
                curr.add(Ipi);
                findIpAddresses(ipList, curr, index + i, s, numIp + 1);
                curr.remove(curr.size() - 1);
            }

            if (s.charAt(index) == '0') return;     // 如果ip以0开头只考虑当前ip位为1位
        }
    }
}

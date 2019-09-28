/*
Given an array of citations (each citation is a non-negative integer) 
of a researcher, write a function to compute the researcher's h-index.

According to the definition of h-index on Wikipedia: "A scientist has 
index h if h of his/her N papers have at least h citations each, and 
the other N − h papers have no more than h citations each."

Example:

Input: citations = [3,0,6,1,5]
Output: 3 
Explanation: [3,0,6,1,5] means the researcher has 5 papers in total and each of them had 
             received 3, 0, 6, 1, 5 citations respectively. 
             Since the researcher has 3 papers with at least 3 citations each and the remaining 
             two with no more than 3 citations each, her h-index is 3.
             
Note: If there are several possible values for h, the maximum one is taken as the h-index.
*/

public class LeetCode274HIndex {
	 // // sort: O(nlong) 61.31% 1ms
	 // public int hIndex(int[] citations) {
	 // 	if (citations.length == 0) return 0;	// 无元素返回 0
        
	 // 	Arrays.sort(citations);
        
	 // 	int len = citations.length;
        
  //        if (citations[len - 1] == 0) return 0;	// 最大值为 0 返回 0

	 // 	if (len <= citations[0]) return len;

	 // 	for (int i = len - 1; i >= 1; i--) {
	 // 		int curr = citations[i];
	 // 		int pre = citations[i - 1];

	 // 		int h = len - i;
	 // 		if (h >= pre && h <= curr) return h;	// 注意两边都有等于
	 // 	}

	 // 	return -1;
	 // }

	// map: O(n) 100% 0ms   结果只可能出现在 0~n
	public int hIndex(int[] citations) {
		if (citations.length == 0) return 0;

		int len = citations.length;
		int[] count = new int[len + 1];		// 用于计数，每个数字出现了几次，最后一位记大于等于 len 的出现了几次

		for (int i = 0; i < citations.length; i++) {
			int curr = citations[i];
			if (curr >= len) count[len]++;
			else count[curr]++;
		}

		for (int i = len; i > 0; i--) {
			if (i <= count[i]) return i;	// 如果 i <= count[i]，则一定有 i+1 > count[i+1]
			count[i - 1] += count[i];		// 将 count 变成大于等于 i 的数字出现的次数
		}

		return 0;
	}
}
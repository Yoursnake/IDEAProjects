/*
Convert a non-negative integer to its english words representation. 
Given input is guaranteed to be less than 231 - 1.

Example 1:

Input: 123
Output: "One Hundred Twenty Three"

Example 2:

Input: 12345
Output: "Twelve Thousand Three Hundred Forty Five"

Example 3:

Input: 1234567
Output: "One Million Two Hundred Thirty Four Thousand Five Hundred 
Sixty Seven"

Example 4:

Input: 1234567891
Output: "One Billion Two Hundred Thirty Four Million Five Hundred Sixty 
Seven Thousand Eight Hundred Ninety One"
*/

public class LeetCode273IntegertoEnglishWords {
	// // HashMap: 11.63% 4ms
	// public String numberToWords(int num) {
	// 	if (num == 0) return "Zero";

	// 	String res = "";
	// 	Map<Integer, String> nDigitMap = new HashMap<>();
	// 	Map<Integer, String> tenDigitMap = new HashMap<>();
	// 	Map<Integer, String> nTenDigitMap = new HashMap<>();
	// 	Map<Integer, String> thousandDigitMap = new HashMap<>();

	// 	// 个位数 map
	// 	nDigitMap.put(0, "");
	// 	nDigitMap.put(1, "One");
	// 	nDigitMap.put(2, "Two");
	// 	nDigitMap.put(3, "Three");
	// 	nDigitMap.put(4, "Four");
	// 	nDigitMap.put(5, "Five");
	// 	nDigitMap.put(6, "Six");
	// 	nDigitMap.put(7, "Seven");
	// 	nDigitMap.put(8, "Eight");
	// 	nDigitMap.put(9, "Nine");

	// 	// 十位上为 1 的十位数 map
	// 	tenDigitMap.put(0, "Ten");
	// 	tenDigitMap.put(1, "Eleven");
	// 	tenDigitMap.put(2, "Twelve");
	// 	tenDigitMap.put(3, "Thirteen");
	// 	for (int i = 4; i <= 9; i++) tenDigitMap.put(i, nDigitMap.get(i) + "teen");
	// 	tenDigitMap.put(5, "Fifteen");
	// 	tenDigitMap.put(8, "Eighteen");

	// 	// 十位上不为 1 的十位数 map
	// 	nTenDigitMap.put(0, "");
	// 	nTenDigitMap.put(2, "Twenty");
	// 	nTenDigitMap.put(3, "Thirty");
	// 	nTenDigitMap.put(4, "Forty");
	// 	nTenDigitMap.put(5, "Fifty");
	// 	for (int i = 6; i <= 9; i++) nTenDigitMap.put(i, nDigitMap.get(i) + "ty");
	// 	nTenDigitMap.put(8, "Eighty");		

	// 	// 每过 1000 的 map
	// 	thousandDigitMap.put(0, "");
	// 	thousandDigitMap.put(1, "Thousand");
	// 	thousandDigitMap.put(2, "Million");
	// 	thousandDigitMap.put(3, "Billion");

	// 	int thousandNum = -1;
	// 	// 1000 一个循环
	// 	while (num != 0) {
 //            int currNum = num % 1000;
	// 		String currStr = "";
	// 		num = num / 1000;
	// 		thousandNum++;
 //            if (currNum == 0) continue;
            
	// 		res = thousandDigitMap.get(thousandNum) + " " + res;
 //            res = res.trim();

	// 		int digit = currNum % 10;
	// 		int tenDigit = (currNum % 100) / 10;
	// 		int hundredDidgit = currNum / 100;

	// 		if (tenDigit == 1) currStr = tenDigitMap.get(currNum % 10);
	// 		else currStr = nTenDigitMap.get(tenDigit) + " " + nDigitMap.get(digit);
 //            currStr = currStr.trim();

	// 		if (hundredDidgit != 0) currStr = nDigitMap.get(hundredDidgit) + " Hundred " + currStr;
 //            currStr = currStr.trim();

	// 		res = currStr + " " + res;
	// 	}

	// 	return res.trim();
	// }


	// Array: 100% 1ms
	String[] kUnder20 = {"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
						"Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "SevenTeen",
						"Eighteen", "Nineteen"};
	String[] kUnder100 = {"Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
	String[] kHTMB = {"Hundred", "Thousand", "Million", "Billion"};
	int[] limit = {100, 1000, 1000 * 1000, 1000 * 1000 * 1000};
	
	public String numberToWords(int num) {
		if (num == 0) return "Zero";

		return convert(num).substring(1);
	}

	private String convert(int num) {
		if (num == 0) return "";
		if (num < 20) return " " + kUnder20[num - 1];
		if (num < 100) return " " + kUnder100[num / 10 - 2] + convert(num % 10);

		for (int i = 3; i >= 0; i--) {
			if (num >= limit[i]) return convert(num / limit[i]) + " " + kHTMB[i] + convert(num % limit[i]);
		}

		return "";
	}
}
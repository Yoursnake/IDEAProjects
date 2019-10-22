/*
Write a program to find the nth super ugly number.

Super ugly numbers are positive numbers whose all prime factors are 
in the given prime list primes of size k.

Example:

Input: n = 12, primes = [2,7,13,19]
Output: 32 
Explanation: [1,2,4,7,8,13,14,16,19,26,28,32] is the sequence of the first 12 
             super ugly numbers given primes = [2,7,13,19] of size 4.

Note:

1 is a super ugly number for any given primes.
The given numbers in primes are in ascending order.
0 < k ≤ 100, 0 < n ≤ 106, 0 < primes[i] < 1000.
The nth super ugly number is guaranteed to fit in a 32-bit signed integer.
*/

public class LeetCode313SuperUglyNumber {
	// // List: 40% 25ms
	// public int nthSuperUglyNumber(int n, int[] primes) {
	// 	int[] idx = new int[primes.length];
	// 	List<Integer> list = new ArrayList<>();
	// 	list.add(1);

	// 	for (int i = 0; i < n - 1; i++) {
	// 		int tmpVal = Integer.MAX_VALUE;

	// 		for (int j = 0; j < primes.length; j++) {
	// 			tmpVal = Math.min(tmpVal, list.get(idx[j]) * primes[j]);
	// 		}

	// 		list.add(tmpVal);
			
	// 		for (int j = 0; j < primes.length; j++) {
	// 			if (tmpVal == list.get(idx[j]) * primes[j]) idx[j]++;
	// 		}
	// 	}

	// 	return list.get(list.size() - 1);
	// }

	// Array: 83% 11ms
	public int nthSuperUglyNumber(int n, int[] primes) {
		int[] idx = new int[primes.length];
		int[] array = new int[n];
		array[0] = 1;

		for (int i = 1; i <= n - 1; i++) {
			int tmpVal = Integer.MAX_VALUE;

			for (int j = 0; j < primes.length; j++) {
				tmpVal = Math.min(tmpVal, array[idx[j]] * primes[j]);
			}

			array[i] = tmpVal;
			
			for (int j = 0; j < primes.length; j++) {
				if (tmpVal == array[idx[j]] * primes[j]) idx[j]++;
			}
		}

		return array[n - 1];
	}
}
/*
You are given two jugs with capacities x and y litres. There 
is an infinite amount of water supply available. You need to 
determine whether it is possible to measure exactly z litres 
using these two jugs.

If z liters of water is measurable, you must have z liters of 
water contained within one or both buckets by the end.

Operations allowed:

Fill any of the jugs completely with water.
Empty any of the jugs.
Pour water from one jug into another till the other jug is 
completely full or the first jug itself is empty.

Example 1: (From the famous "Die Hard" example)

Input: x = 3, y = 5, z = 4
Output: True

Example 2:

Input: x = 2, y = 6, z = 5
Output: False
*/

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class LeetCode365WaterandJugProblem {
	// private class KeyPair {
	// 	public int x;
	// 	public int y;

	// 	public KeyPair(int x, int y) {
	// 		this.x = x;
	// 		this.y = y;
	// 	}

	// 	@Override
	// 	public int hashCode() {
	// 		return 31 * x + y;
	// 	}

	// 	@Override
	// 	public boolean equals(Object obj) {
	// 		if (this == obj) return true;
	// 		if (!(obj instanceof KeyPair)) return false;
	// 		KeyPair keyPair = (KeyPair) obj;
	// 		return keyPair.x == this.x && keyPair.y == this.y;
	// 	}
	// }

	// // KeyPair + HashSet + BFS: 255ms 6.9ms
	// public boolean canMeasureWater(int x, int y, int z) {
	// 	Set<KeyPair> set = new HashSet<>();
	// 	Queue<KeyPair> queue = new LinkedList<>();

	// 	set.add(new KeyPair(0, 0));
	// 	queue.offer(new KeyPair(0, 0));

	// 	while (!queue.isEmpty()) {
	// 		KeyPair jugs = queue.poll();
	// 		if (jugs.x == z || jugs.y == z || jugs.x + jugs.y == z) return true;

	// 		if (jugs.x != 0) {
	// 			KeyPair jugs1 = new KeyPair(0, jugs.y);
	// 			if (!set.contains(jugs1)) {
	// 				queue.offer(jugs1);
	// 				set.add(jugs1);
	// 			}

	// 			if (jugs.y != y) {
	// 				int tmp = jugs.y;
	// 				KeyPair jugs2 = new KeyPair(0, Math.min(jugs.y + jugs.x, y));
	// 				jugs2.x = jugs.x - (jugs2.y - tmp);
	// 				if (!set.contains(jugs2)) {
	// 					queue.offer(jugs2);
	// 					set.add(jugs2);
	// 				}
	// 			}
	// 		}

	// 		if (jugs.y != 0) {
	// 			KeyPair jugs1 = new KeyPair(jugs.x, 0);
	// 			if (!set.contains(jugs1)) {
	// 				queue.offer(jugs1);
	// 				set.add(jugs1);
	// 			}

	// 			if (jugs.x != x) {
	// 				int tmp = jugs.x;
	// 				KeyPair jugs2 = new KeyPair(Math.min(jugs.x + jugs.y, x), 0);
	// 				jugs2.y = jugs.y - (jugs2.x - tmp);
	// 				if (!set.contains(jugs2)) {
	// 					queue.offer(jugs2);
	// 					set.add(jugs2);
	// 				}
	// 			}
	// 		}

	// 		if (jugs.x != x) {
	// 			KeyPair jugs1 = new KeyPair(x, jugs.y);
	// 			if (!set.contains(jugs1)) {
	// 				queue.offer(jugs1);
	// 				set.add(jugs1);
	// 			}
	// 		}

	// 		if (jugs.y != y) {
	// 			KeyPair jugs1 = new KeyPair(jugs.x, y);
	// 			if (!set.contains(jugs1)) {
	// 				queue.offer(jugs1);
	// 				set.add(jugs1);
	// 			}
	// 		}
	// 	}

	// 	return false;
	// }

	// Math solution: z % GCD(a, b) == 0 	0ms 100%
	public boolean canMeasureWater(int x, int y, int z) {
		if (x + y < z) return false;
		if (x == z || y == z || x + y == z) return true;

		return z % GCD(x, y) == 0;
	}

	// 求最大公约数
	private int GCD(int a, int b) {
		while (b != 0) {
			int tmp = b;
			b = a % b;
			a = tmp;
		}

		return a;
	}
}
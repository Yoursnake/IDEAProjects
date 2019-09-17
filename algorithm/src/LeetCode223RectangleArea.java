/*
Find the total area covered by two rectilinear rectangles in a 2D plane.

Each rectangle is defined by its bottom left corner and top right corner as shown in the figure.

Rectangle Area

Example:

Input: A = -3, B = 0, C = 3, D = 4, E = 0, F = -1, G = 9, H = 2
Output: 45

Note:

Assume that the total area is never beyond the maximum possible value of int.
*/

public class LeetCode223RectangleArea {
	// // 分情况讨论: 100%
	// public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
	// 	long wCross, hCross;	// 为了防止越界都是用 long
	// 	if (A <= E) wCross = Math.min(Math.max((long)C - (long)E, 0), (long)G - (long)E);
	// 	else wCross = Math.min(Math.max((long)G - (long)A, 0), (long)C - (long)A);
		
	// 	if (D >= H) hCross = Math.min(Math.max((long)H - (long)B, 0), (long)H - (long)F);
	// 	else hCross = Math.min(Math.max((long)D - (long)F, 0), (long)D - (long)B);
		
	// 	long area1 = (D - B) * (C - A);
	// 	long area2 = (H - F) * (G - E);

	// 	return (int)(area1 + area2 - wCross * hCross);
	// }

	// 100%
	public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
		long wCross, hCross;
		wCross = (long)Math.min(C, G) - (long)Math.max(A, E);
		hCross = (long)Math.min(D, H) - (long)Math.max(B, F);

		long area1 = (D - B) * (C - A);
		long area2 = (H - F) * (G - E);

		return (int)(area1 + area2 - Math.max(wCross, 0) * Math.max(hCross, 0));
	}
}
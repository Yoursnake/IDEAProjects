/*
According to the Wikipedia's article: "The Game of Life, also known 
simply as Life, is a cellular automaton devised by the British 
mathematician John Horton Conway in 1970."

Given a board with m by n cells, each cell has an initial state 
live (1) or dead (0). Each cell interacts with its eight neighbors 
(horizontal, vertical, diagonal) using the following four rules 
(taken from the above Wikipedia article):

Any live cell with fewer than two live neighbors dies, as if caused by under-population.
Any live cell with two or three live neighbors lives on to the next generation.
Any live cell with more than three live neighbors dies, as if by over-population..
Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.

Write a function to compute the next state (after one update) of the board given its current state. The next state is created by applying the above rules simultaneously to every cell in the current state, where births and deaths occur simultaneously.

Example:

Input: 
[
  [0,1,0],
  [0,0,1],
  [1,1,1],
  [0,0,0]
]
Output: 
[
  [0,0,0],
  [1,0,1],
  [0,1,1],
  [0,1,0]
]

Follow up:

Could you solve it in-place? Remember that the board needs to be 
updated at the same time: You cannot update some cells first and 
then use their updated values to update other cells.

In this question, we represent the board using a 2D array. In 
principle, the board is infinite, which would cause problems when 
the active area encroaches the border of the array. How would you 
address these problems?
*/

public class LeetCode289GameofLife {
	// 100% 0ms
	public void gameOfLife(int[][] board) {
		if (board.length == 0 || board[0].length == 0) return;

		int row = board.length, col = board[0].length;
		int[] pre = new int[col];	// 用于保存上一行的状态
		int[] tmp1 = new int[col];	// 保存 pre 的中间数组
		int[] tmp2 = new int[col];	// 保存 board[i] 的中间数组

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				tmp1[j] = board[i][j];
				int count = countLive(board, i, j, pre);

				if (board[i][j] == 1) {
					if (count < 2 || count > 3) tmp2[j] = 0;
					else tmp2[j] = 1;
				} else {
					if (count == 3) temp2[j] = 1;
					else tmp2[j] = 0;
				}
			}

			System.arraycopy(tmp1, 0, pre, 0, col);
			System.arraycopy(tmp2, 0, board[i], 0, col);
		}
	}

	private int countLive(int[][] board, int x, int y, int[] pre) {
		int count = 0;

		for (int i = y - 1; i <= y + 1; i++) {
			if (i < 0 || i >= pre.length) continue;
			count += pre[i];
		}

		for (int i = x; i <= x + 1; i++) {
			for (int j = y - 1; j <= y + 1; j++) {
				if (i == x && j == y) continue;
				count += getValue(board, i, j);
			}
		}

		return count;
	}

	private int getValue(int[][] board, int x, int y) {
		int row = board.length, col = board[0].length;

		if (x < 0 || x >= row || y < 0 || y >= col) return 0;
		else return board[x][y];
	}
}
/*
Given a 2D board containing 'X' and 'O' (the letter O), capture all regions
surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.

Example:

X X X X
X O O X
X X O X
X O X X
After running your function, the board should be:

X X X X
X X X X
X X X X
X O X X
Explanation:

Surrounded regions shouldn’t be on the border, which means that any 'O'
on the border of the board are not flipped to 'X'. Any 'O' that is not
on the border and it is not connected to an 'O' on the border will be
flipped to 'X'. Two cells are connected if they are adjacent cells connected
horizontally or vertically.
 */

public class LeetCode130SurroundedRegions {
//    public void solve(char[][] board) {
//        if (board.length == 0) return;
//        if (board.length == 1 || board[0].length == 1) return;
//
//        int h = board.length;
//        int w = board[0].length;
//        boolean[][] visited = new boolean[h][w];
//
//        for (int i = 1; i < h - 1; i++) {
//            for (int j = 1; j < w - 1; j++) {
//                if (visited[i][j]) continue;    // 访问过的不再访问
//
//                if (board[i][j] == 'O') {
//                    // 找到当前点对应的连通区域
//                    ArrayList<int[]> pos = new ArrayList<>();
//                    Travel(board, visited, i, j, pos);
//
//                    // 判断连通区域中是否存在边界元素
//                    boolean flag = true;
//                    for (int[] p : pos) {
//                        if (p[0] == 0 || p[0] == h - 1 || p[1] == 0 || p[1] == w - 1) {
//                            flag = false;
//                            break;
//                        }
//                    }
//
//                    // 如果不存在边界元素，将所有连通的 'O' 转变为 'X'
//                    if (flag)
//                        for (int[] p : pos)
//                            board[p[0]][p[1]] = 'X';
//                }
//            }
//        }
//    }
//
//    // 找连通区域，存储在 pos 中
//    public void Travel(char[][] board, boolean[][] visited, int x, int y, ArrayList<int[]> pos) {
//        int h = board.length;
//        int w = board[0].length;
//
//        if (x < 0 || x >= h || y < 0 || y >= w) return; // 排除越界情况
//        if (board[x][y] == 'X') return;     // 排除非 'O' 情况
//        if (visited[x][y]) return;          // 排除已访问的情况
//
//        pos.add(new int[]{x, y});
//        visited[x][y] = true;
//
//        Travel(board, visited, x + 1, y, pos);
//        Travel(board, visited, x - 1, y, pos);
//        Travel(board, visited, x, y + 1, pos);
//        Travel(board, visited, x, y - 1, pos);
//    }

    // 改进 DFS
    public void solve(char[][] board) {
        if (board.length == 0) return;
        if (board.length == 1 || board[0].length == 1) return;

        boolean[][] boards = new boolean[board.length][board[0].length];

        // 下面两个 for 是将与所有边界连通的 'O' 标记为 true
        for (int i = 0; i < board.length; i++) {
            Travel(board, i, 0, boards);
            Travel(board, i, board[0].length - 1, boards);
        }

        for (int i = 0; i < board[0].length; i++) {
            Travel(board, 0, i, boards);
            Travel(board, board.length - 1, i, boards);
        }

        // 只对为标记的 'O' 转变为 'X'
        for (int i = 1; i < board.length - 1; i++) {
            for (int j = 0; j < board[0].length - 1; j++) {
                if (!boards[i][j] && board[i][j] == 'O') board[i][j] = 'X';
            }
        }
    }

    // 将所有边界连通的 'O' 都标记为 true，放入 boards
    private void Travel(char[][] board, int x, int y, boolean[][] boards) {
        if (x < 0 || y < 0 || x >= board.length || y >= board[0].length
                || board[x][y] == 'X' || boards[x][y]) return;

        boards[x][y] = true;

        Travel(board, x - 1, y, boards);
        Travel(board, x + 1, y, boards);
        Travel(board, x, y - 1, boards);
        Travel(board, x, y + 1, boards);
    }
}

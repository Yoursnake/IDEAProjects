package second;

public class test {
    public static void main(String[] args) {

        int[][] M = {{0, 1, 0}, {0, 0, 1}, {1, 0, 0}};
        int[][] M2 = Second.matrixMultiple(M, M);
        int[][] M3 = Second.matrixMultiple(M2, M);
        int[][] M4 = Second.matrixMultiple(M3, M);

        Second.printMatrix(M4);
    }
}

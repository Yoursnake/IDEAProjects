package forth;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Forth {

    public static void main(String[] args) {
        int n;  // 结点数
//        n = 4;
//        matrix[0][2] = 1; matrix[2][0] = 1;
//        matrix[1][2] = 1; matrix[2][1] = 1;
//        matrix[0][1] = 1; matrix[1][0] = 1;
//        matrix[1][3] = 1; matrix[3][1] = 1;

        ArrayList<Stack<Integer>> arrayStacks = new ArrayList<>();  // 存储所有的欧拉路

        // 输入部分
        Scanner input = new Scanner(System.in);
        System.out.print("请输入结点数：");
        String strN = input.nextLine();
        n = Integer.parseInt(strN);
        String strInput;
        int[][] matrix = new int[n][n];

        System.out.println("请输入相连的结点，以空号间隔，以\"#\"结束");
        while (true) {
            strInput = input.nextLine();
            if (strInput.equals("#")) {
                break;
            }

            String[] strElements = strInput.split(" ");
            int temp1 = Integer.parseInt(strElements[0]);
            int temp2 = Integer.parseInt(strElements[1]);

            matrix[temp1 - 1][temp2 - 1] = 1;
            matrix[temp2 - 1][temp1 - 1] = 1;

        }

        // 打印邻接矩阵
        System.out.println("邻接矩阵为：");
        printMatrix(matrix);

        System.out.println();
        int type = judgeEulerGraph(matrix);

        if (type == 0) {        // 欧拉图
            for (int i = 0; i < n; i++) {
                int[][] tempMatrix = copyMatrix(matrix);
                if (judgeEdge(tempMatrix, i)) {
                    Stack<Integer> finalStack = new Stack<>();
                    eulerRoad(tempMatrix, i, finalStack);
                    arrayStacks.add(finalStack);
                }
            }

            System.out.println();
            System.out.println("欧拉回路为：");
            for (int i = 0; i < arrayStacks.size(); i++) {
                Stack<Integer> finalStack = arrayStacks.get(i);
                while (!finalStack.empty()) {
                    System.out.print(finalStack.pop()+1 + "\t");
                }
                System.out.println();
            }
        } else if (type == 1) {        // 半欧拉图
            int[] oddPoint = findOddPoint(matrix);
            int[][] tempMatrix1 = copyMatrix(matrix);
            int[][] tempMatrix2 = copyMatrix(matrix);
            Stack<Integer> finalStack1 = new Stack<>();
            Stack<Integer> finalStack2 = new Stack<>();
            semiEulerRoad(tempMatrix1, oddPoint[0], oddPoint[1], finalStack1);
            semiEulerRoad(tempMatrix2, oddPoint[1], oddPoint[0], finalStack2);
            arrayStacks.add(finalStack1);
            arrayStacks.add(finalStack2);

            System.out.println();
            System.out.println("欧拉路为：");
            for (int i = 0; i < 2; i++) {
                Stack<Integer> finalStack = arrayStacks.get(i);
                while (!finalStack.empty()) {
                    System.out.print(finalStack.pop()+1 + "\t");
                }
                System.out.println();
            }
        }

    }

    static int[][] copyMatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] result = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                result[i][j] = matrix[i][j];
            }
        }
        return result;
    }

    // 打印邻接矩阵
    static void printMatrix(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }

    // 找到度为奇数的两个点
    static int[] findOddPoint(int[][] matrix) {
        int n = matrix.length;
        int[] oddPoint = new int[2];
        int[] degree = new int[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    degree[i]++;
                }
            }

            if (degree[i] % 2 != 0) {
                oddPoint[count] = i;
                count++;
            }
        }

        return oddPoint;
    }

    static int judgeEulerGraph(int[][] matrix) {
        int numOddDegree = 0;
        int n = matrix.length;
        int[] degree = new int[n];      // 记录每个结点的度

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    degree[i]++;
                }
            }

            // 判断结点是否为奇数度
            if (degree[i] % 2 != 0) {
                numOddDegree++;
            }
        }

        if (numOddDegree == 0) {
            System.out.println("该图为欧拉图");
            return 0;
        } else if (numOddDegree == 2) {
            System.out.println("该图为半欧拉图");
            return 1;
        } else {
            System.out.println("该图既不是欧拉图也不是半欧拉图");
            return 2;
        }
    }

    static void eulerRoad(int[][] matrix, int start, Stack<Integer> finalStack) {
        int nowPoint = start;
        int n = matrix.length;
        Stack<Integer> nowStack = new Stack<>();
        nowStack.push(nowPoint);

        while (true) {
            for (int i = 0; i < n; i++) {
                if (matrix[nowPoint][i] == 0) {
                    continue;
                } else {
                    matrix[nowPoint][i] = 0;
                    matrix[i][nowPoint] = 0;
                    nowPoint = i;
                    nowStack.push(nowPoint);
                    break;
                }
            }

            if (nowPoint == start) {
                break;
            }
        }

        while (!nowStack.empty()) {
            int pop = nowStack.pop();
            if (!judgeEdge(matrix, pop)) {  // 如果栈顶的元素无边则直接入 finalStack
                finalStack.push(pop);
            } else {                        // 如果栈顶的元素有边则继续搜索剩余边
                eulerRoad(matrix, pop, finalStack);
            }
        }
    }

    static void semiEulerRoad(int[][] matrix, int start, int end, Stack<Integer> finalStack) {
        int nowPoint = start;
        int n = matrix.length;
        Stack<Integer> nowStack = new Stack<>();
        nowStack.push(nowPoint);

        while (true) {
            for (int i = 0; i < n; i++) {
                if (matrix[nowPoint][i] == 0) {
                    continue;
                } else {
                    matrix[nowPoint][i] = 0;
                    matrix[i][nowPoint] = 0;
                    nowPoint = i;
                    nowStack.push(nowPoint);
                    break;
                }
            }

            if (nowPoint == end) {
                break;
            }
        }

        while (!nowStack.empty()) {
            int pop = nowStack.pop();
            if (!judgeEdge(matrix, pop)) {  // 如果栈顶的元素无边则直接入 finalStack
                finalStack.push(pop);
            } else {                        // 如果栈顶的元素有边则继续搜索剩余边
                eulerRoad(matrix, pop, finalStack);
            }
        }

    }

    // 判断当前结点是否有边
    static boolean judgeEdge(int[][] matrix, int nowPoint) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            if (matrix[nowPoint][i] == 1) {
                return true;
            }
        }

        return false;
    }
}

package second;

import java.util.Scanner;

public class Second {

    // 自反性
    public static boolean isReflex(int[][] a) {
        int length = a.length;

        for (int i = 0; i < length; i++) {
            if (a[i][i] == 0) {
                return false;
            }
        }

        return true;
    }

    // 反自反性
    public static boolean isAntiReflex(int[][] a) {
        int length = a.length;

        for (int i = 0; i < length; i++) {
            if (a[i][i] == 1) {
                return false;
            }
        }

        return true;
    }

    // 对称性
    public static boolean isSymmetry(int[][] a) {
        int length = a.length;

        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (a[i][j] != a[j][i]) {
                    return false;
                }
            }
        }

        return true;
    }

    // 反对称性
    public static boolean isAntiSymmetry(int[][] a) {
        int length = a.length;

        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (a[i][j] == 1 && a[j][i] == 1) {
                    return false;
                }
            }
        }

        return true;
    }

    // 使用 warshall 算法计算传递闭包，然后比较传递闭包和关系矩阵
    public static boolean isTransitive(int[][] a) {
        int length = a.length;
        int[][] temp = new int[a.length][a[0].length];

        // 将 a 的值复制给 temp
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                temp[i][j] = a[i][j];
            }
        }

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (temp[j][i] == 1) {
                    for (int k = 0; k < length; k++) {
                        temp[j][k] = temp[j][k] | temp[i][k];
                    }
                }
            }
        }

        return isEqual(a, temp);
    }

    // 直接用三重循环
    public static boolean isTransitive2(int[][] a) {
        int length = a.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                for (int k = 0; k < length; k++) {
                    if (a[i][k] == 1 && a[k][j] == 1) {
                        if (a[i][j] != 1) {
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }

    // 使用矩阵运算计算传递性
    public static boolean isTransitive3(int[][] a) {
        int length = a.length;
        int[][] aPlus = new int[a.length][a[0].length];
        int[][] temp = new int[a.length][a[0].length];  // 每次矩阵乘法运算后保留的结果

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                temp[i][j] = a[i][j];
            }
        }

        for (int i = 0; i < length; i++) {
            aPlus = matrixPlus(aPlus, temp);
            temp = matrixMultiple(a, a);
        }

        return isEqual(aPlus, a);
    }

    /*
    矩阵逻辑乘
    输入：a,b 均为二维数组
     */
    public static int[][] matrixMultiple(int[][] a, int[][] b) {
        int[][] result = new int[a.length][b[0].length];

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                for (int k = 0; k < b.length; k++) {
                    result[i][j] = result[i][j] | (a[i][k] & b[k][j]);  // 逻辑加和逻辑乘
                }
            }
        }

        return result;
    }

    /*
    矩阵逻辑加
    输入：a,b 均为二维数组
     */
    public static int[][] matrixPlus(int[][] a, int[][] b) {
        int[][] result = new int[a.length][a[0].length];

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                result[i][j] = a[i][j] | b[i][j];
            }
        }

        return result;
    }

    /*
    判断两个矩阵是否一致
    输入：a,b 均为二维数组
     */
    public static boolean isEqual(int[][] a, int[][] b) {
        int rowLength = a.length;
        int columnLength = a[0].length;

        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < columnLength; j++) {
                if (a[i][j] != b[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }

    /*
    打印矩阵
     */
    public static void printMatrix(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String temp;
        System.out.print("请输入元素个数：");
        temp = input.nextLine();
        int num = Integer.parseInt(temp);   // 元素数
        int[][] matrix = new int[num][num];

        System.out.println("请输入序偶对（以空格分隔，结束输入#）");
        int a1, a2;
        while (true) {
            temp = input.nextLine();
            if (temp.equals("#"))
                break;

            String[] strElements = temp.split(" ");
            a1 = Integer.parseInt(strElements[0]);
            a2 = Integer.parseInt(strElements[1]);

            if (a1 < 1 || a1 > num || a2 < 1 || a2 > num) {
                System.out.println("输入序偶不符合规则，请重新输入");
                continue;
            } else {
                matrix[a1 - 1][a2 - 1] = 1;
            }
        }

        System.out.println("关系矩阵为：");
        printMatrix(matrix);
        System.out.println("自反性：" + isReflex(matrix));
        System.out.println("反自反性：" + isAntiReflex(matrix));
        System.out.println("对称性：" + isSymmetry(matrix));
        System.out.println("反对称性：" + isAntiSymmetry(matrix));
        System.out.println("传递性：" + isTransitive(matrix));
    }

}

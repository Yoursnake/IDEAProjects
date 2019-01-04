package third;

import java.util.*;

public class Third {

    public static void main(String[] args) {
        int n;
//        int[] A = {1, 2, 3, 4, 6, 12};
//        int[] A = {1, 2, 3, 6, 9, 18};
//        int[] A = {1, 2, 3, 4, 9, 36};

        int[] A;
        ArrayList<int[]> cover; // 所有的覆盖关系
        Scanner input = new Scanner(System.in);

        // 输入元素
        System.out.print("集合 A 元素个数为：");
        String strN = input.nextLine();
        n = Integer.parseInt(strN);
        A = new int[n];

        System.out.println("请输入元素个数，以空格间隔");
        String strInput = input.nextLine();
        String[] strElements = strInput.split(" ");

        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(strElements[i]);
        }

        Arrays.sort(A);
        cover = findCover(A);

        // 输出所有覆盖关系
        System.out.println("所有的覆盖关系为：");
        for (int i = 0; i < cover.size(); i++) {
            System.out.println(Arrays.toString(cover.get(i)));
        }

        System.out.println();

        ArrayList<ArrayList<Integer>> eleDowns;
        ArrayList<ArrayList<Integer>> eleUps;
        eleDowns = findEleDowns(A, cover);
        eleUps = findEleUps(A,cover);

        boolean isGe;
        isGe = judgeGe(A, eleDowns, eleUps);
        System.out.println("是否为格：" + isGe);

        boolean isBound;
        isBound = judgeBound(A, eleDowns, eleUps);
        System.out.println("是否为有界格：" + isBound);

        boolean isComplement = judgeComplement(A, eleDowns, eleUps, isBound);
        System.out.println("是否为有补格：" + isComplement);
    }

    /* 判断是否为有补格
    input
    A : 元素集合
    eleDowns : 所有元素的下偏序元素集合
    eleUps : 所有元素的上偏序元素集合
    output
    isComplement : 是否为有补格
     */
    private static boolean judgeComplement(int[] A, ArrayList<ArrayList<Integer>> eleDowns,
                                           ArrayList<ArrayList<Integer>> eleUps, boolean isBound) {
        boolean[] hasComplement = new boolean[A.length];
        // 判断是否为有补格：任意两个元素都为补元
        for (int i = 0; i < hasComplement.length; i++) {
            hasComplement[i] = false;
        }

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length; j++) {
                int min = A[0];        // 集合最小值
                int max = A[A.length - 1]; // 集合最大值

                // 找下确界
                ArrayList firstDown = eleDowns.get(i);
                ArrayList secondDown = eleDowns.get(j);
                int infimum = findInfimum(firstDown, secondDown);

                // 找上确界
                ArrayList firstUp = eleUps.get(i);
                ArrayList secondUp = eleUps.get(j);
                int supremum = findSupremum(firstUp, secondUp);

                // 只要下确界不等于最小值或者上确界不等于最大值就不是有补格
                if (infimum == min && supremum == max) {
                    hasComplement[i] = true;
                }
            }
        }

        boolean isComplement = true;
        // 每个元素都有补元则为有补格
        for (int i = 0; i < hasComplement.length; i++) {
            if (!hasComplement[i]) {
                isComplement = false;
            }
        }

        // 如果不是有界格则不是有补格
        if (!isBound) {
            isComplement = false;
        }
        return isComplement;
    }

    /* 判断是否为有界格
    input
    A : 元素集合
    eleDowns : 所有元素的下偏序元素集合
    eleUps : 所有元素的上偏序元素集合
    output
    isBound : 是否为有界格
     */
    private static boolean judgeBound(int[] A, ArrayList<ArrayList<Integer>> eleDowns,
                                      ArrayList<ArrayList<Integer>> eleUps) {
        boolean isBound = true;
        for (int i = 0; i < A.length; i++) {
            // 只要有一个元素不在最大值的下偏序集合中就不是有界格
            // 只要有一个元素不在最小值的上偏序集合中就不是有界格
            if (!eleDowns.get(eleDowns.size() - 1).contains(A[i])
                    || !eleUps.get(0).contains(A[i])) {
                isBound = false;
            }
        }
        return isBound;
    }

    /* 判断是否为格
    input
    A : 元素集合
    eleDowns : 所有元素的下偏序元素集合
    eleUps : 所有元素的上偏序元素集合
    output
    isGe : 是否为格
     */
    private static boolean judgeGe(int[] a, ArrayList<ArrayList<Integer>> eleDowns,
                                   ArrayList<ArrayList<Integer>> eleUps) {
        boolean isGe = true;
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                // 判断是否两个集合下偏序集合有交集
                ArrayList firstDown = eleDowns.get(i);
                ArrayList secondDown = eleDowns.get(j);
                boolean hasDown = false;

                for (int k = 0; k < firstDown.size(); k++) {
                    if (secondDown.contains(firstDown.get(k))) {
                        hasDown = true;
                        break;
                    }
                }

                // 判断是否两个集合上偏序集合有交集
                ArrayList firstUp = eleUps.get(i);
                ArrayList secondUp = eleUps.get(j);
                boolean hasUp = false;

                for (int k = 0; k < firstUp.size(); k++) {
                    if (secondUp.contains(firstUp.get(k))) {
                        hasUp = true;
                        break;
                    }
                }

                // 任意两元素的不存在上下确界则不是格
                if (!hasDown || !hasUp) {
                    isGe = false;
                }
            }
        }
        return isGe;
    }

    /* 找上偏序元素集合
    input
    A : 元素集合
    cover : 所有覆盖关系
    output
    eleUps : 所有元素的上偏序元素集合
     */
    private static ArrayList<ArrayList<Integer>> findEleUps(int[] A, ArrayList<int[]> cover) {
        ArrayList<ArrayList<Integer>> eleUps = new ArrayList<>();

        // 计算所有元素的被偏序的元素
        for (int i = 0; i < A.length; i++) {

            ArrayList<Integer> tempUp = new ArrayList<>();
            tempUp.add(A[i]);
            Queue<Integer> queueUp = new LinkedList<>();
            queueUp.offer(A[i]);

            // 通过队列进行广度优先搜索，找到所有上偏序元素
            while (!queueUp.isEmpty()) {
                int peek = queueUp.poll();
                for (int j = 0; j < cover.size(); j++) {
                    // 如果该元素有上偏序元素 && 改元素的上偏序元素不在已经记录的元素中
                    if (peek == cover.get(j)[0] && !tempUp.contains(cover.get(j)[1])) {
                        queueUp.offer(cover.get(j)[1]);
                        tempUp.add(cover.get(j)[1]);
                    }
                }
            }

            Collections.sort(tempUp);
            eleUps.add(tempUp);
        }
        return eleUps;
    }

    /* 找下偏序元素集合
    input
    A : 元素集合
    cover : 所有覆盖关系
    output
    eleDowns : 所有元素的下偏序元素集合
     */
    private static ArrayList<ArrayList<Integer>> findEleDowns(int[] A, ArrayList<int[]> cover) {
        ArrayList<ArrayList<Integer>> eleDowns = new ArrayList<>();
        // 计算所有元素的被偏序的元素
        for (int i = 0; i < A.length; i++) {
            ArrayList<Integer> tempDown = new ArrayList<>();
            tempDown.add(A[i]);
            Queue<Integer> queueDown = new LinkedList<>();
            queueDown.offer(A[i]);

            // 通过队列进行广度优先搜索，找到所有下偏序元素
            while (!queueDown.isEmpty()) {
                int peek = queueDown.poll();
                for (int j = 0; j < cover.size(); j++) {
                    // 如果该元素有下偏序元素 && 改元素的下偏序元素不在已经记录的元素中
                    if (peek == cover.get(j)[1] && !tempDown.contains(cover.get(j)[0])) {
                        queueDown.offer(cover.get(j)[0]);
                        tempDown.add(cover.get(j)[0]);
                    }
                }
            }

            Collections.sort(tempDown);
            eleDowns.add(tempDown);
        }

        return eleDowns;
    }


    /* 找到上确界
    input
    firstUp : 第一个元素对应的上偏序元素集合
    secondUp : 第二个元素对应的上偏序元素集合
    output
    infimum : 上确界值
     */
    private static int findSupremum(ArrayList<Integer> firstUp, ArrayList<Integer> secondUp) {
        int flag1 = 0;
        int flag2 = 0;
        int supremum;

        while (flag1 < firstUp.size() && flag2 < secondUp.size()) {
            if (firstUp.get(flag1) == secondUp.get(flag2)) {
                supremum = firstUp.get(flag1);
                return supremum;
            } else if (firstUp.get(flag1) < secondUp.get(flag2)) {
                flag1++;
            } else {
                flag2++;
            }
        }

        return -1;  // 如果无上确界返回-1
    }

    /* 找到下确界
    input
    firstDown : 第一个元素对应的下偏序元素集合
    secondDown : 第二个元素对应的下偏序元素集合
    output
    infimum : 下确界值
     */
    private static int findInfimum(ArrayList<Integer> firstDown, ArrayList<Integer> secondDown) {
        int flag1 = firstDown.size() - 1;
        int flag2 = secondDown.size() - 1;
        int infimum;

        while (flag1 >= 0 && flag2 >= 0) {
            if (firstDown.get(flag1) == secondDown.get(flag2)) {
                infimum = firstDown.get(flag1);
                return infimum;
            } else if (firstDown.get(flag1) > secondDown.get(flag2)) {
                flag1--;
            } else {
                flag2--;
            }
        }

        return -1;  // 如果无下确界返回-1
    }

    /* 找出所有的覆盖关系
    input
    A : 元素集合
    output
    cover : 所有覆盖关系
     */
    private static ArrayList<int[]> findCover(int[] A) {
        ArrayList<int[]> cover = new ArrayList<>(); // 所有的覆盖关系

        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {
                boolean isCover = false;    // 判断是否覆盖

                // 满足整除关系
                if (A[j] % A[i] == 0) {
                    isCover = true;
                }

                // 中间如果有第三者则不是覆盖关系
                for (int k = i + 1; k <= j - 1; k++) {
                    if (A[j] % A[k] == 0 && A[k] % A[i] == 0) {
                        isCover = false;
                        break;
                    }
                }

                // 如果满足覆盖则添加到动态数组
                if (isCover) {
                    int[] temp = {A[i], A[j]};    // 将要添加的覆盖关系
                    cover.add(temp);
                }
            }
        }

        return cover;
    }
}

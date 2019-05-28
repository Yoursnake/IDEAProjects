/**
 * Created by shengliyi on 2017/3/4.
 */

public class Main {
//-2147483648
    public static void main(String[] args) {

//        List<List<Integer>> triangle = new ArrayList<List<Integer>>() {{
//            add(new ArrayList<>(Arrays.asList(2)));
//            add(new ArrayList<>(Arrays.asList(3, 4)));
//            add(new ArrayList<>(Arrays.asList(6, 5, 7)));
//            add(new ArrayList<>(Arrays.asList(4, 1, 8, 3)));
//        }};

//        int result = new LeetCode120Triangle().minimumTotal(triangle);

        int[] a = {7, 1, 5, 3, 6, 4};
        int[] b = {1,2,3,4,5};
        int result = new LeetCode122BestTime2BuyAndSellStockII().maxProfit(b);
        System.out.println(result);
    }

}

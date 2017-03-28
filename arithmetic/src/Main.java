import java.util.List;

/**
 * Created by shengliyi on 2017/3/4.
 */
public class Main {
    static List<List<Integer>> res;


    public static void main(String[] args) {

        String a = "111";
        String b = "000011112124";
        System.out.println(Multiply.multiply(a, b));
    }

    public static void Change(String a, String  b) {
        StringBuilder tempA = new StringBuilder("2");
        StringBuilder tempB = new StringBuilder("1");
        a = tempA.toString();
        b = tempB.toString();
    }

}

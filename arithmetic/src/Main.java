import java.util.ArrayList;
import java.util.Comparator;

/**
 * Created by shengliyi on 2017/3/4.
 */

public class Main {

    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(1);
        list.add(3);


        list.sort(Comparator.naturalOrder());
        System.out.println(list);
    }
}

/**
 * Created by shengliyi on 2017/3/14.
 */
public class Reserve {
    public static int reverse(int x) {
        int res = 0;
        double dtemp = 0;
        if (x > Math.pow(2,31)-1 || x <= -Math.pow(2,31)) return 0;
        if (x > 0) {
            int count = 0;
            int temp = x;
            while (temp != 0) {
                temp = temp/10;
                count++;
            }
            while (count != 0) {
                int d = x%10;
                x = x/10;
                dtemp += d*Math.pow(10,count-1);
                if (dtemp > Math.pow(2,31)-1 || dtemp < -Math.pow(2,31)) return 0;
                res += d*Math.pow(10,count-1);
                count--;
            }
        } else if (x == 0) res = 0;
        else {
            res = -reverse(-x);
        }
        return res;
    }
}

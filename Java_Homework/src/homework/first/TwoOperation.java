package homework.first;

public class TwoOperation {
    public static int gcd(int num1, int num2) {
        int r = num1 % num2;
        while (r != 0) {
            num1 = num2;
            num2 = r;
            r = num1 % num2;
        }
        int GCD = num2;
        return GCD;
    }

    public static int lcm(int num1, int num2) {
        int GCD = gcd(num1, num2);
        int LCM = num1 * num2 / GCD;
        return LCM;
    }

    public static void main(String[] args) {
        int num1, num2, GCD, LCM;
        num1 = 858;
        num2 = 864;

        GCD = gcd(num1, num2);
        LCM = lcm(num1, num2);
        System.out.println("最大公约数：" + GCD);
        System.out.println("最小公倍数：" + LCM);
    }
}

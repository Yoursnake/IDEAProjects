package forth;

import java.util.Stack;

public class test {
    public static void main(String[] args) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2;

        s1.push(1);
        s1.push(2);
        s2 = (Stack<Integer>) s1.clone();

        s2.push(1);

        while (!s2.empty()) {
            System.out.print(s2.pop() + "\t");
        }
    }
}

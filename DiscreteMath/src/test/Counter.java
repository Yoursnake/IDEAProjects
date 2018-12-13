//package first;
//
//import java.util.Stack;
//
//public class Counter {
//    public static void main(String[] args) {
//        String mid = "1+5/4/2";
//        String post = MidToPost.midToPost(mid);
//        Stack<Double> stack = new Stack<>();
//
//        char[] postChar = post.toCharArray();
//        for (int i = 0; i < postChar.length; i++) {
//            if (postChar[i] >= '0' && postChar[i] <= '9') {
//                double temp = postChar[i] - '0';
//                stack.push(temp);
//            } else if (postChar[i] == '+' || postChar[i] == '-' ||
//                    postChar[i] == '*' || postChar[i] == '/') {
//                double num2 = stack.pop();
//                double num1 = stack.pop();
//                double result = calculate(num1, num2, postChar[i]);
//                stack.push(result);
//            }
//        }
//
//        System.out.println(post);
//        System.out.println(stack.pop());
//    }
//
//    static double calculate(double num1, double num2, char symbol) {
//        double result = 0;
//
//        switch (symbol) {
//            case '+':
//                result = num1 + num2;break;
//            case '-':
//                result = num1 - num2;break;
//            case '*':
//                result = num1 * num2;break;
//            case '/':
//                result = num1 / num2;break;
//            default:
//                break;
//        }
//
//        return result;
//    }
//}

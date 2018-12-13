package test;

import first.test;

import java.util.Stack;

public class MidToPost {

    public static String[] midToPost(String strInput) {
        char[] midChars = strInput.toCharArray();
        String[] postStrings = new String[midChars.length];

        Stack<Character> stack = new Stack<>();

        int count = 0;
        for (int i = 0; i < midChars.length; i++) {
            if (midChars[i] >= '0' && midChars[i] <= '9') {
                String temp = "";
                do {
                    temp += midChars[i];    // 如果是数字则添加至数字字符串
                    i++;
                } while (i != midChars.length && !isSymbol(midChars[i]));
                postStrings[count++] = temp;

                if (i == midChars.length)
                    break;
            }

            if (isSymbol(midChars[i])) {

                if (stack.empty()) {
                    stack.push(midChars[i]);
                } else {
                    int stackPriority = priority(stack.peek());
                    int currentPriority = priority(midChars[i]);

                    if (stackPriority < currentPriority) {
                        stack.push(midChars[i]);
                    } else {
                        do {
                            char stackPop = stack.pop();
                            postStrings[count++] = String.valueOf(stackPop);
                            if (stack.empty()) {
                                break;
                            }
                            stackPriority = priority((stack.peek()));
                        } while (stackPriority >= currentPriority);
                        stack.push(midChars[i]);
                    }
                }
            }
        }

        while (!stack.empty()) {
            postStrings[count++] = String.valueOf(stack.pop());
        }

        return postStrings;
    }

    private static boolean isSymbol(char c) {
        if (c == '+' || c == '-' ||
                c == '*' || c == '/') {
            return true;
        } else {
            return false;
        }

    }

    private static int priority(char c) {
        switch (c) {
            case '+':
                return 0;
            case '-':
                return 1;
            case '*':
                return 2;
            case '/':
                return 3;
            default:
                return -1;
        }
    }


}

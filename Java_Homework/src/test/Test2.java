package test;

import utility.StringUtility;

import java.io.IOException;

public class Test2 {

    public static void main(String[] args) throws IOException {
        String test = "\\r\\n 0 -0.13 -0.85 0.09 -84   8 -85 \\r\\n";
        String[] S = StringUtility.getNumber(test);
        for (String s:S) {
            System.out.println(s);
        }
    }
}

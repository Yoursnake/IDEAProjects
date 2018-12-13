package test;

public class Main {
    public static void main(String[] args) {
        String input = "1+30/2-5*2";
        String[] output = MidToPost.midToPost(input);

        for (int i = 0; i < output.length; i++) {
            System.out.println(output[i]);
        }
    }


}

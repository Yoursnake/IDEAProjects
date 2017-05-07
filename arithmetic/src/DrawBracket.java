/**
 * Created by shengliyi on 2017/3/30.
 */
public class DrawBracket {

    public void draw(String input) {
        int max = 0;
        int length = input.length();
        for (int i = 0; i < length; i++) {
            int j = 0;
            if (input.charAt(i) == '[') {
                int count = 0;
                for (j = i; input.charAt(j) != ']'; j++) {
                    count++;
                }
                if (max < count)
                    max = count;
            }
            i = j;
        }
    }

}

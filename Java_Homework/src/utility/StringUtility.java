package utility;

public class StringUtility {
    public static String[] getNumber(String input) {
        char[] inputChar = input.toCharArray();
        String output = "";

        for (int i = 0; i < inputChar.length; i++) {
            if (inputChar[i] == '\r' || inputChar[i] == '\n') {
                continue;
            } else if (inputChar[i] == '\\' && inputChar[i+1] == 'r' ||
                    inputChar[i] == '\\' && inputChar[i+1] == 'n') {
                i++;
                continue;
            } else {
                output += inputChar[i];
            }
        }

        inputChar = output.toCharArray();

        int stringCount = 0;
        String[] outputString = new String[7];
        int num = inputChar.length;

        for (int i = 0; i < inputChar.length; i++) {
            if (inputChar[i] == ' ') {
                continue;
            } else {
                String temp = "";
                while (i != inputChar.length && inputChar[i] != ' ') {
                    temp = temp + inputChar[i];
                    i++;
                }
                outputString[stringCount] = temp;
                stringCount++;
            }
        }

        return outputString;
    }
}

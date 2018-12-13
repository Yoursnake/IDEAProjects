package first;


public class First {

    public static void main(String[] args) {
        String strInput = "P&Q|R>M=N";
        String PDNF = "";    // 主析取范式
        String PCNF = "";    // 主合取范式
        int[] truthTable = new int[32];

        String strSymbol = getSymbol(strInput);


        int numVar = 5;     // 变元个数
        int numAs = (int)Math.pow(2, 5);
        int count = 0;
        for (int i = numAs - 1; i >= 0; i--) { // 从全1到全0，即从全T到全F
            int temp = i;               // 通过该值来计算当前赋值
            int[] as = new int[numVar]; // 每个变元的值，0代表False，1代表True

            // 将当前计数从十进制转换为二进制，将每一位二进制数值存储在数组中，从高位向低位赋值
            for (int j = 0; j < as.length; j++) {
                as[as.length - j - 1] = temp % 2;
                temp = temp >> 1;
            }

            truthTable[count] = calculate(strSymbol, as); // 索引从 0 开始计数

            if (truthTable[count] == 1) {
                if (PDNF.equals(""))
                    PDNF = PDNF + minorTerm(as);
                else
                    PDNF = PDNF + "|" + minorTerm(as);
            }
            else {
                if (PCNF.equals(""))
                    PCNF = PCNF + bigTerm(as);
                else
                    PCNF = PCNF + "&" + bigTerm(as);
            }

            count++;
        }

        // 输出
        System.out.println("真值表结果：");
        for (int i = 0; i < truthTable.length; i++) {
            System.out.print(truthTable[i] + " ");
        }
        System.out.println();
        System.out.println("主析取范式：");
        System.out.println(PDNF);
        System.out.println("主合取范式");
        System.out.println(PCNF);

    }

    // 得到所有运算符
    static String getSymbol(String strInput) {
        String result = "";
        char[] charsInput = strInput.toCharArray();
        for (int i = 0; i < charsInput.length; i++) {
            if (charsInput[i] == '&' || charsInput[i] == '|' ||
                    charsInput[i] == '>' || charsInput[i] == '=') {
                result = result + charsInput[i];
            }
        }
        return result;
    }

    /* 计算当前赋值的结果
    strSymbol : 所有运算符按顺序排列
    as : 变量赋值数组
     */
    static int calculate(String strSymbol, int[] as) {
        int result = as[0];
        char[] charsSymbol = strSymbol.toCharArray();

        int count = 1;
        for (int i = 0; i < charsSymbol.length; i++) {
            int temp = as[count];       // 当前运算的数
            switch (charsSymbol[i]) {
                case '&':
                    result = result & temp;
                    break;
                case '|':
                    result = result | temp;
                    break;
                case '>':
                    result = (1^result) | temp;
                    break;
                case '=':
                    if (result == temp)
                        result = 1;
                    else
                        result = 0;
                    break;
            }
            count++;
        }

        return result;
    }

    /* 通过赋值计算小项
    as : 变量赋值数组
     */
    static String minorTerm(int[] as) {
        final char[] letters = {'P', 'Q', 'R', 'M', 'N'};
        String result = "(";

        // 先写第一个字母
        if (as[0] == 0)
            result = result + "!" + letters[0];
        else
            result = result + letters[0];

        for (int i = 1; i < letters.length; i++) {
            result = result + "&";

            // 如果赋值为假则取反
            if (as[i] == 1)
                result = result + letters[i];
            else
                result = result + "!" + letters[i];
        }

        result = result + ")";
        return result;
    }

    /* 通过赋值计算大项
    as : 变量赋值数组
     */
    static String bigTerm(int[] as) {
        final char[] letters = {'P', 'Q', 'R', 'M', 'N'};
        String result = "(";

        if (as[0] == 1)
            result = result + "!" + letters[0];
        else
            result = result + letters[0];

        for (int i = 1; i < letters.length; i++) {
            result = result + "|";

            // 如果赋值为真则取反
            if (as[i] == 0)
                result = result + letters[i];
            else
                result = result + "!" + letters[i];
        }

        result = result + ")";
        return result;
    }

}

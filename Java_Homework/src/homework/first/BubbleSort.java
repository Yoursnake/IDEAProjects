package homework.first;

public class BubbleSort {
    public static void main(String[] args) {
        int[] array = {2, 3, 1, 4, 8, 6, 5, 1, 10, 7};
        System.out.print("排序前：");
        showArray(array);
        System.out.println();
        bubbleSort(array);
        System.out.print("排序后：");
        showArray(array);

    }
    
    public static void bubbleSort(int[] array) {
        int length = array.length;
        for (int i = 0; i < length - 1; i++) {
            for (int j = length - 1; j > i; j--) {
                if (array[j] < array[j - 1]) {
                    int temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                }
            }
        }
    }

    public static void showArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "  ");
        }
    }
}

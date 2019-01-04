import java.util.Arrays;

public class BinarySearch {

    public boolean find(int[] num, int target) {
        int begin = 0;
        int end = num.length;
        Arrays.sort(num);
        boolean isFind = findByBinarySearch(num, begin, end, target);
        return isFind;
    }

    public boolean findByBinarySearch(int[] num, int begin, int end, int target) {
        int mid = (begin + end) / 2;

        if (begin < end) {
            if (num[mid] == target) {
                return true;
            } else if (num[mid] > target) {
                return findByBinarySearch(num, begin, mid - 1, target);
            } else {
                return findByBinarySearch(num, mid + 1, end, target);
            }
        }

        return false;

    }
}
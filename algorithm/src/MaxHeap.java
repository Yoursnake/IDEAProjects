import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxHeap<E extends Comparable<E>> {
    private List<E> data;

    public MaxHeap() {
        this.data = new ArrayList<>();
    }

    public MaxHeap(int capacity) {
        this.data = new ArrayList<>(capacity);
    }

    public MaxHeap(E[] arr) {
        this.data = new ArrayList<>();
        this.data.addAll(Arrays.asList(arr));

        for (int i = this.parent(arr.length - 1); i >= 0; i--) {
            this.siftDown(i);
        }
    }

    private int parent(int k) {
        return (k - 1) / 2;
    }

    private int leftChild(int k) {
        return 2 * k + 1;
    }

    private int rightChild(int k) {
        return 2 * k + 2;
    }

    public void add(E e) {
        this.data.add(e);
        siftUp(this.data.size() - 1);
    }

    private void swap(int i, int j) {
        E tmp = this.data.get(i);
        this.data.set(i, this.data.get(j));
        this.data.set(j, tmp);
    }

    private void siftUp(int k) {
        while (k > 0 && this.data.get(k).compareTo(this.data.get(parent(k))) > 0) {
            this.swap(k, parent(k));
            k = parent(k);
        }
    }

    public E findMax() {
        return this.data.get(0);
    }

    public E extractMax() {
        E max = this.data.get(0);
        E last = this.data.get(this.data.size() - 1);
        this.data.remove(this.data.size() - 1);
        this.data.set(0, last);
        siftDown(0);
        return max;
    }

    private void siftDown(int k) {
        while (this.leftChild(k) < this.data.size()) {
            int j = this.leftChild(k);

            if (j + 1 < this.data.size() &&
                    this.data.get(j + 1).compareTo(this.data.get(j)) > 0)
                j++;

            // data[j] 是 leftChild 和 rightChild 中的最大值
            if (this.data.get(j).compareTo(this.data.get(k)) < 0) break;

            this.swap(j, k);
            k = j;
        }
    }

    public E replace(E e) {
        // 取出堆中的最大元素，并且替换成元素e
        E max = this.data.get(0);
        this.data.set(0, e);
        this.siftDown(0);
        return e;
    }

    public void printHeap() {
        System.out.println(this.data);
    }
}

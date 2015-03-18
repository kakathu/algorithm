/**
 * User: wujian (jianwu203076@sohu-inc.com)
 * Date: 03/17/2015 16:18
 */
//大顶堆
class MaxHeap {
    int[] data;
    public MaxHeap(int[] data) {
        this.data = data;
    }
    public void createHeap() {
        int n = data.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            sift(i, n - 1);
        }
    }
    public void sift(int begin, int end) {
        int temp = data[begin];
        int i = begin;
        int j = 2 * begin + 1;
        boolean finished = false;
        while (j <= end && !finished) {
            if (j < end && data[j] < data[j + 1]) {
                j++;
            }
            if (temp >= data[j]) {
                finished = true;
            } else {
                data[i] = data[j];
                i = j;
                j = 2 * i + 1;
            }
        }
        data[i] = temp;
    }
    public void sort() {
        createHeap();
        int n = data.length;
        for (int i = n - 1; i > 0; i--) {
            int temp = data[0];
            data[0] = data[i];
            data[i] = temp;
            sift(0, i - 1);
        }
    }
}

public class HeapSort {
    public static void main(String[] args) {
        int[] data = {1, 8, 8, 10, 5, 9, 3};
        MaxHeap maxHeap = new MaxHeap(data);
        maxHeap.sort();
        for (int i : data) {
            System.out.print(i + ", ");
        }
        System.out.println();
    }
}

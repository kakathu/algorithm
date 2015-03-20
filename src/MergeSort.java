/**
 * User: wujian (jianwu203076@sohu-inc.com)
 * Date: 03/18/2015 11:37
 */
public class MergeSort {
    public static void merge(int[] data, int low, int mid, int high) {
        int i = low, j = mid + 1, k = 0;
        int[] temp = new int[high - low + 1];
        while (i <= mid && j <= high) {
            if (data[i] < data[j]) {
                temp[k] = data[i++];
            } else {
                temp[k] = data[j++];
            }
            k++;
        }
        while (i <= mid) {
            temp[k++] = data[i++];
        }
        while (j <= high) {
            temp[k++] = data[j++];
        }
        for (int k2 = 0; k2 < temp.length; k2++) {
            data[k2 + low] = temp[k2];
        }
    }

    public static void recursive_sort(int[] data, int low, int high) {
        int mid = (low + high) / 2;
        if (low < high) {
            recursive_sort(data, low, mid);
            recursive_sort(data, mid + 1, high);
            merge(data, low, mid, high);
        }
    }

    public static void sort(int[] data) {
        if (data == null || data.length <= 1) {
            return;
        }
        int n = data.length;
        int low, high, mid;
        for (int size = 1; size <= n - 1; size *= 2) {
            low = 0;
            while (low + size <= n - 1) {
                mid = low + size - 1;
                high = mid + size;
                if (high > n - 1) {
                    high = n - 1;
                }
                merge(data, low, mid, high);
                low = high + 1;
            }
        }
    }

    public static void main(String[] args) {
        int[] data = {5, 6, 8, 8, 2, 2, 1, 0};
        //recursive_sort(data, 0, data.length - 1);
        sort(data);
        for (int i : data) {
            System.out.print(i + ", ");
        }
        System.out.println();
    }
}

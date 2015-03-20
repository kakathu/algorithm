/**
 * User: wujian (jianwu203076@sohu-inc.com)
 * Date: 03/16/2015 15:49
 */
public class QuickSort {
    public static void sort(int[] data) {
        if (data == null || data.length <= 1) {
            return;
        }
        quickSort(data, 0, data.length - 1);
    }

    public static int partition(int[] data, int low, int high) {
        int key = data[low];
        while (low < high) {
            while (low < high && data[high] >= key) {
                high--;
            }
            if (low < high) {
                data[low++] = data[high];
            }
            while (low < high && data[low] <= key) {
                low++;
            }
            if (low < high) {
                data[high--] = data[low];
            }
        }
        data[low] = key;
        return low;
    }

    public static void quickSort(int[] data, int low, int high) {
        if (low < high) {
            int mid = partition(data, low, high);
            quickSort(data, low, mid - 1);
            quickSort(data, mid + 1, high);
        }
    }

    public static void main(String[] args) {
        int[] data = {5, 6, 8, 8, 2, 2, 1, 0};
        sort(data);
        for (int i : data) {
            System.out.print(i + ", ");
        }
        System.out.println();
    }
}

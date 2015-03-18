/**
 * User: wujian (jianwu203076@sohu-inc.com)
 * Date: 03/18/2015 10:47
 */
public class SelectSort {
    public static void sort(int[] data) {
        if (data == null || data.length <= 1) {
            return;
        }
        for (int i = 1; i <= data.length - 1; i++) {
            int k = i - 1;
            for (int j = i; j < data.length; j++) {
                if (data[j] < data[k]) {
                    k = j;
                }
            }
            if (k != i - 1) {
                int temp = data[k];
                data[k] = data[i - 1];
                data[i - 1] = temp;
            }
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

/**
 * User: wujian (jianwu203076@sohu-inc.com)
 * Date: 03/18/2015 10:19
 */
public class InsertSort {
    public static void sort(int[] data) {
        if (data == null || data.length <= 1) {
            return;
        }
        for (int i = 1; i < data.length; i++) {
            int temp = data[i];
            int j = i - 1;
            while (j >= 0 && data[j] > temp) {
                data[j + 1] = data[j];
                j--;
            }
            data[j + 1] = temp;
        }
    }

    public static void main(String[] args) {
        int[] data = {8, 5, 9, 10, 4};
        sort(data);
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + ", ");
        }
        System.out.println();
    }
}

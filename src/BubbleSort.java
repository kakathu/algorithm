/**
 * User: wujian (jianwu203076@sohu-inc.com)
 * Date: 03/16/2015 15:38
 */
public class BubbleSort {
    public static void sort(int[] data) {
        if (data.length == 0 || data.length == 1) {
            return;
        }
        for (int i = 0; i < data.length; i++) {
            boolean orderFlag = true;
            for (int j = 0; j < data.length - i - 1; j++) {
                if (data[j] > data[j + 1]) {
                    int temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                    orderFlag = false;
                }
            }
            if (orderFlag) {
                break;
            }
        }
    }

    public static void main(String[] args) {
//        int[] data = {19, 8, 4, 9, 0, 23};
        int[] data = {1, 2, 3};
        sort(data);
        for (int i : data) {
            System.out.print(i + ", ");
        }
        System.out.println();
    }
}

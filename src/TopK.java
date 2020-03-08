import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

public class TopK {
    public static void main(String[] args) {
        int[] data = {2, 6, 9, 3, 8, 1, 4};
        int k = 3;
//        PriorityQueue<Integer> pq = new PriorityQueue<>();
//        for(int i : data) {
//            if(pq.size() < 3) {
//                pq.add(i);
//            } else if(pq.peek() < i) {
//                pq.poll();
//                pq.offer(i);
//            }
//        }
//        while(!pq.isEmpty()) {
//            System.out.println(pq.poll() + ",");
//        }
        findMaxK(data, 0, data.length-1, k);
        System.out.println(data[k]);
    }

    public static void findMaxK(int[] data, int low, int high, int k) {
        if(low < high) {
            int p = partition(data, low, high);
            if(p == k)
                return;
            if(p < k) {
                findMaxK(data, p+1, high, k);
            } else {
                findMaxK(data, low, p-1, k);
            }
        }
    }

    public static int partition(int[] data, int low, int high) {
        int key = data[low];
        while(low < high) {
            while(low < high && data[high] >= key) {
                high--;
            }
            if(low < high) {
                data[low++] = data[high];
            }
            while(low < high && data[low] <= key) {
                low++;
            }
            if(low < high) {
                data[high--] = data[low];
            }
        }
        data[low] = key;
        return low;
    }

}

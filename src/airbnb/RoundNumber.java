package airbnb;

import java.util.Arrays;
import java.util.Comparator;
import java.util.concurrent.atomic.AtomicInteger;

public class RoundNumber {
    public static void main(String[] args) {
        double[] prices = {1.2, 2.5, 3.6, 4.3};
        Pair[] pairs = new Pair[prices.length];
        int totalInt = 0;
        double allDouble = 0.0;
        int[] result = new int[prices.length];
        for(int i = 0; i < prices.length; i++) {
            int tmp = (int)prices[i];
            totalInt += tmp;
            allDouble += prices[i];
            result[i] = tmp;
            pairs[i] = new Pair(prices[i], i);
        }
        Arrays.sort(pairs, new Comparator<Pair>() {
            @Override
            public int compare(Pair a, Pair b) {
                return Double.compare(a.val-(int)a.val, b.val-(int)b.val) * -1;
            }
        });
        int diff = (int)Math.round(allDouble) - totalInt;
        for(int i = 0; i < diff; i++) {
            result[pairs[i].index]++;
        }
        System.out.println(Arrays.toString(result));
    }
}

class Pair {
    double val;
    int index;
    public Pair(double val, int index) {
        this.val = val;
        this.index = index;
    }
}

import java.util.*;

class LFSSolution {
    public List<Integer> getLFSLength(int[] nums) {
        int[][] dp = new int[nums.length][nums.length];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        int result = 0;
        int first = -1, second = -1;
        List<Integer> subsquence = new LinkedList<>();
        int[][] child = new int[nums.length][nums.length];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                child[i][j] = -1;
            }
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            for (int j = i + 1; j < nums.length; j++) {
                dp[i][j] = 2;
                if (map.get(nums[i] + nums[j]) != null) {
                    if (i == 2 && j == 4) {
                        System.out.println("!!!!!");
                    }
                    int temp = nums[i] + nums[j];
                    int position = map.get(temp);
                    dp[i][j] = dp[j][position] + 1;
//                    result = Math.max(result, dp[i][j]);
                    if (dp[i][j] > result) {
                        result = dp[i][j];
                        first = i;
                        second = j;
                    }
                    child[i][j] = position;
                }
            }
        }
        subsquence.add(nums[first]);
        subsquence.add(nums[second]);
        int c = child[first][second];
        while (c != -1) {
            subsquence.add(nums[c]);
            first = second;
            second = c;
            c = child[first][second];
        }
//        return result;
        return subsquence;
    }
}


public class LongestFibonacciSubsequence {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(new LFSSolution().getLFSLength(nums));
    }
}

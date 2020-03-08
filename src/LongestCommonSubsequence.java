import java.util.*;

class LCSSolution {
    public int getLCS(int[] a, int[] b) {
        //此处如果不用[a.length+1][b.length+1],边界需要额外处理
        /*//把第一行写好
        int flag = 0;
        for (int i = 0; i < s2len ; i++) {
            if (s1[0] == s2[i]) {
                flag = 1;
            }
            dp[0][i] = flag;
        }
        //吧第一列写好
        flag = 0;
        for (int i = 0; i < s1len; i++) {
            if (s2[0] == s1[i]) {
                flag = 1;
            }
            dp[i][0] = flag;
        }*/
        int[][] dp = new int[a.length + 1][b.length + 1];
        for (int i = 0; i < a.length + 1; i++) {
            for (int j = 0; j < b.length + 1; j++) {
                dp[i][j] = 0;
            }
        }
        for (int i = 1; i <= a.length; i++) {
            for (int j = 1; j <= b.length; j++) {
                if (a[i - 1] == b[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = dp[i - 1][j] > dp[i][j - 1] ? dp[i - 1][j] : dp[i][j - 1];
                }
            }
        }
        return dp[a.length][b.length];
    }

}

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 8};
        int[] b = {2, 4, 5, 6};
//        int result = new LCSSolution().getLCS(a, b);
//        System.out.println(result);
//        System.out.println(Math.floor(1.15));
//        Stack<Integer> s = new Stack<Integer>();
//        System.out.println(s.peek());
//        HashSet<Integer> s = new HashSet<>();
//        s.add(1);
//        List<Integer> l = new ArrayList<>();
//        Queue<Integer> queue = new PriorityQueue<>();
//        Map<String, String> m = new HashMap<>();
//        StringBuilder sb = new StringBuilder();

        List<Integer> list1 = new ArrayList<Integer>();
        list1.add(1);
        list1.add(6);
        list1.add(4);
        list1.add(2);
        Integer[] t = new Integer[2];
//        list1.toArray(new int[2]);
        System.out.println(Arrays.toString(t));

        char aa = '\u0905';
        String s1 = "\u0905";
        String s2 = "\u0905";
        System.out.println(s1.equals(s2));
        System.out.println(s1);
        System.out.println(s1.getBytes().length);
        String s3 = "中国";

        System.out.println(s3.length());
        System.out.println(s3.getBytes().length);
        Map<String, String> m = new HashMap<>();
//        m.remove();
    }
}

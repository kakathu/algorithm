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
        int[] a = {1, 2, 3, 4, 5, 8, 6};
        int[] b = {2, 4, 5, 6};
        int result = new LCSSolution().getLCS(a, b);
        System.out.println(result);
    }
}

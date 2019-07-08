class LPSolution {
    public String getLength(String s) {
        if (s.length() <= 1) {
            return s;
        }
        boolean[][] dp = new boolean[s.length()][s.length()];
        int start = 0, longest = 1;
        int length = s.length();
        for (int j = 0; j < length; j++) {
            for (int i = 0; i <=j; i++) {
                if (j - i < 2) {
                    dp[i][j] = (s.charAt(i) == s.charAt(j));
                } else {
                    dp[i][j] = (s.charAt(i) == s.charAt(j) && dp[i+1][j-1]);
                }
                if (dp[i][j] && j - i + 1 > longest) {
                    longest = j - i + 1;
                    start = i;
                }
            }
        }
        return s.substring(start, start + longest);
    }
}

public class LongestPalindrome {
    public static void main(String[] args) {
        String s = "aabccbadf";
        System.out.println(new LPSolution().getLength(s));
    }
}

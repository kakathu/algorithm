import java.util.ArrayList;
import java.util.List;

public class Quote {
    public static void main(String[] args) {
//        System.out.println(dfs(3));
//        List<String> result = dfs2(4);
//        System.out.println(result.size());
//        System.out.println(result);
        List<String> result = new ArrayList<>();
        generate(3, 3, "", result);
        System.out.println(result);
    }

    private static int dfs(int n) {
        if(n == 0 || n == 1)
            return 1;
        int result = 0;
        for(int i = 0; i <= n-1; i++) {
            result += dfs(i) * dfs(n-i-1);
        }
        return result;
    }

    private static List<String> dfs2(int n) {
        List<String> result = new ArrayList<>();
        if(n == 0) {
            result.add("");
            return result;
        }
        if(n == 1) {
            result.add("()");
            return result;
        }

        for(int i = 0; i <= n-1; i++) {
            List<String> left = dfs2(i);
            List<String> right = dfs2(n-i-1);
            for(String l : left) {
                for(String r : right) {
                    result.add("(" + l + ")" + r);
                }
            }
         }
        return result;
    }

    private static void generate(int leftNum, int rightNum, String s, List<String> result) {
        if(leftNum == 0 && rightNum == 0) {
            result.add(s);
        }
        if(leftNum > 0) {
            generate(leftNum-1, rightNum, s+"(", result);
        }
        if(rightNum > 0 && leftNum < rightNum) {
            generate(leftNum, rightNum-1, s+")", result);
        }
    }
}

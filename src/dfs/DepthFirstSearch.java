package dfs;

import java.util.Stack;

public class DepthFirstSearch {
    private static int N = 5;
    private static int[][] map = {
            {0, 1, 1, 0, 0},
            {0, 0, 1, 0, 1},
            {0, 0, 1, 0, 0},
            {1, 1, 0, 0, 1},
            {0, 0, 1, 0, 0}
    };
    private static boolean[] visited = new boolean[N + 1];

    public static void recursiveDFS(int start) {
        visited[start] = true;
        System.out.println(start + " ");
        for (int i = 1; i <= N; i++) {
            if (map[start - 1][i - 1] == 1 && !visited[i]) {
                recursiveDFS(i);
            }
        }
//        System.out.println(start + " ");
    }

    public static void nonRecursiveDFS(int start) {
        visited[start] = true;
        Stack<Integer> s = new Stack<Integer>();
        s.push(start);
        System.out.print(start + " ");
        while (!s.empty()) {
            int v = s.pop();
            for (int i = 1; i <= N; i++) {
                if (!visited[i] && map[v - 1][i - 1] == 1) {
                    visited[i] = true;
                    s.push(i);
                    System.out.print(i + " ");
                }
            }
        }
    }

    public static void main(String[] args) {
//        System.out.println("dfs");
//        System.out.println(map[0][0]);
//        System.out.println(visited[0]);
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                //recursiveDFS(i);
                nonRecursiveDFS(i);
            }
        }
    }
}

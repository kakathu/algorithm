package dfs;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BreadthFirstSearch {
    private static int N = 5;
    private static int[][] map = {
            {0, 1, 1, 0, 0},
            {0, 0, 1, 0, 1},
            {0, 0, 1, 0, 0},
            {1, 1, 0, 0, 1},
            {0, 0, 1, 0, 0}
    };
    private static boolean[] visited = new boolean[N + 1];

    public static void BFS(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        while(!queue.isEmpty()) {
            int v = queue.poll();
            visited[v] = true;
            System.out.println(v + " ");
            for (int i = 1; i <= N; i++) {
                if (!visited[i] && map[v - 1][i - 1] == 1) {
                    queue.offer(i);
                }
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
               BFS(i);
            }
        }
    }
}

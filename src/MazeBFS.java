import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class MazeSolution {
    //上下左右
    int[][] direction = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    Node[][] father;
    int[][] maze;
    int width;
    int height;
    int[][] distance;
    public MazeSolution(int[][] maze) {
        this.maze = maze;
        width = maze[0].length;
        height = maze.length;
        father = new Node[height][width];
        distance = new int[height][width];
    }
    public List<Node> findPath(Node start, Node end) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(start);
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                distance[i][j] = 0;
            }
        }
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            maze[current.y][current.x] = -1;
            if (current.x == end.x && current.y == end.y) {
                break;
            }
            for (int i = 0; i < 4; i++) {
                int nextX = current.x + direction[i][0];
                int nextY = current.y + direction[i][1];
                if (nextX < 0 || nextX >= width || nextY < 0 || nextY >= height) {
                    continue;
                }
                if (maze[nextY][nextX] != 0) {
                    continue;
                }
                queue.offer(new Node(nextX, nextY));
                distance[nextY][nextX] = distance[current.y][current.x] + 1;
                father[nextY][nextX] = current;
            }
        }
        System.out.println(father[0][0]);
        int length = distance[end.y][end.x];
        List<Node> result = new LinkedList<>();
        solve(result, start, end);
        return result;
    }

    private void solve(List<Node> result, Node start, Node end) {
        if (end.x == start.x && end.y == start.y) {
            result.add(new Node(start.y, start.x));
        } else {
            solve(result, start, father[end.y][end.x]);
            result.add(new Node(end.y, end.x));
        }
    }
}

class Node {
    int x;
    int y;
    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return "[" + this.x + "," + this.y + "]";
    }
}

public class MazeBFS {

    public static void main(String[] args) {
        int[][] maze = {
                {0, 0, 0, 0},
                {1, 1, 0, 0},
                {0, 0, 0, 1},
                {0, 0, 0, 0},
                {0, 0, 0, 0}
        };
        List<Node> path = new MazeSolution(maze).findPath(new Node(0, 0), new Node(0, 4));
        System.out.println(path);
    }
}

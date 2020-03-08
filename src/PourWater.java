import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class State {
    int[] cup = new int[3];
    int step;

    @Override
    public String toString() {
        return "(" + cup[0] + ", " + cup[1] + ", " + cup[2] + ")";
    }
}

class PourWaterSolution {
    private int[] cap; // 杯子容量
    private int[] end; // 杯子最终水量
    private boolean[][][] vis;
    private State[][][] parent;

    public PourWaterSolution(int[] cap, int[] end) {
        this.cap = cap;
        this.end = end;
        vis = new boolean[cap[0] + 1][cap[0] + 1][cap[0] + 1];
        for (int i = 0; i <= cap[0]; i++) {
            for (int j = 0; j <= cap[1]; j++) {
                for (int k = 0; k <= cap[2]; k++) {
                    vis[i][j][k] = false;
                }
            }
        }
        parent = new State[cap[0] + 1][cap[0] + 1][cap[0] + 1];
    }

    public int bfs() {
        State startState = new State();
        startState.cup[0] = cap[0];
        startState.cup[1] = 0;
        startState.cup[2] = 0;
        startState.step = 0;
        vis[startState.cup[0]][startState.cup[1]][startState.cup[2]] = true;
        if (startState.cup[0] == end[0] && startState.cup[1] == end[1] && startState.cup[2] == end[2]) {
            return startState.step;
        }
        Queue<State> q = new LinkedList<>();
        q.offer(startState);
        while (!q.isEmpty()) {
            State temp = q.poll();
            for (int i = 0; i < 3; i++) {
                if (temp.cup[i] == 0) {
                    continue;
                }
                for (int j = 0; j < 3; j++) {
                    if (i == j || temp.cup[j] == cap[j]) {
                        continue;
                    }
                    // 可倒水
                    if (temp.cup[i] != 0 && temp.cup[j] != cap[j]) {
                        State newState = new State();
                        newState.cup[0] = temp.cup[0];
                        newState.cup[1] = temp.cup[1];
                        newState.cup[2] = temp.cup[2];
                        newState.step = temp.step + 1;
                        if (cap[j] - temp.cup[j] > temp.cup[i]) {
                            newState.cup[j] = temp.cup[j] + temp.cup[i];
                        } else {
                            newState.cup[j] = cap[j];
                        }
                        newState.cup[i] = temp.cup[j] + temp.cup[i] - newState.cup[j];
                        if (!vis[newState.cup[0]][newState.cup[1]][newState.cup[2]]) {
                            vis[newState.cup[0]][newState.cup[1]][newState.cup[2]] = true;
                            parent[newState.cup[0]][newState.cup[1]][newState.cup[2]] = temp;
                            if (newState.cup[0] == end[0] && newState.cup[1] == end[1] && newState.cup[2] == end[2]) {
                                return newState.step;
                            }
                            q.offer(newState);
                        }
                    }
                }
            }
        }
        return -1;
    }

    public void findPath(List<State> list, State s) {
        if (s.cup[0] == this.cap[0] && s.cup[1] == 0 && s.cup[2] == 0) {
            list.add(s);
        } else {
            findPath(list, parent[s.cup[0]][s.cup[1]][s.cup[2]]);
            list.add(s);
        }
    }
}

public class PourWater {
    public static void main(String[] args) {
        int[] cap = {6, 3, 1};
        int[] end = {4, 1 ,1};
        PourWaterSolution solution = new PourWaterSolution(cap, end);
        System.out.println(solution.bfs());
        List<State> path = new LinkedList<>();
        State s = new State();
        s.cup[0] = end[0];
        s.cup[1] = end[1];
        s.cup[2] = end[2];
        solution.findPath(path, s);
        System.out.println(path);
    }
}

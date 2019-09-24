import java.util.*;

class XorTreeSolution {
    List<Integer> list;

    public XorTreeSolution() {
        list = new ArrayList<>();
    }

    // count2 is count of changes of grand parent node
    // count1 is count of changes of parent node
    public void dfs(Map<Integer, List<Integer>> edges, int[] orig, int[] target, int curr, int parent, int count2, int count1) {
        boolean flag = false;
        int index = curr - 1;
        if(count2 % 2 != 0)
            flag = true;
        if(flag && (orig[index]^1) != target[index]) {
            count2++;
            list.add(curr);
        } else if(!flag && orig[index] != target[index]) {
            count2++;
            list.add(curr);
        }
        for(int i : edges.get(curr)) {
            if(i == parent) {
                continue;
            }
            dfs(edges, orig, target, i, curr, count1, count2);
        }
    }

    public void print() {
        System.out.println(list.size());
        for (Integer i : list) {
            System.out.println(i);
        }
    }
}

public class XorTree {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        for (int i = 0; i < 3; i++) {
//            System.out.println("output : " + sc.nextLine());
//        }
//        sc.close();
        int[][] e = new int[][]{
                {2, 1},
                {3, 1},
                {4, 2},
                {5, 1},
                {6, 2},
                {7, 5},
                {8, 6},
                {9, 8},
                {10, 5}
        };
        int[] orig = new int[]{1, 0, 1, 1, 0, 1, 0, 1, 0, 1};
        int[] target = new int[]{1, 0, 1, 0, 0, 1, 1, 1, 0, 1};
        Map<Integer, List<Integer>> edges = new HashMap<>();
        for (int[] edge : e) {
            if(edges.get(edge[0]) == null) {
                edges.put(edge[0], new ArrayList<>());
            }
            if(edges.get(edge[1]) == null) {
                edges.put(edge[1], new ArrayList<>());
            }
            edges.get(edge[0]).add(edge[1]);
            edges.get(edge[1]).add(edge[0]);
        }
        XorTreeSolution solution = new XorTreeSolution();
        solution.dfs(edges, orig, target, 1, 0, 0, 0);
        solution.print();
    }
}

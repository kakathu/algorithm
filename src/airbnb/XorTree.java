package airbnb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class XorTree {
    public static void main(String[] args) {
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
        Map<Integer, List<Integer>> edges = new HashMap<Integer, List<Integer>>();
        for(int[] edge : e) {
            if(!edges.containsKey(edge[0])) {
                edges.put(edge[0], new ArrayList<>());
            }
            if(!edges.containsKey(edge[1])) {
                edges.put(edge[1], new ArrayList<>());
            }
            edges.get(edge[0]).add(edge[1]);
            edges.get(edge[1]).add(edge[0]);
        }
        List<Integer> result = new ArrayList<>();
        XorTreeSolution.dfs(edges, result, 1, 0, orig, target, 0, 0);
        System.out.println(result.size());
        for(int node : result) {
            System.out.println(node);
        }
    }
}

class XorTreeSolution {
    public static void dfs(Map<Integer, List<Integer>> edges, List<Integer> result, int curr, int parent, int[] orig, int[] target, int count1, int count2) {
        int index = curr-1;
        boolean flag = false;
        if(count2%2 == 1)
            flag = true;
        if(flag && (orig[index]^1) != target[index]) {
            count2++;
            result.add(curr);
        } else if(!flag && orig[index] != target[index]) {
            count2++;
            result.add(curr);
        }
        for(int next : edges.get(curr)) {
            if(next == parent)
                continue;
            dfs(edges, result, next, curr, orig, target, count2, count1);
        }
    }
}

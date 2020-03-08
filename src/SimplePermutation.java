import java.util.ArrayList;
import java.util.List;

public class SimplePermutation {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        dfs(nums, 0, list, tmp);
        System.out.println(list);
    }

    public static void dfs(int[] nums, int level, List<List<Integer>> list, List<Integer> tmp) {
        if(level == nums.length)
            return;
        for(int i = level; i < nums.length; i++) {
            tmp.add(nums[i]);
            list.add(new ArrayList<>(tmp));
        }
        tmp.clear();
        dfs(nums, level + 1, list, tmp);
    }
}

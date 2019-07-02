import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<Integer>();
        dfs(res, temp, nums, 0);
        return res;
    }

    private static void dfs(List<List<Integer>> res, List<Integer> temp, int[] nums, int j) {
        if (j == nums.length) {
            res.add(new ArrayList<Integer>(temp));
            return;
        }
        dfs(res, temp, nums, j + 1);
        temp.add(nums[j]);  //① 加入 nums[i]
        dfs(res, temp, nums, j + 1);  //② 递归
        temp.remove(temp.size() - 1);  //③ 移除 nums[i]
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        List<List<Integer>> sets = subsets(nums);
        System.out.println(sets);
    }
}

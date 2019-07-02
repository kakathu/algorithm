import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        //Arrays.sort(nums);
        backtrack(list, nums, 0);
        return list;
    }

    private void backtrack(List<List<Integer>> list, int[] nums, int t) {
        if (t > nums.length - 1) {
            List<Integer> temp = new ArrayList<Integer>(nums.length);
            for (int i = 0; i < nums.length; i++) {
                temp.add(nums[i]);
            }
            //list.add(Arrays.asList(nums));
            list.add(temp);
        } else {
            for (int i = t; i < nums.length; i++) {
                swap(nums, t, i);
                backtrack(list, nums, t + 1);
                swap(nums, t, i);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

public class Permutation {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> result = new Solution().permute(nums);
        System.out.println(result);
    }

}
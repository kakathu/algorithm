class MajorityElementSolution {
    public int getMajorElement(int[] nums) {
        int count = 0;
        int candidate = -1;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            if (candidate == num) {
                count++;
            } else {
                count--;
            }
        }
        return candidate;
    }
}

public class MajorityElement {
    public static void main(String[] args) {
        int[] nums = {9, 9, 9, 1, 2, 3};
        System.out.println(new MajorityElementSolution().getMajorElement(nums));
    }
}

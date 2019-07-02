class LISSolution {
    public int getLIS(int[] nums) {
        int maxLength = 1;
        int[] lis = new int[nums.length];
        for (int i = 0 ; i < nums.length; i++) {
            lis[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && lis[j] + 1 > lis[i]) {
                    lis[i]= lis[j] + 1;
                }
            }
            if (lis[i] > maxLength) {
                maxLength = lis[i];
            }
        }
        return maxLength;
    }
}

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] nums = {-1,2,4,3,5,6,7,5};
        int length = new LISSolution().getLIS(nums);
        System.out.println(length);
    }
}

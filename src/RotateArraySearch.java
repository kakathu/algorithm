
public class RotateArraySearch {
    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 8, 1, 2, 3};
        int key = 2;
        System.out.println(binarySearch(nums, key));
    }

    private static int binarySearch(int[] nums, int key) {
        int start = 0;
        int end = nums.length - 1;
        while(start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == key) {
                return mid;
            }
            // 左边有序，右边无序
            if (nums[mid] > nums[end]) {
                if (key > nums[start] && key < nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                // 右边有序，左边无序
                if (key > nums[mid] && key < nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }
}

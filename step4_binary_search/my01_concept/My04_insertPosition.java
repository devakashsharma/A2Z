public class My04_insertPosition {
    static int insertPosition(int[] nums, int target) {
        int n = nums.length;
        int ind = n;
        int low = 0, high = n - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (nums[mid] >= target) {
                ind = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ind;
    }

    public static void main(String[] args) {
        int[] arr = { 1,2,4,7 };
        int target = 6;

        System.out.println(insertPosition(arr, target));
    }
}

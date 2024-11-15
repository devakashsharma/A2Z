public class My03_upperBound {
    static int upperBound(int[] arr, int k) {
        int n = arr.length;
        int ans = n;
        int low = 0, high = n - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] > k) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = { 3, 5, 8, 15, 19 };
        int target = 8;

        int ans = upperBound(arr, target);

        System.out.println(ans);
    }
}

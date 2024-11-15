public class My02_lowerBound {
    // lower bound

    // Brute Force
    // using Linear Search
    static int lowerBoundBS(int[] arr, int x) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (arr[i] >= x)
                return i;
        }

        return n;
    }

    // Optimal Approach
    static int lowerBoundOptimal(int[] arr, int x) {
        int n = arr.length;
        int low = 0, high = n - 1;
        int ans = n;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] >= x) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        // int[] arr = { 1, 2, 2, 3 };
        int[] arr = { 3, 5, 8, 15, 19 };
        int target = 9;

        int ans = lowerBoundBS(arr, target);

        System.out.println(ans);
        System.out.println(lowerBoundOptimal(arr, target));
    }
}

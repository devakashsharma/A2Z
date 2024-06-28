import java.util.HashMap;
import java.util.Map;

public class My13_totalSubarr {
    // Brute Force
    // TC - O(N^3), SC - O(1)
    static void totalSubarr(int[] arr, int k) {
        int n = arr.length;
        int total = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int sum = 0;
                for (int K = i; K <= j; K++) {
                    sum += arr[K];
                }

                if (sum == k)
                    total++;
            }
        }

        System.out.println(total);
    }

    // Better Approach
    // TC - O(N^2), SC - O(1)
    static void betterSubarr(int[] arr, int k) {
        int n = arr.length;
        int total = 0;

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr[j];
                if (sum == k)
                    total++;
            }
        }

        System.out.println(total);
    }

    // Optimal Approach
    // TC - O(N*logN), SC - O(N)
    static void optimalSubarr(int[] arr, int k) {
        int preSum = 0, count = 0;
        Map<Integer, Integer> mapp = new HashMap<>();
        mapp.put(0, 1);

        for (int i = 0; i < arr.length; i++) {
            // add current element to prefix Sum:
            preSum += arr[i];

            // Calculate x-k:
            int remove = preSum - k;

            // Add the number of subarrays to be removed:
            count += mapp.getOrDefault(remove, 0);

            // Update the count of prefix sum
            mapp.put(preSum, mapp.getOrDefault(preSum, 0) + 1);

        }

        System.out.println(count);
    }

    public static void main(String[] args) {
        int[] arr = { 3, 1, 2, 4 };
        int k = 6;
        totalSubarr(arr, k);
        betterSubarr(arr, k);
        optimalSubarr(arr, k);
    }
}

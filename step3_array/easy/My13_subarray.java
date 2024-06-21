import java.util.HashMap;
import java.util.Map;

public class My13_subarray {
    // brute force approach
    static int bruteSubarr(int[] arr, int k) {
        int n = arr.length;
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int sum = 0;
                for (int K = i; K <= j; K++) {
                    sum += arr[K];
                }
                if (sum == k)
                    max = Math.max(max, j - i + 1);
            }
        }

        return max;
    }

    // better brute
    static int betterBrute(int[] arr, int k) {
        int n = arr.length;
        int max = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr[j];

                if (sum == k)
                    max = Math.max(max, j - i + 1);
            }
        }

        return max;
    }

    // better
    static int betterArr(int[] arr, int k) {
        int n = arr.length;

        Map<Integer, Integer> sumMap = new HashMap<>();
        int max = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];

            if (sum == k)
                max = Math.max(max, i + 1);

            int remain = sum - k;

            if (sumMap.containsKey(remain)) {
                int len = i - sumMap.get(remain);
                max = Math.max(max, len);
            }

            if (!sumMap.containsKey(sum))
                sumMap.put(sum, i);
        }

        return max;
    }

    public static void main(String[] args) {
        // int[] arr = {4, 6, 2, 2, 6, 8, 1, 4, 1};
        // int[] arr = { 2, 3, 5 };
        // System.out.println(bruteSubarr(arr, 5));
        int[] arr = { 2, 3, 5, 1, 9 };
        // System.out.println(bruteSubarr(arr, 10));
        // System.out.println(betterBrute(arr, 10));
        System.out.println(betterArr(arr, 10));
    }
}

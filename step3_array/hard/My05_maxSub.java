import java.util.HashMap;

public class My05_maxSub {
    // Brute Force
    // TC - O(N^2), O(1)
    static void bruteMax(int[] arr) {
        int n = arr.length;
        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr[j];
                if (sum == 0) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }

        System.out.println(maxLen);
    }

    // Optimal Approach
    static void optimalMax(int[] arr) {
        int n = arr.length;
        int max = 0;
        int sum = 0;

        HashMap<Integer, Integer> hMap = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if (sum == 0) {
                max = i + 1;
            } else {
                if (hMap.get(sum) != null) {
                    max = Math.max(max, i - hMap.get(sum));
                } else {
                    hMap.put(sum, i);
                }
            }
        }

        System.out.println(max);
    }

    public static void main(String[] args) {
        // int[] arr = {9, -3, 3, -1, 6, -5};
        int[] arr = {6, -2, 2, -8, 1, 7, 4, -10};
        // int[] arr = {1, 0, -5};
        // bruteMax(arr);
        optimalMax(arr);
    }
}

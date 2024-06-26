import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class My09_conSeq {
    // brute force
    // TC - o(N^2), O(1)

    // linear search
    static boolean linearSearch(int[] arr, int num) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == num)
                return true;
        }

        return false;
    }

    // consecutive subsequence method
    static void consecutiveSubseq(int[] arr) {
        int max = 1;
        for (int i = 0; i < arr.length - 1; i++) {
            int count = 1;
            int x = arr[i];

            while (linearSearch(arr, x + 1) == true) {
                x++;
                count++;
            }

            max = Math.max(max, count);
        }

        System.out.println(max);
    }

    // Better Solution
    // TC - O(NlogN), SC - O(1)
    static void betterSeq(int[] arr) {
        int max = 1;
        int lastSmall = Integer.MIN_VALUE;
        int count = 0;

        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] - 1 == lastSmall) {
                count++;
                lastSmall = arr[i];
            } else if (arr[i] != lastSmall) {
                count = 1;
                lastSmall = arr[i];
            }

            max = Math.max(max, count);
        }

        System.out.println(max);
    }

    // Optimal
    static int optimalSeq(int[] arr) {
        int n = arr.length;
        if (n == 0)
            return 0;
        int max = 1;

        Set<Integer> hSet = new HashSet<>();

        for (int i = 0; i < n; i++) {
            hSet.add(arr[i]);
        }

        for (int item : hSet) {
            if (!hSet.contains(item - 1)) {
                int count = 1;
                int x = item;
                while(hSet.contains(x + 1)) {
                    count++;
                    x++;
                }

                max = Math.max(max, count);
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int[] arr = { 3, 8, 5, 7, 6, 9 };
        // int[] arr = { 100, 200, 1, 3, 2, 4 };
        consecutiveSubseq(arr);
        betterSeq(arr);
        System.out.println(optimalSeq(arr));
    }
}

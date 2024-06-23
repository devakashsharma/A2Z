public class My04_kadane {
    // Brute Force
    // TC - O(N^3), SC - O(1)
    static void bruteKadane(int[] arr) {
        int n = arr.length;
        int max = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int sum = 0;
                for (int k = i; k < j; k++) {
                    sum += arr[k];
                    max = Math.max(max, sum);
                }
            }
        }
        System.out.println(max);
    }

    // Better
    // TC - O(N^2), SC - O(1)
    static void betterKadane(int[] arr) {
        int n = arr.length;
        int max = 0;

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr[j];
                max = Math.max(max, sum);
            }
        }

        System.out.println(max);
    }

    // Optimal - Kadane's Algorithm
    static void optimalKadane(int[] arr) {
        int max = Integer.MIN_VALUE;
        int sum = 0;

        int start = 0;
        @SuppressWarnings("unused")
        int ansStart = -1, ansEnd = -1;
        for (int i = 0; i < arr.length; i++) {
            if (sum == 0) start = i;

            sum += arr[i];

            if (sum > max)
                max = sum;
                ansStart = start;
                ansEnd = i;

            if (sum < 0)
                sum = 0;
        }

        System.out.print("The subarray is: [ ");
        for (int i = ansStart; i <= ansEnd; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.print("]\n");

        if (max > 0)
            System.out.println(max);
        else
            System.out.println(0);
    }

    public static void main(String[] args) {
        int[] arr = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        bruteKadane(arr);
        betterKadane(arr);
        optimalKadane(arr);
    }
}

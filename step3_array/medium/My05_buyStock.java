public class My05_buyStock {
    // Brute Force
    static int bruteStock(int[] arr) {
        int max = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] < arr[j]) {
                    max = Math.max(arr[j] - arr[i], max);
                }
            }
        }

        return max;
    }

    // Optimal
    static int optimalStock(int[] arr) {
        int max = 0, min = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i] - min);
        }

        return max;
    }

    public static void main(String[] args) {
        int[] arr = { 7, 1, 5, 3, 6, 4 };
        System.out.println(bruteStock(arr));
        System.out.println(optimalStock(arr));
    }
}

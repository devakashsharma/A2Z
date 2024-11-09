public class My12_maxProduct {
    // Maximum product subarray
    static int maxProduct(int[] arr) {
        int n = arr.length;
        int prefix = 1;
        int suffix = 1;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            if (prefix == 0)
                prefix = 1;
            if (suffix == 0)
                suffix = 1;
            prefix *= arr[i];
            suffix *= arr[n - i - 1];
            max = Math.max(max, Math.max(prefix, suffix));
        }

        return max;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, -3, 0, -4, -5};
        System.out.println(maxProduct(arr));
    }
}

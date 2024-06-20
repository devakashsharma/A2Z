public class My10_missing {
    // Missing Value
    static void bruteMissing(int[] arr) {
        int n = arr.length + 1;
        int firstN = (n * (n + 1)) / 2;
        int missing = 0;
        for (int i = 0; i < n - 1; i++) {
            missing += arr[i];
        }

        missing = firstN - missing;

        System.out.println("Missing Number: " + missing);
    }

    // Optimal
    static void optimalMissing(int[] arr) {
        int n = arr.length - 1;
        int xor1 = 0; 
        int xor2 = 0;

        for (int i = 0; i < n; i++) {
            xor1 = xor1 ^ (i + 1);
            xor2 = xor2 ^ arr[i];
        }

        xor2 ^= 5;

        System.out.println(xor1 ^ xor2);
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 6 };
        bruteMissing(arr);
        optimalMissing(arr);
    }
}

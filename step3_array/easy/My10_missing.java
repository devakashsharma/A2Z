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

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 6 };
        bruteMissing(arr);
    }
}

public class My09_repeatMissing {

    static void repeatMissingNum(int[] arr) {
        long n = arr.length;

        long SN = (n * (n + 1)) / 2;
        long S2N = (n * (n + 1) * (2 * n + 1)) / 6;

        long S = 0, S2 = 0;

        for (int i = 0; i < n; i++) {
            S += (long) arr[i];
            S2 += (long) arr[i] * (long) arr[i];
        }

        // S-Sn = X-Y:
        long val1 = S - SN;

        // S2-S2n = X^2-Y^2:
        long val2 = S2 - S2N;

        // Find X+Y = (X^2-Y^2)/(X-Y):
        val2 = val2 / val1;

        // Find X and Y: X = ((X+Y)+(X-Y))/2 and Y = X-(X-Y),
        // Here, X-Y = val1 and X+Y = val2:
        long x = (val1 + val2) / 2;
        long y = x - val1;

        int[] result = { (int) x, (int) y };

        System.out.print("[ ");
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 5, 4, 6, 7, 5};
        repeatMissingNum(arr);
    }
}

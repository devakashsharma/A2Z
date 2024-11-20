public class My02_nthRoot {
    // method for checking numbers
    static int nthRoot(int mid, int n, int m) {
        long ans = 1;
        for (int i = 1; i <= n; i++) {
            ans = ans * mid;
            if (ans > m)
                return 2;
        }

        if (ans == m)
            return 1;
        else
            return 0;
    }

    // method for finding the nth root
    static int findNthRoot(int n, int m) {
        int low = 1, high = m;

        while (low <= high) {
            int mid = (low + high) / 2;

            int midNum = nthRoot(mid, n, m);

            if (midNum == 1)
                return mid;
            else if (midNum == 0)
                low = mid + 1;
            else
                high = high - 1;
        }

        return -1;
    }

    public static void main(String[] args) {
        int n = 3, m = 27;
        int ans = findNthRoot(n, m);
        System.out.println("The " + n + "th root of " + m + " is: " + ans);
    }
}

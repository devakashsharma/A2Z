public class My01_sqrtFloor {

    // Brute force approach
    static int sqrtFloor(int n) {
        return (int) Math.sqrt(n);
    }

    // Optimal
    static int sqrtFloorOptimal(int n) {
        int low = 0, high = n, ans = 1;
        
        while (low <= high) {
            int mid = (low + high) / 2;

            if (mid * mid <= n) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int n = 30;
        // System.out.println((int) Math.sqrt(37));

        // brute
        System.out.println(sqrtFloor(n));

        // optimal
        System.out.println(sqrtFloorOptimal(n));
    }
}

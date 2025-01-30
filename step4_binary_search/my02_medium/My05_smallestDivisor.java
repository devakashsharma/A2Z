public class My05_smallestDivisor {

    static int calculateDiv(int[] arr, int mid) {
        int total = 0;

        for (int i = 0; i < arr.length; i++) {
            total += Math.ceil((double) arr[i] / (double) mid);
        } 

        return total;
    }

    // methods for find smallest divisor
    static int smallestDivisor (int[] arr, int limit) {
        int n = arr.length;
        if (n > limit) return -1;

        int max = Integer.MIN_VALUE;
        
        for (int i = 0; i < n; i++) {
            max = Math.max(max, arr[i]);
        }

        int low = 1, high = max;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (calculateDiv(arr, mid) <= limit) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int limit = 8;
        System.out.println(smallestDivisor(arr, limit));
    }
}

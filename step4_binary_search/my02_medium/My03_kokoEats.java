public class My03_kokoEats {
    // methods for maximum number
    static int maxNum(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }

        return max;
    }

    // methods to calculate the hour
    static int calculateHour(int[] arr, int h) {
        int totalHours = 0;

        for (int i = 0; i < arr.length; i++) {
            totalHours += Math.ceil((double) (arr[i]) / (double) (h));
        }

        return totalHours;
    }

    // methods to find the minimum time
    static int minEatingSpeed(int[] arr, int h) {
        int low = 1, high = maxNum(arr);

        while (low <= high) {
            int mid = (low + high) / 2;
            int totalHours = calculateHour(arr, mid);

            if (totalHours <= h)
                high = mid - 1;
            else
                low = mid + 1;
        }

        return low;
    }

    public static void main(String[] args) {
        int[] arr = {7, 15, 6, 3};
        int h = 8;

        System.out.println(minEatingSpeed(arr, h));
    }
}

public class My06_capacity {

    // find days
    static int findDays(int[] arr, int cap) {
        int days = 1, load = 0;

        for (int i = 0; i < arr.length; i++) {
            if (load + arr[i] > cap) {
                days += 1;
                load = arr[i];
            } else {
                load += arr[i];
            }
        }

        return days;
    }

    // methods to find the capacity
    static int capacity(int[] arr, int cap) {
        int low = Integer.MIN_VALUE, high = 0;

        for (int i = 0; i < arr.length; i++) {
            high += arr[i];
            low = Math.max(low, arr[i]);
        }

        while (low <= high) {
            int mid = (low + high) / 2;
            int numberOfDays = findDays(arr, mid);
            if (numberOfDays <= cap) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    public static void main(String[] args) {
        int[] weights = { 5, 4, 5, 2, 3, 4, 5, 6 };
        int d = 5;

        System.out.println(capacity(weights, d));
    }
}

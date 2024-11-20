public class My13_peak {
    static int peakElement(int[] arr) {
        int n = arr.length;

        if (n == 0) return -1;
        if (n == 1) return 0;
        if (arr[0] > arr[1]) return 0;
        if (arr[n - 1] > arr[n - 2]) return n - 1;

        int low = 1, high = n - 2;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if ((arr[mid] > arr[mid - 1]) && (arr[mid] > arr[mid + 1])) return mid;
            else if (arr[mid] > arr[mid - 1]) low = mid + 1;
            else high = mid - 1;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 10, 8, 6, 4, 2};
        int peakIndex = peakElement(arr);
        System.out.println("Peak Element Index: " + peakIndex);
    }
}

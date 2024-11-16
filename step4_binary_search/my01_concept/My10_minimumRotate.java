public class My10_minimumRotate {

    // Optimal
    static int miniRotate(int[] arr) {
        int min = Integer.MAX_VALUE;
        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[low] <= arr[mid]) {
                min = Math.min(min, arr[low]);
                low = mid + 1;
            } else {
                min = Math.min(min, arr[mid]);
                high = mid - 1;
            }
        }

        return min;
    }

    // Futher Optimised
    static int minimumRotate(int[] arr) {
        int min = Integer.MAX_VALUE;
        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            // If low is lower than high; means array is sorted so low will always be lower than high
            if (arr[low] <= arr[high]) {
                min = Math.min(min, arr[low]);
                break;
            }

            if (arr[low] <= arr[mid]) {
                min = Math.min(min, arr[low]);
                low = mid + 1;
            } else {
                min = Math.min(min, arr[mid]);
                high = mid - 1;
            }
        }

        return min;
    }
    public static void main(String[] args) {
        int[] arr = {4,5,6,7,0,1,2,3};
        System.out.println(miniRotate(arr));
    }
}
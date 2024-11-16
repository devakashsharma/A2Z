public class My09_rotateSorted {
    static boolean rotateIsSorted(int[] arr, int x) {
        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] == x) {
                return true;
            }

            if (arr[low] == arr[mid] && arr[mid] == arr[high]) {
                low++;
                high--;
                continue;
            }

            if (arr[low] <= arr[mid]) {
                if (arr[low] <= x && x <= arr[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (arr[mid] <= x && x <= arr[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] arr = { 7, 8, 1, 2, 3, 3, 3, 4, 5, 6 };
        int x = 3;

        System.out.println(rotateIsSorted(arr, x));
    }
}

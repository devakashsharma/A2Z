public class My05_floorCeiling {
    // Floor
    static int findFloor(int[] arr, int x) {
        int n = arr.length;
        int flr = -1;
        int low = 0, high = n - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] <= x) {
                flr = arr[mid];
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return flr;
    }

    // Ceiling
    static int findCeil(int[] arr, int x) {
        int n = arr.length;
        int ceil = -1;
        int low = 0, high = n - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] >= x) {
                ceil = arr[mid];
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ceil;
    }

    // FLoor and Ceiling
    static int[] findFloorCeil(int[] arr, int x) {
        int flr = findFloor(arr, x);
        int ceil = findCeil(arr, x);

        return new int[] {flr, ceil};
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, 4, 7, 8, 10};
        int x = 5;

        int[] val = findFloorCeil(arr, x);
        System.out.println("The FLoor and Ceil are: " + val[0] + " and " + val[1]);
    }
}

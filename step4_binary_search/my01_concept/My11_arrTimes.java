public class My11_arrTimes {
    static int arrayTimesSort(int[] arr) {
        int min = Integer.MAX_VALUE;
        int ind = -1;
        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[low] <= arr[high]) {
                if (arr[low] <= min) {
                    ind = low;
                    min = arr[low];
                }
                break;
            }

            if (arr[low] <= arr[mid]) {
                if (arr[low] <= min) {
                    ind = low;
                    min = arr[low];
                }

                low = mid + 1;
            } else {
                if (arr[mid] <= min) {
                    ind = mid;
                    min = arr[mid];
                }
            }
        }

        return ind;
    }

    public static void main(String[] args) {
        int[] arr = {4,5,6,7,0,1,2,3};
        System.out.println(arrayTimesSort(arr));
    }
}

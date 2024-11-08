import java.util.ArrayList;

public class My11_countPairs {

    // Brute Force
    static void bruteCount(int[] arr) {
        int n = arr.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] > (2 * arr[j])) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }

    // merge the array
    static void merge(int[] arr, int low, int mid, int high) {
        ArrayList<Integer> arrList = new ArrayList<>();
        int left = low;
        int right = mid + 1;
        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                arrList.add(arr[left]);
                left++;
            } else {
                arrList.add(arr[right]);
                right++;
            }
        }

        // if elements of left-side still left
        while (left <= mid) {
            arrList.add(arr[left]);
            left++;
        }

        // if elements of right-side still left
        while (right <= high) {
            arrList.add(arr[right]);
            right++;
        }

        // transferring the element into arr
        for (int i = low; i <= high; i++) {
            arr[i] = arrList.get(i - low);
        }
        
    }

    // merge sort algorithm
    static int mergeSort(int[] arr, int low, int high) {
        int count = 0;
        if (low >= high) return count;
        int mid = (low + high) / 2;

        // divide the left half array
        count += mergeSort(arr, low, mid);
        
        // divide the right half array
        count+= mergeSort(arr, mid + 1, high);

        // Count Paris
        count += countPairs(arr, low, mid, high);

        // merge the array
        merge(arr, low, mid, high);

        return count;
    }

    // Count the pairs
    static int countPairs(int[] arr, int low, int mid, int high) {
        int count = 0;
        int right = mid + 1;

        for (int i = low; i <= mid; i++) {
            while (right <= high && arr[i] > (2L * arr[right])) right++;
            count += right - (mid + 1);
        }

        return count;
    }

    // Optimal
    static int optimalCountPairs(int[] arr) {
        int n = arr.length;

        return mergeSort(arr, 0, n - 1);
    }

    public static void main(String[] args) {
        // int[] arr = { 1, 3, 2, 3, 1 };
        int[] arr = { 4, 1, 2, 3, 1 };
        bruteCount(arr);
        System.out.println("Optimal: " + optimalCountPairs(arr));
    }
}

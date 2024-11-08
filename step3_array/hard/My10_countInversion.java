import java.util.ArrayList;

public class My10_countInversion {
    
    // Brute Force Approach
    static void countIntersion(int[] arr) {
        int n = arr.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] > arr[j]) {
                    count++;
                }
            }
        }

        System.out.println("Brute Force: " + count);
    }

    // merge the array
    static int merge(int[] arr, int low, int mid, int high) {
        ArrayList<Integer> arrList = new ArrayList<>();
        int left = low;
        int right = mid + 1;
        
        int count = 0;

        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                arrList.add(arr[left]);
                left++;
            } else {
                arrList.add(arr[right]);
                count = mid + 1;
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

        return count;
    }

    // merge sort algorithm
    static int mergeSort(int[] arr, int low, int high) {
        int count = 0;

        if (low >= high) return count;
        int mid = (low + high) / 2;

        // divide the left half array
        count += mergeSort(arr, low, mid);
        
        // divide the right half array
        count += mergeSort(arr, mid + 1, high);

        // merge the array
        count += merge(arr, low, mid, high);

        return count;
    }

    // Optimal Approach
    static void optimalInversion(int[] arr) {
        int n = arr.length;
        
        System.out.println("Optimal: " + mergeSort(arr, 0, n - 1));
    }

    public static void main(String[] args) {
        // int[] array = { 1, 2, 3, 4, 5 };
        int[] array = { 5, 4, 3, 2, 1 };
        // countIntersion(array);
        optimalInversion(array);
    }
}

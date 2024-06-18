import java.util.ArrayList;

public class My04_merge {

    // print method
    static void printArray(int[] arr) {
        System.out.print("Array: [ ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.print("]\n");
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
    static void mergeSort(int[] arr, int low, int high) {
        if (low >= high) return;
        int mid = (low + high) / 2;

        // divide the left half array
        mergeSort(arr, low, mid);
        
        // divide the right half array
        mergeSort(arr, mid + 1, high);

        // merge the array
        merge(arr, low, mid, high);
    }

    public static void main(String[] args) {
        int[] arr = {9, 4, 7, 6, 3, 1, 5};
        mergeSort(arr, 0, arr.length - 1);
        printArray(arr);
    }
}

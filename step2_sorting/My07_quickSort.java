import java.util.List;
// import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class My07_quickSort {
    // print method
    static void printArray(int[] arr) {
        System.out.print("Array: [ ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.print("]\n");
    }

    // Quick Sort method
    static void quickSort(List<Integer> arr, int low, int high) {
        if (low < high) {

            int part = partition(arr, low, high);

            // left side
            quickSort(arr, low, part - 1);

            // right side
            quickSort(arr, part + 1, high);
        }
    }

    // partition method
    static int partition(List<Integer> arr, int low, int high) {
        int pivot = arr.get(low);
        int i = low;
        int j = high;

        while (i < j) {
            while (arr.get(i) <= pivot && i <= high - 1) i++;
            while (arr.get(j) >= pivot && j >= low + 1) j--;
            if (i < j) {
                int temp = arr.get(i);
                arr.set(i, arr.get(j));
                arr.set(j, temp);
            }
        }

        int temp = arr.get(low);
        arr.set(low, arr.get(j));
        arr.set(j, temp);

        return j;
    }

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        arr = Arrays.asList(new Integer[] {4, 6, 2, 5, 7, 8, 1, 4, 9, 1, 3});

        quickSort(arr, 0, arr.size() - 1);
        System.out.println(arr);
    }
}

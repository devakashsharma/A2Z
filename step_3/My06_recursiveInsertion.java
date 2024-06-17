public class My06_recursiveInsertion {
    // print method
    static void printArray(int[] arr) {
        System.out.print("Array: [ ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.print("]\n");
    }

    // Insertion Sort method
    static void recursInsertion(int[] arr, int i, int n) {
        if (i == n) return;
        else {
            int j = i;
            while (j > 0 && arr[j - 1] > arr[j]) {
                int temp = arr[j - 1];
                arr[j - 1] = arr[j];
                arr[j] = temp;
                j--;
            }

            recursInsertion(arr, i+1, n);
        }
    }

    public static void main(String[] args) {
        int[] arr = {9, 4, 7, 6, 3, 1, 5};
        recursInsertion(arr, 0, arr.length);
        printArray(arr);
    }
}

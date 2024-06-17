public class My03_insertion {
    // print method
    static void printArray(int[] arr) {
        System.out.print("Array: [ ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.print("]\n");
    }

    // insertion sort
    static void insertion(int[] arr) {
        int n = arr.length; 
        for (int i = 0; i < n; i++) {
            int j = i;
            while (j > 0 && arr[j - 1] > arr[j]) {
                int temp = arr[j - 1];
                arr[j - 1] = arr[j];
                arr[j] = temp;
                j--;
            }
        }

        printArray(arr);
    }

    public static void main(String[] args) {
        int[] arr = {3, 5, 7, 2, 3, 1};
        insertion(arr);
    }
}

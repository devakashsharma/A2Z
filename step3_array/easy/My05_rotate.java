public class My05_rotate {
    // print method
    static void printArray(int[] arr) {
        System.out.print("Array: [ ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.print("]\n");
    }

    // swap methods
    static void swapMethod(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }
    }

    // rotate method
    static void rotate(int[] arr, int k) {
        int n = arr.length;
        k = k % n;

        // rotate the entire array
        swapMethod(arr, 0, n - 1);

        // rotate kth
        swapMethod(arr, 0, k - 1);

        // rotate the remaining
        swapMethod(arr, k, n - 1);

        printArray(arr);
    }

    // Optimal
    static void rotateOne(int[] arr) {
        int temp = arr[0];
        for (int i = 0; i < arr.length - 1; i++) {
            arr[i] = arr[i + 1];
        }

        arr[arr.length - 1] = temp;

        printArray(arr);
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6 };
        // rotate(arr, 1);
        rotateOne(arr);
    }
}

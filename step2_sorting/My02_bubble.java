public class My02_bubble {
    // print method
    static void printArray(int[] arr) {
        System.out.print("Array: [ ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.print("]\n");
    }

    // bubble sort
    static void bubble(int[] arr) {
        int didSwap = 0;
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j + 1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                    didSwap = 1;
                }
            }

            if (didSwap == 0) {
                System.out.println("No Swap");
                break;
            }
        }

        printArray(arr);
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 1, 6, 3, 5};
        int[] arrs = {1, 2, 3, 4, 5};
        bubble(arr);
        bubble(arrs);
    }
}

public class My07_moveZero {
    // print method
    static void printArray(int[] arr) {
        System.out.print("Array: [ ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.print("]\n");
    }

    // move zero
    static void moveZero(int[] arr) {
        int n = arr.length;
        int zero = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                zero++;
            } else if (zero > 0) {
                int temp = arr[i];
                arr[i] = 0;
                arr[i - zero] = temp;
            }
        }

        printArray(arr);
    }

    public static void main(String[] args) {
        int[] arr = { 1, 0, 3, 0, 4, 5, 0, 6 };
        moveZero(arr);
    }
}

import java.util.Arrays;

public class My01_largestELement {
    // print method
    static void printArray(int[] arr) {
        System.out.print("Array: [ ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.print("]\n");
    }

    // Brute Force Approach 
    // TC - O(N*log(N)), SC - O(n)
    static int bruteApp(int[] arr) {
        Arrays.sort(arr);
        return arr[arr.length - 1];
    }

    // Recursive Approach 
    // TC - O(N), O(1)
    static void largestElement(int[] arr) {
        int n = Integer.MIN_VALUE;
        // int n = arr[0];

        for (int i = 0; i < arr.length; i++) {
            if (n < arr[i])
                n = arr[i];
        }

        System.out.println("Largest Element: " + n);
    }

    public static void main(String[] args) {
        int[] arr = { 4, 6, 2, 5, 7, 8, 1, 4, 9, 10, 3 };
        // largestElement(arr);
        System.out.println(bruteApp(arr));
    }
}

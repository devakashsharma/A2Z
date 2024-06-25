public class My07_permutation {

    // print array
    static void printArr(int[] arr) {
        System.out.print("Array: [ ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("]");
    }

    // swap method
    static void swap(int[] arr, int start, int end) {
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }

    // reverse array method
    static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            swap(arr, start, end);
            start++;
            end--;
        }
    }

    // Optimal
    static void nextPermutation(int[] arr) {
        int n = arr.length;

        // break point
        int index1 = -1;
        int index2 = -1;

        // Step 1: Find the break point:
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] < arr[i + 1]) {
                index1 = i;
                break;
            }
        }

        // If break point does not exist:
        if (index1 == -1) {
            reverse(arr, 0, n - 1);
        } else {

            // Step 2: Find the next greater element and swap it with arr[ind]:
            for (int i = n - 1; i >= 0; i--) {
                if (arr[i] > arr[index1]) {
                    index2 = i;
                    break;
                }
            }

            swap(arr, index1, index2);

            // Step 3: Reverse the elements after the break point:
            reverse(arr, index1 + 1, n - 1);

            printArr(arr);
        }

    }

    public static void main(String[] args) {
        int[] arr = { 2, 1, 5, 4, 3, 0, 0 };
        nextPermutation(arr);
    }
}

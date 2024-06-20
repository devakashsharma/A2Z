public class My08_linearSearch {
    // print method
    static void printArray(int[] arr) {
        System.out.print("Array: [ ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.print("]\n");
    }

    // find x
    static boolean linearSearch(int[] arr, int x) {
        for (int i = 0; i < arr.length; i++) {
            if (x == arr[i])
                return true;
        }

        return false;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6 };
        System.out.println(linearSearch(arr, 7));
    }
}

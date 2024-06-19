public class My03_isSort {
    // Brute Force Approach
    // TC - O(N^2), SC - O(1)
    static boolean isSortedBrute(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[i])
                return false;
            }
        }
        
        return true;
    }
    
    //  Optimal Approach
    // TC - O(N), SC - O(1)
    static boolean isSortedOptimal(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[++i]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        // int[] arr = { 2, 6, 8, 1, 4, 9, 10, 11 };
        int[] arr = { 1, 2, 3, 4, 5 };
        System.out.println(isSortedBrute(arr));
        System.out.println(isSortedOptimal(arr));
    }
}

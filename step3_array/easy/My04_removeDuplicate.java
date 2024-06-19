import java.util.HashSet;

public class My04_removeDuplicate {
    // print method
    static void printArray(int[] arr) {
        System.out.print("Array: [ ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.print("]\n");
    }

    // Brute Force
    // TC - O(N), SC - O(N)
    static void removeBrute(int[] arr) {
        HashSet<Integer> hSet = new HashSet<>();
        for (int i = 0; i < arr.length; i++) hSet.add(arr[i]);
        System.out.println(hSet);
        System.out.println("Total unique element is: " + hSet.size());
    }

    // Optimal Force
    // TC - O(N), SC - O(N)
    static int optimalRemove(int[] arr) {
        int num = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[num]) {
                arr[++num] = arr[i];
            }
        }

        return num + 1;
    }

    public static void main(String[] args) {
        // int[] arr = { 4, 6, 2, 2, 6, 8, 1, 4};
        int[] arr = { 1, 1, 2};
        removeBrute(arr);
    }
}

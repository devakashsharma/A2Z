import java.util.HashSet;

public class My09_union {
    // print method
    static void printArray(int[] arr) {
        System.out.print("Array: [ ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.print("]\n");
    }

    // union
    static void unionArray(int[] arr1, int[] arr2) {
        HashSet<Integer> hSet = new HashSet<>();
        int n1 = arr1.length;
        int n2 = arr2.length;
        int max = Math.max(n1, n2);

        for (int i = 0; i < max; i++) {
            if (i < n1) hSet.add(arr1[i]);
            if (i < n2) hSet.add(arr2[i]);
        }
        
        System.out.println(hSet);
    }

    public static void main(String[] args) {
        int[] arr1 = { 1, 2, 3, 4, 5, 6 };
        int[] arr2 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0 };

        unionArray(arr1, arr2);
    }
}

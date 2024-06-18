import java.util.Arrays;

public class My02_secondLargest {
    // Brute Force
    // TC - O(N*Log(N)), SC - O(1)
    static void bruteFor(int[] arr) {
        Arrays.sort(arr);
        System.out.println("Second Smallest: " + arr[1]);
        System.out.println("Second Largest: " + arr[arr.length - 2]);
    }
    
    // Better Approach
    // TC - O(N), SC - O(1)
    static void betterSecond(int[] arr) {
        int small = Integer.MAX_VALUE;
        int secondSmall = Integer.MAX_VALUE;
        int large = Integer.MIN_VALUE;
        int secondLarge = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            small = Math.min(small, arr[i]);
            large = Math.max(large, arr[i]);
        }
        
        for (int i = 0; i < arr.length; i++) {
            if (secondSmall > arr[i] && arr[i] != small) secondSmall = arr[i];
            if (secondLarge < arr[i] && arr[i] != large) secondLarge = arr[i];
        }

        System.out.println("Second Smallest: " + secondSmall);
        System.out.println("Second Largest: " + secondLarge);
    }

    // Optimal Approach

    // Second Small Method
    // TC - O(N), SC - O(1)
    static void opSmall(int[] arr) {
        int small = Integer.MAX_VALUE;
        int secondSmall = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < small) {
                secondSmall = small;
                small = arr[i];
            } else if (arr[i] < secondSmall && arr[i] != small) secondSmall = arr[i];
        }

        System.out.println("Second Smallest: " + secondSmall);
    }

    // Second Largest Method
    // TC - O(N), SC - O(1)
    static void opLarge(int[] arr) {
        int large = Integer.MIN_VALUE;
        int secondLarge = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > large) {
                secondLarge = large;
                large = arr[i];
            } else if (arr[i] > secondLarge && arr[i] != large) secondLarge = arr[i];
        }

        System.out.println("Second Largest: " + secondLarge);
    }

    public static void main(String[] args) {
        int[] arr = { 2, 6, 8, 1, 4, 9, 10, 11};
        
        // Brute force
        bruteFor(arr);

        // Better
        betterSecond(arr);
        
        // Optimal
        opSmall(arr);
        opLarge(arr);
    }
}

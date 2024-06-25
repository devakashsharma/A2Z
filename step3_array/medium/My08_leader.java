import java.util.ArrayList;
import java.util.Collections;

public class My08_leader {

    // print array
    static void printArr(int[] arr) {
        System.out.print("Array: [ ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("]");
    }

    // Brute Force
    // TC - O(N^2), SC - O(N)
    static void leader(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> arrList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            boolean leader = true;
            for (int j = i + 1; j < n; j++) {
                if (arr[i] < arr[j]) {
                    leader = false;
                    break;
                }
            }

            if (leader)
                arrList.add(arr[i]);

        }

        System.out.println(arrList);
    }

    // Optimal
    // TC - O(N), SC - O(N)
    static void optimalLeader(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> opList = new ArrayList<>();
        int max = arr[n - 1];
        opList.add(arr[n - 1]);
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] > max) {
                opList.add(arr[i]);
                max = arr[i];
            }
        }

        // Collections.reverse(opList);
        Collections.sort(opList, Collections.reverseOrder());

        System.out.println(opList);
    }

    public static void main(String[] args) {
        int[] arr = { 10, 22, 12, 3, 0, 6 };
        leader(arr);
        optimalLeader(arr);
    }
}

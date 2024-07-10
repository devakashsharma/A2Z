import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class My04_fourSum {
    // print list
    static void printList(List<List<Integer>> li) {
        for (List<Integer> it : li) {
            System.out.print("[");
            for (Integer i : it) {
                System.out.print(i + " ");
            }
            System.out.print("] ");
        }
        System.out.println();
    }

    // Brute Force
    // TC - O(N^4), SC - O(2 * no. of the quadruplets)
    static void bruteSum(int[] arr, int target) {
        int n = arr.length;
        Set<List<Integer>> hSet = new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    for (int l = k + 1; l < n; l++) {
                        if (arr[i] + arr[j] + arr[k] + arr[l] == target) {
                            List<Integer> temp = Arrays.asList(arr[i], arr[j], arr[k], arr[l]);
                            // temp.sort(null);
                            Collections.sort(temp);
                            hSet.add(temp);
                        }
                    }
                }
            }
        }

        List<List<Integer>> li = new ArrayList<>(hSet);
        printList(li);
    }

    // Better
    // TC - O(N^3 * LogN), SC - O(N) + O(quads) x 2
    static void betterSum(int[] arr, int target) {
        int n = arr.length;
        Set<List<Integer>> st = new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                Set<Integer> hSet = new HashSet<>();
                for (int k = j + 1; k < n; k++) {
                    int sum = arr[i] + arr[j] + arr[k];
                    int fourth = target - sum;

                    if (hSet.contains(fourth)) {
                        List<Integer> temp = Arrays.asList(arr[i], arr[j], arr[k], fourth);
                        Collections.sort(temp);
                        // other ways to sort
                        // temp.sort(null);
                        // temp.sort(Integer::compareTo);
                        st.add(temp);
                    }

                    hSet.add(arr[k]);
                }
            }
        }

        List<List<Integer>> li = new ArrayList<>(st);
        printList(li);
    }

    // Optimal Approach
    static void optimalSum(int[] arr, int target) {
        int n = arr.length;
        List<List<Integer>> li = new ArrayList<>();

        Arrays.sort(arr);

        for (int i = 0; i < n; i++) {
            if (i > 0 && arr[i] == arr[i - 1])
                continue;
            for (int j = i + 1; j < n; j++) {
                if (j > i && arr[j] == arr[j - 1])
                    continue;

                int k = j + 1;
                int l = n - 1;

                while (k < l) {
                    int sum = arr[i] + arr[j] + arr[k] + arr[l];
                    if (sum == target) {
                        List<Integer> temp = Arrays.asList(arr[i], arr[j], arr[k], arr[l]);
                        li.add(temp);
                        k++;
                        l--;

                        while (k < l && arr[k] == arr[k - 1])
                            k++;
                        while (k < l && arr[l] == arr[l + 1])
                            l--;
                    } else if (sum < target)
                        k++;
                    else
                        l--;
                }
            }
        }

        printList(li);
    }

    public static void main(String[] args) {
        int[] arr = { 1, 0, -1, 0, -2, 2 };
        // int[] nums = {4, 3, 3, 4, 4, 2, 1, 2, 1, 1};
        int target = 0;

        // Methods
        bruteSum(arr, target);
        betterSum(arr, target);
        optimalSum(arr, target);
    }
}

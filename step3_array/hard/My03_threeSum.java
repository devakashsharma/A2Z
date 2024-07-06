import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class My03_threeSum {
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

    // Brute force
    // TC - O(N^3), SC - O(2*N)
    static List<List<Integer>> bruteThree(int[] arr) {
        int n = arr.length;
        Set<List<Integer>> st = new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (arr[i] + arr[j] + arr[k] == 0) {
                        List<Integer> temp = Arrays.asList(arr[i], arr[j], arr[k]);
                        temp.sort(null);
                        st.add(temp);
                    }
                }
            }
        }

        List<List<Integer>> li = new ArrayList<>(st);
        return li;
    }

    // Better Approach
    // TC - O(N2 * log(no. of unique triplets)), where N = size of the array, SC -
    // O(2 * no. of the unique triplets) + O(N)
    static List<List<Integer>> betterSum(int[] arr) {
        int n = arr.length;
        Set<List<Integer>> hSet = new HashSet<>();

        for (int i = 0; i < n; i++) {

            Set<Integer> elementSet = new HashSet<>();

            for (int j = i + 1; j < n; j++) {

                int third = -(arr[i] + arr[j]);

                if (elementSet.contains(third)) {
                    List<Integer> temp = Arrays.asList(arr[i], arr[j], third);
                    temp.sort(null);
                    hSet.add(temp);
                }

                elementSet.add(arr[j]);
            }
        }
        List<List<Integer>> li = new ArrayList<>(hSet);
        return li;
    }

    // Optimal
    // TC - O(NlogN)+O(N2), SC - O(no. of quadruplets),
    static List<List<Integer>> optimalSum(int[] arr) {
        int n = arr.length;
        List<List<Integer>> li = new ArrayList<>();
        Arrays.sort(arr);

        for (int i = 0; i < n; i++) {
            if (i != 0 && arr[i] == arr[i - 1])
                continue;

            int j = i + 1;
            int k = n - 1;

            while (j < k) {
                int sum = arr[i] + arr[j] + arr[k];
                if (sum < 0) {
                    j++;
                } else if (sum > 0) {
                    k--;
                } else {
                    List<Integer> temp = Arrays.asList(arr[i], arr[j], arr[k]);
                    li.add(temp);
                    j++;
                    k--;

                    while (j < k && arr[j] == arr[j - 1])
                        j++;
                    while (j < k && arr[k] == arr[k + 1])
                        k--;
                }
            }
        }

        return li;
    }

    public static void main(String[] args) {
        int[] arr = { -1, 0, 1, 2, -1, -4 };

        // Brute
        // List<List<Integer>> li = bruteThree(arr);
        // System.out.println(li);

        // Better
        // List<List<Integer>> li = betterSum(arr);
        // printList(li);

        // Better
        List<List<Integer>> li = optimalSum(arr);
        printList(li);
    }
}

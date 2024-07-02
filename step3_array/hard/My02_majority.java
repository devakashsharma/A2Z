import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class My02_majority {
    // Print List
    static void printList(List<Integer> li) {
        for (int item : li) {
            System.out.println(item);
        }
    }

    // My Approach
    // TC - O(N^2), SC - O(1)
    static void myMajority(int[] nums) {
        int n = nums.length;

        List<Integer> li = new ArrayList<>();
        if (nums.length < 3) {
            for (int i = 0; i < n; i++) {
                li.add(nums[i]);
            }
            printList(li);
            // return li;
        } else {

            for (int i = 0; i < n - 1; i++) {
                int count = 0;
                for (int j = i + 1; j < n; j++) {
                    if (nums[i] == nums[j])
                        count++;
                }

                if (count >= (n / 3))
                    li.add(nums[i]);
            }

            printList(li);
            // return li;
        }
    }

    // Brute Force
    // TC - O(N^2), SC - O(1)
    static void bruteMajority(int[] arr) {
        int n = arr.length;

        List<Integer> li = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            // selected element is arr[i]:
            // Checking if arr[i] is not already
            // a part of the answer:
            if (li.size() == 0 || li.get(0) == arr[i]) {
                int count = 0;
                for (int j = 0; j < n; j++) {
                    if (arr[i] == arr[j])
                        count++;
                }
                if (count > (n / 3)) 
                    li.add(arr[i]);
            }
            if (li.size() == 2) break;
        }

        printList(li);
    }

    // Better solution
    // TC - O(N*LogN), SC = O(N)
    static void betterMajority(int[] arr) {
        int n = arr.length;

        List<Integer> li = new ArrayList<>();
        HashMap<Integer, Integer> hMap = new HashMap<>();

        int mini = (n / 3) + 1;

        for (int i = 0; i < n; i++) {
            int value = hMap.getOrDefault(arr[i], 0);
            hMap.put(arr[i], value + 1);

            if (hMap.get(arr[i]) == mini) li.add(arr[i]);
            if (li.size() == 2) break;
        }

        printList(li);
    }

    // Optimal
    // TC - O(N), SC - O(1)
    static void optimalMajority(int[] arr) {
        int n = arr.length;
        int count1 = 0, count2 = 0;
        int element1 = Integer.MIN_VALUE;
        int element2 = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            if (count1 == 0 && element2 != arr[i]) {
                count1 = 1;
                element1 = arr[i];
            } else if (count2 == 0 && element1 != arr[i]) {
                count2 = 1;
                element2 = arr[i];
            } else if (arr[i] == element1) {
                count1++;
            } else if (arr[i] == element2) {
                count2++;
            } else {
                count1--;
                count2--;
            }
        }

        List<Integer> li = new ArrayList<>();

        count1 = 0;
        count2 = 0;

        // now check if which element is max
        for (int i = 0; i < n; i++) {
            if (element1 == arr[i]) count1++;
            if (element2 == arr[i]) count2++;
        }

        // minimum number
        int mini = (n / 3) + 1;
        if (count1 >= mini) li.add(element1);
        if (count2 >= mini) li.add(element2);

        printList(li);
    }

    public static void main(String[] args) {
        int[] arr = { 3, 2, 3 };
        bruteMajority(arr);
        betterMajority(arr);
        optimalMajority(arr);
    }
}

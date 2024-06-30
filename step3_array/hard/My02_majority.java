import java.util.ArrayList;
import java.util.List;

public class My02_majority {
    // Print List
    static void printList(List<Integer> li) {
        for (int item : li) {
            System.out.println(item);
        }
    }
    // Brute Force
    // TC - O(N^2), SC - O(1)
    static void bruteMajority(int[] nums) {
        int n = nums.length;

        List<Integer> li = new ArrayList<>();
        if (nums.length < 3) {
            for (int i = 0; i < n; i++) {
                li.add(nums[i]);
            }
            printList(li);
            // return li; 
        }

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

    public static void main(String[] args) {
        int[] arr = {3, 2, 3};
        bruteMajority(arr);
    }
}

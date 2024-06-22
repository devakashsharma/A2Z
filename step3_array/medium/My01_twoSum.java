// import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class My01_twoSum {
    // Brute Force Approach - variant 1
    // TC - O(N^2), SC - O(1)
    static String twoSum(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if (arr[i] + arr[j] == target) return "Yes";
            }
        }

        return "No";
    }

    // variant - 2
    static int[] twoSumV2(int[] arr, int target) {
        int[] num = {-1, -1};
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if (arr[i] + arr[j] == target) {
                    num[0] = i;
                    num[1] = j;
                    return num;
                }
            }
        }
        return num;
    }

    // better approach
    static int[] betterSum(int[] arr, int target) {
        int[] num = {-1, -1};
        HashMap<Integer, Integer> mpp = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int ans = arr[i];
            int remain = target - ans;
            if (mpp.containsKey(remain)) {
                // if variant 1 then -
                // return "Yes"; else "No"
                num[0] = mpp.get(remain);
                num[1] = i;
                return num;
            }

            mpp.put(arr[i], i);
        }

        return num;
    }

    // Optimal
    static String optimalSum(int[] arr, int target) {
        Arrays.sort(arr);
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int sum = arr[left] + arr[right];
            if (sum == target) return "Yes";
            else if (sum < target) left++;
            else right--;
        }
        return "No";
    }

    public static void main(String[] args) {
        int[] arr = { 3, 6, 2, 7, 4, 6 };
        int target = 6;
        System.out.println(twoSum(arr, target));

        int[] ans = twoSumV2(arr, target);
        System.out.println("Index: [ " + ans[0] + ", " + ans[1] + " ]");

        int[] better = betterSum(arr, target);
        System.out.println("Index: [ " + better[0] + ", " + better[1] + " ]");

        System.out.println(optimalSum(arr, target));
    }
}

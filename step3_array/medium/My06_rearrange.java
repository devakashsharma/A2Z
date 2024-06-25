import java.util.ArrayList;

public class My06_rearrange {
    // print array
    static void printArr(int[] arr) {
        System.out.print("Array: [ ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("]");
    }

    // VARIANT - 1
    // Equal positives and negatives numbers

    // Brute Force
    // TC - O(N) + O(N) = O(N), SC - O(N)
    static int[] rearrange(int[] arr) {
        int n = arr.length;

        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (arr[i] > 0)
                pos.add(arr[i]);

            else
                neg.add(arr[i]);
        }

        for (int i = 0; i < n / 2; i++) {
            arr[2 * i] = pos.get(i);
            arr[2 * i + 1] = neg.get(i);
        }

        return arr;
    }

    // optimal
    // TC - O(N), SC - O(N)
    static int[] optimalRearrange(int[] arr) {
        int n = arr.length;
        int posIndex = 0, negIndex = 1;
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            if (arr[i] > 0) {
                nums[posIndex] = arr[i];
                posIndex += 2;
            } else {
                nums[negIndex] = arr[i];
                negIndex += 2;
            }
        }

        return nums;
    }

    // VARIANT - 2
    // Not equal positives and negatives numbers

    // Brute Force
    static int[] var2Rearrange(int[] arr) {
        int n = arr.length;

        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (arr[i] > 0)
                pos.add(arr[i]);
            else
                neg.add(arr[i]);
        }

        if (pos.size() > neg.size()) {
            for (int i = 0; i < neg.size(); i++) {
                arr[2 * i] = pos.get(i);
                arr[2 * i + 1] = neg.get(i);
            }

            int index = neg.size() * 2;
            for (int i = neg.size(); i < pos.size(); i++) {
                arr[index] = pos.get(i);
                index++;
            }
        } else {
            for (int i = 0; i < pos.size(); i++) {
                arr[2 * i] = pos.get(i);
                arr[2 * i + 1] = neg.get(i);
            }

            int index = pos.size() * 2;
            for (int i = pos.size(); i < neg.size(); i++) {
                arr[index] = neg.get(i);
                index++;
            }
        }

        return arr;
    }

    public static void main(String[] args) {

        // VARIANT - 1

        int[] arr = { 1, 2, -4, -5 };
        int[] num = rearrange(arr);
        printArr(num);

        int[] nums = rearrange(arr);
        printArr(nums);

        // VARIANT - 2

        int[] arr2 = { 1, 2, -4, -5, 3, 4 };
        int[] nums2 = var2Rearrange(arr2);
        printArr(nums2);
    }
}

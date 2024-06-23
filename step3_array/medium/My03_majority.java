import java.util.HashMap;
import java.util.Map;

public class My03_majority {

    // Brute Force
    // TC - O(N^2), SC - O(1)
    static int bruteMajorityElement(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (arr[i] == arr[j]) {
                    count++;
                }
            }
            if (count >= n / 2) {
                return arr[i];
            }
        }

        return -1;
    }

    // Better
    // TC - O(N*logN) + O(N), SC - O(N)
    static int betterMajority(int[] arr) {
        int n = arr.length;

        HashMap<Integer, Integer> hMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int value = hMap.getOrDefault(arr[i], 0);
            hMap.put(arr[i], value + 1);
        }

        for (Map.Entry<Integer, Integer> mp : hMap.entrySet()) {
            if (mp.getValue() > (n / 2))
                return mp.getKey();
        }
        return -1;
    }

    // Optimal - Moore’s Voting Algorithm
    static int optimalMajority(int[] arr) {
        int n = arr.length;
        int element = 0;
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (count == 0) {
                count = 1;
                element = arr[i];
            } else if (element == arr[i])
                count++;
            else
                count--;
        }

        int count2 = 0;

        for (int i = 0; i < n; i++) {
            if (element == arr[i])
                count2++;
        }

        if (count2 > (n / 2))
            return element;

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = { 2, 2, 1, 1, 1, 2, 2 };
        System.out.println(bruteMajorityElement(arr));
        System.out.println(betterMajority(arr));
        System.out.println(optimalMajority(arr));
    }
}

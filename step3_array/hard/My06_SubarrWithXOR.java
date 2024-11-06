import java.util.HashMap;
import java.util.Map;

public class My06_SubarrWithXOR {
    // Brute Force
    static void bruteWithXOR(int[] arr, int k) {
        int n = arr.length; //size of the given array.
        int count = 0;

        // Step 1: Generating subarrays:
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {

                //step 2:calculate XOR of all
                // elements:
                int xorr = 0;
                for (int K = i; K <= j; K++) {
                    xorr = xorr ^ arr[K];
                }

                // step 3:check XOR and count:
                if (xorr == k) count++;
            }
        }
        System.out.println(count);
    }

    // better
    static void betterWithXOR(int[] arr, int k) {
        int n = arr.length; // size of the given array.
        int count = 0;

        // Step 1: Generating subarrays:
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {

                // step 2:calculate XOR of all
                // elements:
                int xorr = 0;
                xorr = xorr ^ arr[j];

                // step 3:check XOR and count:
                if (xorr == k)
                    count++;
            }
        }
        System.out.println(count);
    }

    // optimal
    static void optimalWithXOR(int[] arr, int k) {
        int n = arr.length;
        int xor = 0;
        Map<Integer, Integer> mpp = new HashMap<>();
        mpp.put(xor, 1);
        int count = 0;

        for (int i = 0; i < n; i++) {
            xor = xor ^ arr[i];
            int x = xor ^ k;

            if (mpp.containsKey(x)) {
                count += mpp.get(x);
            }

            if (mpp.containsKey(xor)) {
                mpp.put(xor, mpp.get(xor) + 1);
            } else {
                mpp.put(xor, 1);
            }
        }

        System.out.println(count);
    }

    public static void main(String[] args) {
        int[] arr = {4, 2, 2, 6, 4};
        int k = 6;
        bruteWithXOR(arr, k);
        betterWithXOR(arr, k);
        optimalWithXOR(arr, k);
    }
}

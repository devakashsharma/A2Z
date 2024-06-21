import java.util.HashMap;
import java.util.Map;

public class My14_subarrayPosNeg {
    // better
    static int betterArr(int[] arr, int k) {
        int n = arr.length;

        Map<Integer, Integer> sumMap = new HashMap<>();
        int max = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];

            if (sum == k)
                max = Math.max(max, i + 1);

            int remain = sum - k;

            if (sumMap.containsKey(remain)) {
                int len = i - sumMap.get(remain);
                max = Math.max(max, len);
            }

            if (!sumMap.containsKey(sum))
                sumMap.put(sum, i);
        }

        return max;
    }

    public static void main(String[] args) {
        int[] arr = { 2, 3, 5, 1, 9 };
        System.out.println(betterArr(arr, 10));
    }
}

import java.util.Arrays;

public class My08_aggressiveCow {

    // methods to find the distance
    static boolean isItPossibleCow(int[] arr, int dist, int cows) {
        int countCows = 1;
        int last = arr[0];

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] - last >= dist) {
                countCows++;
                last = arr[i];
            }

            if (countCows >= cows)
                return true;
        }

        return false;
    }

    // methods to find the aggressive cow
    static int aggressiveCows(int[] arr, int cows) {
        int n = arr.length;

        Arrays.sort(arr);

        int low = 1, high = arr[n - 1] - arr[0];

        while (low <= high) {
            int mid = (low + high) / 2;
            if (isItPossibleCow(arr, mid, cows)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return high;
    }

    public static void main(String[] args) {
        int[] stalls = {0, 3, 4, 7, 10, 9};
        int k = 4;
        System.out.println(aggressiveCows(stalls, k));
    }
}

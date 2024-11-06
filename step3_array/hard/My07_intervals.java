import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class My07_intervals {

    // optimal
    // TC - O(N), SC - O(N)
    static void mergeIntervals(int[][] arr) {
        int n = arr.length;

        // sort the given intervals:
        Arrays.sort(arr, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });

        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (list.isEmpty() || arr[i][0] > list.get(list.size() - 1).get(1)) {
                list.add(Arrays.asList(arr[i][0], arr[i][1]));
            } else {
                list.get(list.size() - 1).set(1, Math.max(list.get(list.size() - 1).get(1), arr[i][1]));
            }
        }

        System.out.println(list);
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 3}, {8, 10}, {2, 6}, {15, 18}};
        mergeIntervals(arr);
    }
}

public class My10_painters {
    // methods to find the pages
    static boolean isValid(int[] arr, int m, int maxAllowed) {
        int student = 1, pages = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > maxAllowed) {
                return false;
            }

            if (pages + arr[i] <= maxAllowed) {
                pages += arr[i];
            } else {
                student++;
                pages = arr[i];
            }
        }

        return student > m ? false : true;
    }

    // main methods - painter partition / split arrays
    static int paintersPartition(int [] arr, int m) {
        if (arr.length < m) {
            return -1;
        }

        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }

        int ans = -1;
        int low = 0, high = sum;

        while(low <= high) {
            int mid = low + (high - low) / 2;

            if (isValid(arr, m, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }    

    public static void main(String[] args) {
        // int[] arr = {12, 34, 67, 90};
        int[] arr = {2, 1, 3, 4};
        int m = 2;
        System.out.println(paintersPartition(arr, m));
    }
}

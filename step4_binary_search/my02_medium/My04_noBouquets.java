public class My04_noBouquets {

    // methods to calculate the days
    static boolean possibleDays(int[] arr, int days, int m, int k) {
        int totalDays = 0;
        int noOfBouquets = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= days) {
                totalDays++;
            } else {
                noOfBouquets += (totalDays / k);
                totalDays = 0;
            }
        }
        
        noOfBouquets += (totalDays / k);
        return noOfBouquets >= m;
    }

    // methods to find the number of bouquets
    static int noOfBouquets(int[] arr, int k, int m) {
        int n = arr.length;
        if (n < m * k) {
            return -1;
        }

        int mini = Integer.MAX_VALUE, maxi = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            mini = Math.min(mini, arr[i]);
            maxi = Math.max(maxi, arr[i]);
        }

        int low = mini, high = maxi;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (possibleDays(arr, mid, m, k)) high = mid - 1;
            else low = mid + 1;
        }

        return low;
    }

    public static void main(String[] args) {
        int[] arr = {7, 7, 7, 7, 13, 11, 12, 7};
        int k = 3;
        int m = 2;

        int ans = noOfBouquets(arr, k, m);
        
        if (ans == -1)
            System.out.println("We cannot make m bouquets.");
        else
            System.out.println("We can make bouquets on day " + ans);
    }
}

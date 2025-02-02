// import java.util.Arrays;

public class My09_bookAllocation {

    // methods to find the pages
    // static boolean isItPossiblePage(int [] arr, int page) {
    //     int countPage = 1;

    //     return false;
    // }

    // static int allocationPages(int [] arr, int m) {
    //     Arrays.sort(arr);

    //     int low = 0, high = 1;

    //     while (low <= high) {
    //         int mid = (low + high) / 2;
    //         if (isItPossiblePage(arr, mid)) {
    //             low = mid + 1;
    //         } else {
    //             high = mid - 1;
    //         }
    //     }

    //     return -1;
    // }

    public int allocateBooks(int[] arr, int m) {
        // Edge case: If number of students is greater than number of books
        if (m > arr.length) {
            return -1;
        }

        int low = 0; // Minimum possible answer (maximum pages in a single book)
        int high = 0; // Maximum possible answer (sum of all pages)
        for (int pages : arr) {
            low = Math.max(low, pages);
            high += pages;
        }

        int result = -1;

        // Binary search to find the minimum possible maximum pages
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isPossible(arr, m, mid)) {
                result = mid;
                high = mid - 1; // Try to find a smaller maximum
            } else {
                low = mid + 1; // Increase the maximum
            }
        }

        return result;
    }

    // Helper function to check if it's possible to allocate books with a given maximum
    private boolean isPossible(int[] arr, int m, int maxPages) {
        int students = 1;
        int currentSum = 0;

        for (int pages : arr) {
            currentSum += pages;
            if (currentSum > maxPages) {
                students++;
                currentSum = pages;
            }
        }

        return students <= m;
    }

    public static void main(String[] args) {
        My09_bookAllocation bookAllocation = new My09_bookAllocation();
        int[] arr = {12, 34, 67, 90};
        int m = 2;
        System.out.println(bookAllocation.allocateBooks(arr, m));
    }
}

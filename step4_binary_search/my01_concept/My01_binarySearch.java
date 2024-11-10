public class My01_binarySearch {
    // iterative approach
    static int iterativeSearch(int[] nums, int target) {
        int n = nums.length;
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] < target)
                low = mid + 1;
            else
                high = mid - 1;
        }

        return -1;
    }

    // recursive approach
    static int recSearch(int[] arr, int low, int high, int target) {
        if (low > high)
            return -1;

        int mid = (low + high) / 2;

        if (arr[mid] == target)
            return mid;
        else if (target > arr[mid])
            return recSearch(arr, mid + 1, high, target);
        
        return recSearch(arr, low, high, target);
    }

    // call recursive search
    static int recursiveSearch(int[] arr, int target) {
        return recSearch(arr, 0, arr.length - 1, target);
    }

    public static void main(String[] args) {
        int[] arr = { -1, 0, 3, 5, 9, 12 };
        int target = 9;

        int ans = iterativeSearch(arr, target);

        int rec = recursiveSearch(arr, target);

        System.out.println("Iterative Approach: " + ans);
        System.out.println("Recursive Approach: " + rec);

        // The time complesity will be
        // O(logN)
    }

}

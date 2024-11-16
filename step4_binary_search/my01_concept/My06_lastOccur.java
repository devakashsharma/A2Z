public class My06_lastOccur {
    // first occurance
    static int firstOccurance(int[] arr, int x) {
        int n = arr.length;
        int ans = n;
        int low = 0, high = n - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] >= x) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    // last Occurance
    static int lastOccurance(int[] arr, int x) {
        int n = arr.length;
        int ans = n;
        int low = 0, high = n - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] > x) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    // First and Last Occurance
    static int[] firstLast(int[] arr, int x) {
        int n = arr.length;
        int first = firstOccurance(arr, x);
        
        if(first == n || arr[first] != x) return new int[] {-1, -1};
        
        int last = lastOccurance(arr, x) - 1;

        return new int[] {first, last};
    }

    public static void main(String[] args) {
        int[] arr = {3,4,13,13,13,20,40};
        int target = 13;

        int[] num = firstLast(arr, target);

        System.out.println("First and Last are:[ " + num[0] + ", " + num[1] + " ]");
    }
}

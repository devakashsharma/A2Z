public class My07_countOccurance {

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


    // Count Occurance
    static int countOccurance(int[] arr, int x) {
        int[] cntArr = firstLast(arr, x);

        if (cntArr[0] == -1) return -1;

        return (cntArr[1] - cntArr[0] + 1);
    }

    public static void main(String[] args) {
        int[] arr = { 2, 2, 3, 3, 3, 3, 4 };
        int x = 3;

        System.out.println(countOccurance(arr, x));
    }
}

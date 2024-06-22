import java.util.ArrayList;

public class My02_sort {
    // print array
    static void printArr(int[] arr) {
        System.out.print("Array: [ ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("]");
    }

    // Brute Force
    static void sortNums(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        printArr(arr);
    }

    // Better Approach
    // TC - O(N), SC - O(1)
    static void betterSort(ArrayList<Integer> arr) {
        int zero = 0, one = 1;
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) == 0) zero++;
            else if (arr.get(i) == 1) one++;
        }
        
        for (int i = 0; i < zero; i++) {
            arr.set(i, 0);
        }
        
        for (int i = zero; i < (zero + one); i++) {
            arr.set(i, 1);
        }
        
        for (int i = (zero + one); i < arr.size(); i++) {
            arr.set(i, 2);
        }
        
        System.out.println(arr);
    }


    // Better Approach - In Arr
    // TC - O(N), SC - O(1)
    static void betterSortInArr(int[] arr) {
        int zero = 0, one = 0, n = arr.length;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) zero++;
            else if (arr[i] == 1) one++;
        }
        
        for (int i = 0; i < zero; i++) {
            arr[i] = 0;
        }
        
        for (int i = zero; i < (zero + one); i++) {
            arr[i] = 1;
        }
        
        for (int i = (zero + one); i < n; i++) {
            arr[i] = 2;
        }
        
        System.out.println(arr);
    }
    
    // optimal - Dutch National Flag Algorithm
    // TC - O(N), SC - O(1)
    static void optimalSort(int[] arr) {
        int low = 0, mid = 0, high = 0;
        while (mid <= high) {
            if (arr[mid] == 0) {
                int temp = arr[low];
                arr[low] = arr[mid];
                arr[mid] = temp;
                low++;
                mid++;
            } else if (arr[mid] == 1) mid++;
            else {
                int temp = arr[high];
                arr[high] = arr[mid];
                arr[mid] = temp;
                high--;
            }
        }

        printArr(arr);
    }

    public static void main(String[] args) {
        int[] arr = { 0, 1, 2, 0, 0, 2 };
        sortNums(arr);
        ArrayList<Integer> arrList = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            arrList.add(arr[i]);
        }
        betterSort(arrList);

        int[] arr2 = {2,0,2,1,1,0};
        optimalSort(arr2);
    }
}

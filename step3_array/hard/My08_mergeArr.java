import java.util.Arrays;

public class My08_mergeArr {

    // print method
    static void printArr(int[] arr) {
        System.out.print("[ ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println(" ]");
    }
    
    static void mergeArr(int[] arr1, int[] arr2) {
        int n1 = arr1.length;
        int n2 = arr2.length;

        int left = n1 - 1;
        int right = 0;

        while (left >= 0 && right <= n2) {
            if (arr1[left] > arr2[right]) {
                int temp = arr1[left];
                arr1[left] = arr2[right];
                arr2[right] = temp;
                left--;
                right++;
            } else {
                break;
            }
        }

        Arrays.sort(arr1);
        Arrays.sort(arr2);
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 4, 8, 10};
        int[] arr2 = {2, 3, 9};

        mergeArr(arr1, arr2);
        printArr(arr1);
        printArr(arr2);

    }
}

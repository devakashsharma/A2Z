public class My12_noRepeat {
    static void nonRepeat(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            int count = 0;
            for (int j = 0; j < arr.length; j++) {
                if (num == arr[j]) count++;
            }

            if (count == 1) System.out.println("Non Repeat: " + num);
        }
    }

    public static void main(String[] args) {
        int[] arr = { 4, 6, 2, 2, 6, 8, 1, 4, 1 };
        nonRepeat(arr);
    }
}

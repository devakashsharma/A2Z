public class My11_maxCons {

    // TC - O(N), SC - O(1)
    static void maxCons(int[] arr) {
        int cons = 0;
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) max++;
            else max = 0;
            cons = Math.max(cons, max);
        }
        
        System.out.println(cons);
    }

    public static void main(String[] args) {
        int[] arr = { 1, 0, 0, 1, 1, 1, 0, 1, 1 };
        maxCons(arr);
    }
}

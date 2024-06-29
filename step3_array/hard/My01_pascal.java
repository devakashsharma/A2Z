import java.util.ArrayList;
import java.util.List;

public class My01_pascal {

    // ncr formula
    static long nCr(int r, int c) {
        long res = 1;
        for (int i = 0; i < c; i++) {
            res = res * (r - i);
            res = res / (i + 1);
        }

        return res;
    }

    // Variant 1 - print a single given element

    // pascal
    // TC - O(c) (c = no of column), SC - O(1)
    static int var1Pascal(int r, int c) {
        int element = (int) nCr(r - 1, c - 1);
        return element;
    }

    // Variant 2 - print the given row

    // Brute Force
    // TC - O(n*r), SC - O(1)
    static void var2BrutePascal(int n) {
        // print the given row
        for (int i = 1; i <= n; i++) {
            System.out.print(nCr(n - 1, i - 1) + " ");
        }

        System.out.println();
    }

    // Optimal Approach
    // TC - O(n), SC - O(1)
    static void var2OptimalPascal(int n) {
        long res = 1;

        System.out.print(res + " ");
        for (int i = 1; i < n; i++) {
            res = res * (n - i);
            res = res / i;
            System.out.print(res + " ");
        }
        System.out.println();
    }

    // Variant 3 - Print the entire array/list

    // Brute Force
    // TC - O(n*n*r) ~ O(n3), SC - O(1)
    static void var3BrutePascal(int n) {
        List<List<Integer>> li = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j = 1; j <= i; j++) {
                temp.add((int) nCr(i - 1, j - 1));
            }

            li.add(temp);
        }

        // Print Pascal's Triangle
        // System.out.println(li);
        for (List<Integer> row : li) {
            System.out.println(row);
        }
    }

    // Optimal 
    // TC - O(N^2), SC - O(1)
    static List<Integer> generateRow(int row) {
        long res = 1;
        List<Integer> ans = new ArrayList<>();
        ans.add(1);

        for (int col = 1; col < row; col++) {
            res = res * (row - col);
            res = res / col;
            ans.add((int) res);
        }

        return ans;
    }

    // pascal
    static void var3OptimalPascal(int n) {
        List<List<Integer>> li = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            li.add(generateRow(i));
        }

        for (List<Integer> item : li) {
            System.out.println(item);
        }
    }

    public static void main(String[] args) {
        // Variant 1
        int row = 5;
        int col = 3;
        System.out.println(var1Pascal(row, col));

        // Variant 2
        int n = 5;
        var2BrutePascal(n);
        var2OptimalPascal(n);

        // Variant 3
        var3BrutePascal(n);
        var3OptimalPascal(n);
    }
}

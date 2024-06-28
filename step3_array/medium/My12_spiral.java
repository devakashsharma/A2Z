import java.util.List;
import java.util.ArrayList;

public class My12_spiral {
    // Optimal
    // TC - O(n x m), SC - O(n)
    static void optimalSpiral(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        // declaring path
        int top = 0, bottom = n - 1;
        int left = 0, right = m - 1;

        // List to add number
        List<Integer> li = new ArrayList<>();

        while (top <= bottom && left <= right) {

            // For moving left to right
            for (int i = left; i <= right; i++) 
                li.add(matrix[top][i]);
            
            top++;

            // For moving top to bottom.
            for (int i = top; i <= bottom; i++) 
                li.add(matrix[i][right]);
            
            right--;

            // For moving right to left bottom
            if (top <= bottom) {
                for (int i = right; i >= left; i--) 
                    li.add(matrix[bottom][i]);
                
                bottom--;
            }

            // For moving bottom to top
            if (left <= right) {
                for (int i = bottom; i >= top; i--)
                    li.add(matrix[i][left]);

                left++;
            }
        }

        System.out.println(li);
    }
    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3, 4, 5},
            {6, 7, 8, 9, 10},
            {11, 12, 13, 14, 15},
            {16, 17, 18, 19, 20},
            {21, 22, 23, 24, 25},
            {26, 27, 28, 29, 30},
        };

        optimalSpiral(matrix);
    }
}

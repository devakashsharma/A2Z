public class My11_rotateMatrix {
    // Print Matrix
    static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Brute Force
    // TC - O(N^2), SC - O(N^2)
    static void bruteRotate(int[][] matrix) {
        int n = matrix.length;
        int[][] newMatrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                newMatrix[j][n - 1 - i] = matrix[i][j];
            }
        }

        printMatrix(newMatrix);
    }

    // Optimal Approach
    // TC - O(N*N) + O(N*N), SC - O(1)
    static void optimalRotate(int[][] matrix) {
        int n = matrix.length;
        // transposing the matrix
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // reversing the matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = temp;
            }
        }

        printMatrix(matrix);

    }

    public static void main(String[] args) {
        int[][] matrix = {
            { 1, 2, 3, 4 },
            { 5, 6, 7, 8 },
            { 9, 10, 11, 12 },
            { 13, 14, 15, 16 },
        };

        // bruteRotate(matrix);
        optimalRotate(matrix);
    }
}

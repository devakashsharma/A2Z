public class My10_matrixZero {
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
    // TC - O((N*M)*(N + M)) + O(N*M), SC - O(1)

    // Mark Row
    static void markRow(int[][] matrix, int col, int i) {
        for (int j = 0; j < col; j++) {
            if (matrix[i][j] != 0) {
                matrix[i][j] = -1;
            }
        }
    }

    // Mark Column
    static void markCol(int[][] matrix, int row, int j) {
        for (int i = 0; i < row; i++) {
            if (matrix[i][j] != 0) {
                matrix[i][j] = -1;
            }
        }
    }

    static void bruteMatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0) {
                    markRow(matrix, col, i);
                    markCol(matrix, row, j);
                }
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == -1)
                    matrix[i][j] = 0;
            }
        }

        printMatrix(matrix);
    }

    // Better Approach
    // TC - O(2*(N*M)), SC - O(N) + O(M)
    static void betterMatrix(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int[] row = new int[n];
        int[] col = new int[m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (row[i] == 1 || col[j] == 1) {
                    matrix[i][j] = 0;
                }
            }
        }

        printMatrix(matrix);
    }

    // Optimal Approach
    static void optimalMatrix(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int col0 = 1;

        // step 1: Traverse the matrix and
        // mark 1st row & col accordingly:
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    // mark i-th row
                    matrix[i][0] = 0;

                    // mark j-th column
                    if (j != 0)
                        matrix[0][j] = 0;
                    else
                        col0 = 0;
                }
            }
        }

        // Step 2: Mark with 0 from (1,1) to (n-1, m-1):
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] != 0) {
                    if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                        matrix[i][j] = 0;
                    }
                }
            }
        }

        // Step 3: Finally mark the 1st col & then 1st row:
        if (matrix[0][0] == 0) {
            for (int j = 0; j < m; j++) {
                matrix[0][j] = 0;
            }
        }

        if (col0 == 0) {
            for (int i = 0; i < n; i++) {
                matrix[i][0] = 0;
            }
        }

        printMatrix(matrix);
    }

    public static void main(String[] args) {
        int[][] matrix = {
                { 1, 1, 1 },
                { 1, 0, 1 },
                { 1, 1, 1 },
        };

        // bruteMatrix(matrix);
        // betterMatrix(matrix);
        optimalMatrix(matrix);
    }
}

import java.util.Scanner;

public class GaussianElimination {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of rows: ");
        int m = scanner.nextInt();
        System.out.print("Enter the number of columns: ");
        int n = scanner.nextInt();

        double[][] matrix = new double[m][n];

        System.out.println("Enter the matrix elements:");

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("Enter element matrix[" + (i + 1) + "][" + (j + 1) + "]: ");
                matrix[i][j] = scanner.nextDouble();
            }
        }

        // Perform Gaussian elimination and convert to RREF
        int lead = 0;
        for (int row = 0; row < m; row++) {
            if (lead >= n)
                break;

            int i = row;
            while (i < m && matrix[i][lead] == 0) {
                i++;
            }

            if (i == m) {
                System.out.println("No unique solution exists.");
                return;
            }

            double[] temp = matrix[row];
            matrix[row] = matrix[i];
            matrix[i] = temp;

            double lv = matrix[row][lead];
            for (int j = 0; j < n; j++) {
                matrix[row][j] /= lv;
            }

            for (i = 0; i < m; i++) {
                if (i != row) {
                    double multiplier = matrix[i][lead];
                    for (int j = 0; j < n; j++) {
                        matrix[i][j] -= multiplier * matrix[row][j];
                    }
                }
            }
            lead++;
        }

        // Print the RREF matrix
        System.out.println("Reduced Row-Echelon Form (RREF) Matrix:");

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(Math.round(matrix[i][j]) + "\t");
            }
            System.out.println();
        }

        scanner.close();
    }
}

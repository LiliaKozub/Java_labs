package lab_1;

public class Main {
    public static void main(String[] args) {
        try {
            executeMatrixOperations();
        } catch (Exception e) {
            System.err.println("Несподівана помилка: " + e.getMessage());
        }
    }

    public static void executeMatrixOperations() {
        short[][] matrixA = {
                {1, 2, 3},
                {4, 5, 6}
        };

        short[][] matrixB = {
                {7, 8},
                {9, 10},
                {11, 12}
        };

        MatrixOperations matrixOps = new MatrixOperations();

        System.out.println("Матриця А:");
        matrixOps.printMatrix(matrixA);
        System.out.println("Матриця B:");
        matrixOps.printMatrix(matrixB);
        validationCheck(matrixA, matrixB);
        matrixOps.matrixCompatibilityCheck(matrixA, matrixB);
        short[][] matrixC = matrixMultiplicationResult(matrixA, matrixB, matrixOps);
        calculateColumnAveragesResult(matrixOps, matrixC);
    }

    public static short[][] matrixMultiplicationResult(short[][] a, short[][] b, MatrixOperations obj) {
        short[][] result = obj.multiplicationOfMatrices(a, b);
        System.out.println("Результат множення матриць\nМатриця С:");
        obj.printMatrix(result);

        return result;
    }

    public static void calculateColumnAveragesResult(MatrixOperations matrixOps, short[][] resultMatrix) {
        double[] columnAverages = matrixOps.calculateColumnAverages(resultMatrix);
        System.out.println("Середнє значення елементів кожного стовпчика:");

        for (int i = 0; i < columnAverages.length; i++)
            System.out.printf("Стовпчик %d: %.2f%n", i + 1, columnAverages[i]);
    }

    public static void validationCheck(short[][] a, short[][] b) {
        if (a.length == 0 || a[0].length == 0 || b.length == 0 || b[0].length == 0)
            throw new IllegalArgumentException("Матриці не повинні бути порожніми.");

        for (short[] row : a) {
            if (row == null || row.length != a[0].length)
                throw new IllegalArgumentException("Матриця A не має однакової кількості стовпців у всіх рядках.");
        }

        for (short[] row : b) {
            if (row == null || row.length != b[0].length)
                throw new IllegalArgumentException("Матриця B не має однакової кількості стовпців у всіх рядках.");
        }
    }
}

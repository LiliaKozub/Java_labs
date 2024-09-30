package lab_1;
import java.util.Arrays;

public class MatrixOperations {

    public short[][] multiplicationOfMatrices(short[][] a, short[][] b) {
        int rowsA = a.length;
        int colsA = a[0].length;
        int colsB = b[0].length;
        short[][] result = new short[rowsA][colsB];

        for(int i = 0; i < rowsA; i++) {
            for(int j = 0; j < colsB; j++) {
                for(int k = 0; k < colsA; k++) {
                    int product = a[i][k] * b[k][j];
                    if(product < Short.MIN_VALUE || product > Short.MAX_VALUE)
                        throw new ArithmeticException("Переповнення типу short при множенні: значення " + product + " не вміщується в тип short.");
                    result[i][j] += (short) product;
                }
            }
        }

        return result;
    }

    public double[] calculateColumnAverages(short[][] c) {
        int rowsC = c.length;
        int colsC = c[0].length;
        double[] result = new double[colsC];
        int sum;

        for(int j = 0; j < colsC; j++) {
            sum = 0;
            for(int i = 0; i < rowsC; i++)
                sum += c[i][j];
            result[j] = sum / (double) rowsC;
        }

        return result;
    }

    public void printMatrix(short[][] matrix) {
        for (short[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }

    public void matrixCompatibilityCheck(short[][] a, short[][] b) {
        if(a[0].length != b.length)
            throw new IllegalArgumentException("Кількість стовпців матриці A має дорівнювати кількості рядків матриці B.");
    }
}


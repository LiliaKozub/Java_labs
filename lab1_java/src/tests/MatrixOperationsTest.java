import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import lab_1.MatrixOperations;

class MatrixOperationsTest {
    private MatrixOperations matrixOps;

    @BeforeEach
    public void setUp() {
        matrixOps = new MatrixOperations();
    }

    @Test
    public void testMultiplicationOfMatrices() {
        short[][] a = {
                {1, 2},
                {3, 4}
        };
        short[][] b = {
                {5, 6},
                {7, 8}
        };
        short[][] expected = {
                {19, 22},
                {43, 50}
        };
        short[][] result = matrixOps.multiplicationOfMatrices(a, b);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testMultiplicationOfMatricesWithOverflow() {
        short[][] a = {
                {22222, 1},
                {1, 1}
        };
        short[][] b = {
                {4, 1},
                {1, 1}
        };
        assertThrows(ArithmeticException.class, () -> {
            matrixOps.multiplicationOfMatrices(a, b);
        });
    }

    @Test
    public void testCalculateColumnAverages() {
        short[][] c = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        double[] expectedAverages = {4.0, 5.0, 6.0};
        double[] resultAverages = matrixOps.calculateColumnAverages(c);
        assertArrayEquals(expectedAverages, resultAverages);
    }

    @Test
    public void testMatrixCompatibilityCheck() {
        short[][] a = {
                {1, 2, 3},
                {4, 5, 6}
        };
        short[][] b = {
                {7, 8},
                {9, 10},
                {11, 12}
        };
        assertDoesNotThrow(() -> {
            matrixOps.matrixCompatibilityCheck(a, b);
        });

        short[][] c = {
                {1, 2},
                {3, 4},
                {5, 6}
        };
        assertThrows(IllegalArgumentException.class,() -> {
            matrixOps.matrixCompatibilityCheck(b, c);
        });
    }
}
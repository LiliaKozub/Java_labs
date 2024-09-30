import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import lab_1.MatrixOperations;
import lab_1.Main;

class MainTest {

    @Test
    public void testValidationCheckWithEmptyMatrixA() {
        short[][] matrixA = new short[0][0];
        short[][] matrixB = {
                {1, 2},
                {3, 4}
        };

        try {
            Main.validationCheck(matrixA, matrixB);
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertEquals("Матриці не повинні бути порожніми.", e.getMessage());
        }
    }

    @Test
    public void testValidationCheckWithEmptyMatrixB() {
        short[][] matrixA = {
                {1, 2},
                {3, 4}
        };
        short[][] matrixB = new short[0][0];

        try {
            Main.validationCheck(matrixA, matrixB);
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertEquals("Матриці не повинні бути порожніми.", e.getMessage());
        }
    }

    @Test
    public void testValidationCheckWithInconsistentColumnsMatrix() {
        short[][] matrixA = {
                {1, 2},
                {3, 4, 5}
        };
        short[][] matrixB = {
                {1, 2},
                {3, 4}
        };

        try {
            Main.validationCheck(matrixA, matrixB);
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertEquals("Матриця A не має однакової кількості стовпців у всіх рядках.", e.getMessage());
        }
    }
}
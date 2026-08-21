/* PACKAGES */
package calculadora;

/* CLASS MULTIPLY */

/**
 * Clase que proporciona operaciones matemáticas de multiplicación entre 2 o 3 operandos.
 *
 * @author Marcos Lambir Torres
 * @version 1.0
 */
public class Multiply {

    /* CONSTRUCTOR */
    public Multiply() {
        super();
    }

    /* STATIC METHODS */

    /**
     * Multiplicación de dos números REALES. {@link Multiply}
     *
     * @param a int primera posición a multiplicar.
     * @param b int segunda posición a multiplicar.
     * @return Multiplicación entre a y b.
     * @Example: {@code
     * double doubleMultiplyTwoParams = Multiply.doubleTwoParamsProduct(3.3, 1.5);
     * }
     */
    public static double doubleTwoParamsProduct(double a, double b) {
        return a * b;
    }

    /**
     * Multiplicación de dos números ENTEROS. {@link Multiply}
     *
     * @param a int primera posición a multiplicar.
     * @param b int segunda posición a multiplicar.
     * @return Multiplicación entre a y b.
     * @Example: {@code
     * int intMultiplyTwoParams = Multiply.intTwoParamsProduct(3, 3);
     * }
     */
    public static int intTwoParamsProduct(int a, int b) {
        return a * b;
    }

    /**
     * Multiplicación de tres números REALES. {@link Multiply}
     *
     * @param a primera posición a multiplicar.
     * @param b segunda posición a multiplicar.
     * @param c tercera posición a multiplicar.
     * @return Multiplicación entre a, b y c.
     * @Example: {@code
     * double doubleMultiplyThreeParams = Multiply.doubleTwoParamsProduct(2.3, 7.2);
     * }
     */
    public static double doubleThreeParamsProduct(double a, double b, double c) {
        return a * b * c;
    }

    /**
     * Potencia de un número. {@link Multiply}
     *
     * @param a primera posición correspondiente a la base.
     * @param b segunda posición inherente al exponente.
     * @return Exponente de a ** b.
     * @Example: {@code
     * double doubleMultiplyThreeParams = Multiply.doubleTwoParamsProduct(2.3, 7.2);
     * }
     */
    public static double doubleExponent(double a, int b) {return Math.pow(a, (double) b); }
}
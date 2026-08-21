/**
 * @author Juan Montiel (xmontiel@github.com)
 * @version 1.0
 */

package test;

import calculadora.Multiply;

import static org.junit.jupiter.api.Assertions.*;

class MultiplyTest {
    Multiply multiply = new Multiply();

    //Multiplicación de dos números REALES.
    @org.junit.jupiter.api.Test
    void doubleTwoParamsProduct() {
        double resultado = multiply.doubleTwoParamsProduct(10,0.5);
            assertEquals(5,resultado,"El resultado debe ser 5");
    }

    //Multiplicación de dos números ENTEROS.
    @org.junit.jupiter.api.Test
    void intTwoParamsProduct() {
        int resultado = multiply.intTwoParamsProduct(3,3);
            assertEquals(9,resultado,"El resultado debe ser 9");
    }

    //Multiplicación de tres números REALES.
    @org.junit.jupiter.api.Test
    void doubleThreeParamsProduct() {
        double resultado = multiply.doubleThreeParamsProduct(10,0.5, 2);
            assertEquals(10,resultado,"El resultado debe ser 10");
    }

    //Potencia de un número.
    @org.junit.jupiter.api.Test
    void doubleExponent() {
        double resultado = multiply.doubleExponent(3,3);
            assertEquals(27,resultado,"El resultado debe ser 27");
    }
}
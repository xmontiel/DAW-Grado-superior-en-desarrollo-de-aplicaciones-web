package test;

import calculadora.Resta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RestaTest {
    private Resta resta;
    @BeforeEach
    void setUp() {
        resta = new Resta();
    }

    @Test
    void testResta2Reales() {
        //Dado (GIVEN)
        double num1 = 5.0;
        double num2 = 6.0;
        double resultadoEsperado = -1.0;

        //Cuando (WHEN)
        double resultadoActual = resta.resta2Reales(num1, num2);

        // Entonces (THEN)
        assertEquals(resultadoEsperado, resultadoActual, "El resultado de la resta es de " + resultadoEsperado);
    }
    @Test
    void testResta2Enteros() {

        // Dado (GIVEN)
        int num1 = 6;
        int num2 = 5;
        int resultadoEsperado = 1;

        //Cuando (WHEN)
        int resultadoActual = resta.resta2Enteros(num1, num2);

        //Entonces (THEN)
        assertEquals(resultadoEsperado, resultadoActual, "El resultado de la resta es " + resultadoEsperado);
    }

    @Test
    void testResta3Reales() {

        // Dado (GIVEN)
        double num1 = 8.5;
        double num2 = 2.0;
        double num3 = 3.0;
        double resultadoEsperado = 3.5;

        // Cuando (WHEN)
        double resultadoActual = resta.resta3Reales(num1, num2, num3);

        // Entonces (THEN)
        assertEquals(resultadoEsperado, resultadoActual, "El resultado de la resta es " + resultadoEsperado);
    }

    @Test
    void testRestaAcumulando() {


        // Dado (GIVEN)
        resta.restaAcumulando(-6.0);
        resta.restaAcumulando(1.0);

        // Cuando (WHEN)
        double resultado = resta.getNumeroAcumulado();

        // Entonces (THEN)
        assertEquals(5.0, resultado, "El resultado de la resta es " + resultado);

    }
}


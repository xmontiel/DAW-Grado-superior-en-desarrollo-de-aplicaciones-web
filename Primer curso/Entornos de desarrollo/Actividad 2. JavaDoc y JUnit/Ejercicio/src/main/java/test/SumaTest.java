package test;

import calculadora.Suma;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SumaTest {
    Suma suma = new Suma();

    @Test
    void sumaDosNumReals() {
        double resultado = suma.sumaDosNumReals(10,5);
                assertEquals(15, resultado, "El resultado debe ser 15");
    }

    @Test
    void sumaDosEnteros() {
        int resultado = suma.sumaDosEnteros(17,7);
        assertEquals(24, resultado, "El resultado debe ser 24");
    }

    @Test
    void sumaTresNumReals() {
        double resultado = suma.sumaTresNumReals(1,2,3);
        assertEquals(6,resultado, "El resutlado debe ser 6");
    }

    @Test
    void sumaAcumulado() {
        suma.sumaAcumulado(50);
        suma.sumaAcumulado(25);
        assertEquals(75, Suma.getNumAcumulado(),"El resultado debe ser 75");
    }
}
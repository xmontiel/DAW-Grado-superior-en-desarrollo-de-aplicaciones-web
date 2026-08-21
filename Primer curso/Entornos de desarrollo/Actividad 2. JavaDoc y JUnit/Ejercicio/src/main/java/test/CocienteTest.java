package test;

import calculadora.Cociente;
import org.junit.jupiter.api.*;

class CocienteTest {

    @DisplayName("División de 2 números Reales")
    @Test
    void dividirNumReal() throws Cociente.ZeroMathException {
        Assertions.assertEquals(1, Cociente.dividir(3.3, 3.3));
    }

    @DisplayName("División de 2 números Enteros")
    @Test
    void dividirNumEntero() {
        try {
            Assertions.assertEquals(1, Cociente.dividir(3, 3));
        } catch (Cociente.ZeroMathException e) {
            throw new RuntimeException(e);
        }
    }

    @DisplayName("Generear el inverso de un número Real 1/n")
    @Test
    void inverso() {
        try {
            Assertions.assertEquals(1, Cociente.inverso(3.3));
        } catch (Cociente.ZeroMathException e) {
            throw new RuntimeException(e);
        }
    }

    @DisplayName("Raíz de un número Real")
    @Test
    void raiz() {
        try {
            Assertions.assertEquals(2, Cociente.raiz(4.0));
        } catch (Cociente.NegativeSquareException e) {
            throw new RuntimeException(e);
        }
    }

    @AfterEach
    void afterEach() {
        System.out.println("Prueba finalizada");
    }

    @AfterAll
    static void teardown() {
        System.out.println("Finalizando pruebas...");
    }
}
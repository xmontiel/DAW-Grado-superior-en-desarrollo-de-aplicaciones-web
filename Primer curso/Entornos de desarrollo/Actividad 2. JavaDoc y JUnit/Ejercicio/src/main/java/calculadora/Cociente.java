package calculadora;

/**
 * Clase qye permite realizar operacine de division, raices cuadradas y numeros inversos
 * @author Victor Suero
 * @version 1.0
 */
public class Cociente {

    public static class ZeroMathException extends Exception {
        public ZeroMathException(String message) {
            super(message);
        }
    }

    public static class NegativeSquareException extends Exception {
        public NegativeSquareException(String message) {
            super(message);
        }
    }


    /**
     * @param dividendo
     * @param divisor
     * @return El resultado de dvidir ambos operandos
     * @throws ZeroMathException si se intenta dividir entre cero
     */
    public static double dividir(double dividendo, double divisor) throws ZeroMathException {
        if (divisor == 0) throw new ZeroMathException("No se puede dividir entre Zero por que da infinito");
        return dividendo / divisor;
    }

    /**
     * @param dividendo
     * @param divisor
     * @return El resultado de dvidir ambos operandos
     * @throws ZeroMathException si se intenta dividir entre cero
     */
    public static double dividir(int dividendo, int divisor) throws ZeroMathException {
        if (divisor == 0) throw new ZeroMathException("No se puede dividir entre Zero por que da infinito");
        return (double) dividendo / divisor;
    }

    /**
     * @param n
     * @return El inverso del numero dado cmo n
     * @throws ZeroMathException si se intenta generar el inverso de cero
     */
    public static double inverso(double n) throws ZeroMathException {
        if (n == 0) throw new ZeroMathException("Zero no tiene inverso");
        return 1 / n;
    }


    /**
     *
     * @param n
     * @return La raiz cuadrada de un numero dado como n
     * @throws NegativeSquareException si se intenta generar la raiz de un numero negativo puesto que no tienen
     */
    public static double raiz(double n) throws NegativeSquareException {
        if (n < 0) throw new NegativeSquareException("No existen las raices cuadradas de numeros negativos");
        return Math.sqrt(n);
    }
}


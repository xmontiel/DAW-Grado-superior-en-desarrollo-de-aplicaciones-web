/**
 * Representa una resta con las siguientes operaciones:
 * Resta de dos números reales, tendrá 2 parámetros de entrada y uno de salida que será la solución.
 * Resta de dos números enteros, tendrá 2 parámetros de entrada y uno de salida que será la solución
 * Resta de tres números reales, tendrá 3 parámetros de entrada y uno de salida que será la solución.
 * Resta con valor acumulado, tendrá un parámetro de entrada y la clase deberá de guardar el valor acumulado.
 *
 * @author Juan Montiel (xmontiel@github.com)
 * @version 1.0
 */

package calculadora;

public class Resta {

    private double numeroReal1;
    private double numeroReal2;
    private double numeroReal3;
    private int numeroEntero1;
    private int numeroEntero2;
    private double numeroAcumulado;

    public Resta() {
    }

    public Resta(double numeroReal1, double numeroReal2, double numeroReal3, int numeroEntero1, int numeroEntero2, double numeroAcumulado) {
        this.numeroReal1 = numeroReal1;
        this.numeroReal2 = numeroReal2;
        this.numeroReal3 = numeroReal3;
        this.numeroEntero1 = numeroEntero1;
        this.numeroEntero2 = numeroEntero2;
        this.numeroAcumulado = numeroAcumulado;
    }

    public double getNumeroReal1() {
        return numeroReal1;
    }

    public void setNumeroReal1(double numeroReal1) {
        this.numeroReal1 = numeroReal1;
    }

    public double getNumeroReal2() {
        return numeroReal2;
    }

    public void setNumeroReal2(double numeroReal2) {
        this.numeroReal2 = numeroReal2;
    }

    public double getNumeroReal3() {
        return numeroReal3;
    }

    public void setNumeroReal3(double numeroReal3) {
        this.numeroReal3 = numeroReal3;
    }

    public int getNumeroEntero1() {
        return numeroEntero1;
    }

    public void setNumeroEntero1(int numeroEntero1) {
        this.numeroEntero1 = numeroEntero1;
    }

    public int getNumeroEntero2() {
        return numeroEntero2;
    }

    public void setNumeroEntero2(int numeroEntero2) {
        this.numeroEntero2 = numeroEntero2;
    }

    public double getNumeroAcumulado() {
        return numeroAcumulado;
    }

    public void setNumeroAcumulado(double numeroAcumulado) {
        this.numeroAcumulado = numeroAcumulado;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Resta{" +
                "numeroReal1=" + numeroReal1 +
                ", numeroReal2=" + numeroReal2 +
                ", numeroReal3=" + numeroReal3 +
                ", numeroEntero1=" + numeroEntero1 +
                ", numeroEntero2=" + numeroEntero2 +
                ", numeroAcumulado=" + numeroAcumulado +
                '}';
    }

    /**
     * Resta de dos números reales.
     * @author Juan Montiel (xmontiel@github.com)
     * @version 1.0
     */
    
    public double resta2Reales(){
        return numeroReal1 - numeroReal2;
    }

    public double resta2Reales(double numeroReal1, double numeroReal2){
        this.numeroReal1 = numeroReal1;
        this.numeroReal2 = numeroReal2;
        return numeroReal1 - numeroReal2;
    }

    /**
     * Resta de dos números enteros.
     * @author Juan Montiel (xmontiel@github.com)
     * @version 1.0
     */

    public int resta2Enteros(){
        return numeroEntero1 - numeroEntero2;
    }

    public int resta2Enteros(int numeroEntero1, int numeroEntero2){
        this.numeroEntero1 = numeroEntero1;
        this.numeroEntero2 = numeroEntero2;
        return numeroEntero1 - numeroEntero2;
    }

    /**
     * Resta de tres números reales.
     * @author Juan Montiel (xmontiel@github.com)
     * @version 1.0
     */

    public double resta3Reales(){
        return numeroReal1 - numeroReal2 - numeroReal3;
    }

    public double resta3Reales(double numeroReal1, double numeroReal2, double numeroReal3){
        this.numeroReal1 = numeroReal1;
        this.numeroReal2 = numeroReal2;
        this.numeroReal3 = numeroReal3;
        return numeroReal1 - numeroReal2 - numeroReal3;
    }

    /**
     * Resta acumulando el resultado de la anterior resta como factor a restar en la siguiente.
     * @author Juan Montiel (xmontiel@github.com)
     * @version 1.0
     */

    public void restaAcumulando(double numeroARestar){
        numeroAcumulado -= numeroARestar;
    }

}
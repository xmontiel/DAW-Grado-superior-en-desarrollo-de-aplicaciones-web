/**
 * @author Juan Montiel (xmontiel@github.com)
 * @version 1.0
 */
package calculadora;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Cociente.ZeroMathException {

        Scanner scanner = new Scanner(System.in);
        int opcion = 0;
        System.out.println("Elija la operación matemática que desee");
        System.out.println("1 Suma");
        System.out.println("2 Resta");
        System.out.println("3 Multiplicación");
        System.out.println("4 División");
        opcion = scanner.nextInt();

        switch (opcion) {
            case 1:
                System.out.println("Elija la operación matemática que desee");
                System.out.println("1 Suma de dos numeros reales");
                System.out.println("2 Suma de dos numeros enteros");
                System.out.println("3 Suma de tres numeros reales");
                System.out.println("4 Suma de numero acumulado");
                opcion = scanner.nextInt();
                switch (opcion) {
                    case 1:
                        System.out.println("Introduzca primer numero");
                        Suma suma1 = new Suma();
                        double numReal1 = 0;
                        double numReal2 = 0;
                        numReal1 = scanner.nextDouble();
                        System.out.println("Introduzca segundo numero");
                        numReal2 = scanner.nextDouble();
                        System.out.println("El resultado es " + suma1.sumaDosNumReals(numReal1, numReal2));
                        break;
                    case 2:
                        System.out.println("Introduzca primer numero");
                        Suma suma2 = new Suma();
                        int numEntero1 = 0;
                        int numEntero2 = 0;
                        numEntero1 = scanner.nextInt();
                        System.out.println("Introduzca segundo numero");
                        numEntero2 = scanner.nextInt();
                        System.out.println("El resultado es " + suma2.sumaDosEnteros(numEntero1, numEntero2));
                        break;
                    case 3:
                        System.out.println("Introduzca primer numero");
                        Suma suma3 = new Suma();
                        double numReal3 = 0;
                        double numReal4 = 0;
                        double numReal5 = 0;
                        numReal3 = scanner.nextDouble();
                        System.out.println("Introduzca segundo numero");
                        numReal4 = scanner.nextDouble();
                        System.out.println("Introduzca tercer numero");
                        numReal5 = scanner.nextDouble();
                        System.out.println("El resultado es " + suma3.sumaTresNumReals(numReal3, numReal4, numReal5));
                        break;
                    case 4:
                        System.out.println("Introduzca numeros para sumarlos. Introduzca 999 para salir");
                        Suma suma4 = new Suma();
                        double numAcumulado = 0;
                        double numeroASumar = 0;

                        System.out.println(numAcumulado);
                        while (numeroASumar != 999) {
                            numeroASumar = scanner.nextDouble();
                            suma4.sumaAcumulado(numAcumulado);
                            System.out.println(suma4.getNumAcumulado());
                        }
                        break;
                    default:
                        System.out.println("Opción erronea");
                }
                break;
            case 2:
                System.out.println("Elija la operación matemática que desee");
                System.out.println("1 Resta de dos numeros reales");
                System.out.println("2 Resta de dos numeros enteros");
                System.out.println("3 Resta de tres numeros reales");
                System.out.println("4 Resta de numero acumulado");
                opcion = scanner.nextInt();
                switch (opcion) {
                    case 1:
                        System.out.println("Introduzca primer numero");
                        Resta resta1 = new Resta();
                        double numeroReal1 = 0;
                        double numeroReal2 = 0;
                        numeroReal1 = scanner.nextDouble();
                        resta1.setNumeroReal1(numeroReal1);
                        System.out.println("Introduzca segundo numero");
                        numeroReal2 = scanner.nextDouble();
                        resta1.setNumeroReal2(numeroReal2);
                        System.out.println("El resultado es " + resta1.resta2Reales());
                        break;
                    case 2:
                        System.out.println("Introduzca primer numero");
                        Resta resta2 = new Resta();
                        int numeroEntero1 = 0;
                        int numeroEntero2 = 0;
                        numeroEntero1 = scanner.nextInt();
                        resta2.setNumeroEntero1(numeroEntero1);
                        System.out.println("Introduzca segundo numero");
                        numeroEntero2 = scanner.nextInt();
                        resta2.setNumeroEntero2(numeroEntero2);
                        System.out.println("El resultado es " + resta2.resta2Enteros());
                        break;
                    case 3:
                        System.out.println("Introduzca primer numero");
                        Resta resta3 = new Resta();
                        double numeroReal3 = 0;
                        double numeroReal4 = 0;
                        double numeroReal5 = 0;
                        numeroReal3 = scanner.nextDouble();
                        resta3.setNumeroReal1(numeroReal3);
                        System.out.println("Introduzca segundo numero");
                        numeroReal4 = scanner.nextDouble();
                        resta3.setNumeroReal2(numeroReal4);
                        System.out.println("Introduzca tercer numero");
                        numeroReal5 = scanner.nextDouble();
                        resta3.setNumeroReal3(numeroReal5);
                        System.out.println("El resultado es " + resta3.resta3Reales());
                        break;
                    case 4:
                        System.out.println("Introduzca numeros para restarlos. Introduzca 999 para salir");
                        Resta resta4 = new Resta();
                        double numeroAcumulado = 0;
                        double numeroARestar = 0;

                        System.out.println(numeroAcumulado);
                        while (numeroARestar != 999) {
                            numeroARestar = scanner.nextDouble();
                            resta4.restaAcumulando(numeroARestar);
                            System.out.println(resta4.getNumeroAcumulado());
                        }
                        break;
                    default:
                        System.out.println("Opción erronea");
                }
                break;
            case 3:
                System.out.println("Multiplicación");
                break;
            case 4:
                System.out.println("División");
                System.out.println("Elija la operación matemática que desee");
                System.out.println("1 Division de dos numeros reales");
                System.out.println("2 Divison de dos numeros enteros");
                System.out.println("3 Calculo del numero inverso un numero real");
                System.out.println("4 Raiz cuadrada de un numeor real");
                opcion = scanner.nextInt();
                switch (opcion){
                    case 1:
                        try{
                        System.out.println("Introduzca el dividendo");
                        double dividendo = scanner.nextDouble();
                        System.out.println("Introduzca el divisor");
                        double divisor = scanner.nextDouble();
                        System.out.println("Resultado: " + Cociente.dividir(dividendo,divisor));
                        } catch (Cociente.ZeroMathException e) {
                            System.err.println(e + " on line " + e.getStackTrace()[0].getLineNumber());
                        }
                        break;
                    case 2:
                        try{
                            System.out.println("Introduzca el dividendo");
                            int dividendo = scanner.nextInt();
                            System.out.println("Introduzca el divisor");
                            int divisor = scanner.nextInt();
                            System.out.println("Resultado: " + Cociente.dividir(dividendo,divisor));
                        } catch (Cociente.ZeroMathException e) {
                            System.err.println(e + " on line " + e.getStackTrace()[0].getLineNumber());
                        }
                        break;
                    case 3:
                        try{
                            System.out.println("Introduzca un numero para calcular su inverso");
                            double n = scanner.nextDouble();
                            System.out.println("Resultado: " + Cociente.inverso(n));
                        } catch (Cociente.ZeroMathException e) {
                            System.err.println(e + " on line " + e.getStackTrace()[0].getLineNumber());
                        }
                        break;
                    case 4:
                        try{
                            System.out.println("Introduzca un numero para calcular su Raiz cuadrad");
                            double n = scanner.nextDouble();
                            System.out.println("Resultado: " + Cociente.raiz(n));
                        } catch (Cociente.NegativeSquareException e) {
                            System.err.println(e + " on line " + e.getStackTrace()[0].getLineNumber());
                        }
                        break;
                    default:
                        System.out.println("Opcion erronea");
                        break;
                }
                break;
            default:
                System.out.println("Opción erronea");
        }
        scanner.close();
    }

}

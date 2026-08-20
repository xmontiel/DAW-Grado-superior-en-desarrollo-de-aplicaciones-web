package ejercicios;

import java.util.Scanner;

public class Ejercicio_4 {
	public static void main(String[] args) {
		
		/*
		 * Leer números hasta que se introduzca un cero. Para cada uno indicar si es par o impar.
		 * Al final mostrar las siguientes Estadísticas:
		 * cuantos son pares e impares
		 * cuanto suman los pares y 
		 * cuanto los impares.
		 */
		
		Scanner leer = new Scanner(System.in);
		int i=0, par=0, impar=0, sump=0, sumi=0;
		
		System.out.println("Escribe aquí tus números. Escribe 0 para finalizar:");
		i=leer.nextInt();
		
		while(i!=0) {
			if(i%2==0) {
				par++;
				sump+=i;
		    } else {
				impar++;
				sumi+=i;
		      } 
			i=leer.nextInt();
		}
		
		System.out.println("Estadísticas:");
		System.out.println("Pares: " + par);
		System.out.println("Impares: " + impar);
		System.out.println("Suma de pares: " + sump);
		System.out.println("Suma de impares: " + sumi);	

		leer.close();
	}

}

package ejercicios;

import java.util.Scanner;

public class Ejercicio_1{
	public static void main(String[] args) {
		
		/*
		 * Pedir una nota de 0 a 10 y mostrarla de la forma: Insuficiente, Suficiente, Bien, Notable y sobresaliente.
		 * Si la nota introducida no está en el rango mostrar el mensaje “Nota errónea”.
		 */
		
		Scanner leer = new Scanner(System.in);
		double nota=0;
		
		System.out.println("Escribe tu nota aquí:");
		nota=leer.nextDouble();
		
		if(nota>=0 && nota<5) {
			System.out.println("Has sacado un insuficiente");
		} else
		if(nota>=5 && nota<6) {
			System.out.println("Has sacado un suficiente");
		} else
		if(nota>=6 && nota<7) {
			System.out.println("Has sacado un bien");
		} else
		if(nota>=7 && nota<9) {
			System.out.println("Has sacado un notable");
		} else
		if(nota>=9 && nota<=10) {
			System.out.println("Has sacado un sobresaliente");
		} else {
			System.out.println("Nota errónea");
		  }
		
		leer.close();
	}

}

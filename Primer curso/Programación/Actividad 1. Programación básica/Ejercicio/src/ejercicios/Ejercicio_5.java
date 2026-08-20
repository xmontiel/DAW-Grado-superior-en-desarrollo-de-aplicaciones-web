package ejercicios;

import java.util.Scanner;

public class Ejercicio_5 {
	public static void main(String[] args) {
		/*
		 * Pedimos por pantalla un nombre y una contraseña:
		 * si el nombre coincide con “sara”, preguntamos por la contraseña y si coincide con “sarita”, 
		 * escribimos el mensaje “usuario y contraseña correctas, bienvenido a la aplicación”
		 * Si el nombre NO es “sara” Escribimos usuario incorrecto”
		 * Si el nombre es correcto y la contraseña NO, Escribimos “contraseña incorrecta”
		 */
		
		Scanner leer = new Scanner(System.in);
		String nombre="", contraseña="";
		
		System.out.println("Introduzca nombre y contraseña:");
		nombre=leer.next();
		contraseña=leer.next();
		
		if(!nombre.equals("sara")) {
			System.out.println("Usuario incorrecto");
		} else
		if(!contraseña.equals("sarita")) {
			System.out.println("Contraseña incorrecta");
		} else {
			System.out.println("Usuario y contraseña correctas, bienvenido a la aplicación");
		  }
		
		leer.close();
	}

}

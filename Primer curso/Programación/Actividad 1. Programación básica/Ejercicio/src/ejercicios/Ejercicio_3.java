package ejercicios;

public class Ejercicio_3 {
	public static void main(String[] args) {
		
		/*
		 * Escribir todos los números del 100 al 0 de 7 en 7. Al final mostrar las siguientes Estadísticas.
		 * Cuantos números has escrito
		 * Cuanto suman los números escritos
		 * Cuantos de estos números son pares.
		 */
		
		int contador=0, suma=0, pares=0;
		for(int i=100; i>=0; i-=7) {
			System.out.println(i);
			suma+=i;
			contador++;
			if(i%2==0) {
				pares++;
			}
		}
		
		System.out.println("Números escritos: " + contador);
		System.out.println("Suma números escritos: " + suma);
		System.out.println("Total pares: " + pares);
		
	}

}

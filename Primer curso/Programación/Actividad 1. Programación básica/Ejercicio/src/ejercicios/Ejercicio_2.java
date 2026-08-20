package ejercicios;

public class Ejercicio_2 {
	public static void main(String[] args) {
		
		//Diseñar un programa que muestre el producto y la suma de los 10 primeros números impares.

		int producto=1, suma=0, contador=0;
		
		for(int i=1; contador<10; i+=2) {
			producto*=i;
			suma+=i;
			contador++;			
		}
		
	System.out.println("Producto de los 10 primeros números impares: " + producto);
	System.out.println("Suma de los 10 primeros números impares: " + suma);
	
	}

}

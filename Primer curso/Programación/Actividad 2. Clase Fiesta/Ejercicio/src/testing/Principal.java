package testing;

import java.time.LocalDate;
import java.time.LocalTime;

import javabean.Fiesta;

public class Principal {

	public static void main(String[] args) {
		
		Fiesta fiesta1, fiesta2, fiesta3, fiesta4;
		
		//Fiesta 1 y 2 con constructor con todos los atributos:
		fiesta1 = new Fiesta("disfraces", "Calle Oca, N1, 7C", 34, 28, 25, LocalDate.of(2024, 1, 8), LocalTime.of(18, 15));
		
		fiesta2 = new Fiesta("navidad", "Carrer de la Barca, N13, 4A", 40, 40, 40, LocalDate.of(2024, 12, 31), LocalTime.of(22, 00));
		
		//Fiesta 3 y 4 con constructor vacío:
		fiesta3 = new Fiesta();
		fiesta3.setTipoFiesta("infantil");
		fiesta3.setDireccion("Calle Falsa, N123, 3ro Izda.");
		fiesta3.setBocadillos(10);
		fiesta3.setBebidas(10);
		fiesta3.setInvitados(5);
		fiesta3.setFecha(LocalDate.of(2024, 4, 20));
		fiesta3.setHora(LocalTime.of(14, 30));
				
		fiesta4 = new Fiesta();
		fiesta4.setTipoFiesta("cumpleanos");
		fiesta4.setDireccion("Avenida de la Constitución, N66, 2B");
		fiesta4.setBocadillos(18);
		fiesta4.setBebidas(24);
		fiesta4.setInvitados(12);
		fiesta4.setFecha(LocalDate.of(2024, 2, 28));
		fiesta4.setHora(LocalTime.of(20, 00));
		
		//Pruebas de la clase "Fiesta":
		System.out.println("Pruebas de la clase Fiesta:");
		System.out.println();
		
		//Prueba Getters and Setters:
		System.out.println("Prueba Getters and Setters:");
		
		System.out.println("Fiesta 1: " + fiesta1.getTipoFiesta()
								  + " " + fiesta1.getDireccion() 
								  + " " + fiesta1.getBocadillos()
								  + " " + fiesta1.getBebidas() 
								  + " " + fiesta1.getInvitados()
								  + " " + fiesta1.getFecha()
								  + " " + fiesta1.getHora());
		System.out.println("Fiesta 2: " + fiesta2.getTipoFiesta()
								  + " " + fiesta2.getDireccion()
								  + " " + fiesta2.getBocadillos()
								  + " " + fiesta2.getBebidas()
								  + " " + fiesta2.getInvitados()
								  + " " + fiesta2.getFecha()
								  + " " + fiesta2.getHora());
		System.out.println("Fiesta 3: " + fiesta3.getTipoFiesta()
								  + " " + fiesta3.getDireccion() 
								  + " " + fiesta3.getBocadillos()
								  + " " + fiesta3.getBebidas()
								  + " " + fiesta3.getInvitados()
								  + " " + fiesta3.getFecha()
								  + " " + fiesta3.getHora());
		System.out.println("Fiesta 4: " + fiesta4.getTipoFiesta()
								  + " " + fiesta4.getDireccion()
								  + " " + fiesta4.getBocadillos()
								  + " " + fiesta4.getBebidas()
								  + " " + fiesta4.getInvitados()
								  + " " + fiesta4.getFecha()
								  + " " + fiesta4.getHora());
		System.out.println();

		//Prueba toString():
		System.out.println("Prueba toString():");
		
		System.out.println("Datos de la fiesta 1: " + fiesta1);
		System.out.println("Datos de la fiesta 2: " + fiesta2);
		System.out.println("Datos de la fiesta 3: " + fiesta3);
		System.out.println("Datos de la fiesta 4: " + fiesta4);
		
		System.out.println();
		
		//Prueba invitar() para añadir a un invitado:
		System.out.println("Prueba invitar() para añadir a un invitado:");
		
		System.out.print(fiesta1.getInvitados() + " ");
		System.out.print(fiesta2.getInvitados() + " ");
		System.out.print(fiesta3.getInvitados() + " ");
		System.out.println(fiesta4.getInvitados() + " ");
		
		fiesta1.invitar();
		fiesta2.invitar();
		fiesta3.invitar();
		fiesta4.invitar();
		
		System.out.print(fiesta1.getInvitados() + " ");
		System.out.print(fiesta2.getInvitados() + " ");
		System.out.print(fiesta3.getInvitados() + " ");
		System.out.println(fiesta4.getInvitados() + " ");
		
		System.out.println();
		
		//Prueba invitar(int cantidad) para añadir a varios invitados:
		System.out.println("Prueba invitar(int cantidad) para añadir a varios invitados:");
		
		System.out.print(fiesta1.getInvitados() + " ");
		System.out.print(fiesta2.getInvitados() + " ");
		System.out.print(fiesta3.getInvitados() + " ");
		System.out.println(fiesta4.getInvitados() + " ");
		
		fiesta1.invitar(4);
		fiesta2.invitar(9);
		fiesta3.invitar(4);
		fiesta4.invitar(7);
		
		System.out.print(fiesta1.getInvitados() + " ");
		System.out.print(fiesta2.getInvitados() + " ");
		System.out.print(fiesta3.getInvitados() + " ");
		System.out.println(fiesta4.getInvitados() + " ");
		
		System.out.println();
		
		//Prueba cancelarInvitacion() para restar un invitado:
		System.out.println("Prueba cancelarInvitacion() para restar un invitado:");
		
		System.out.print(fiesta1.getInvitados() + " ");
		System.out.print(fiesta2.getInvitados() + " ");
		System.out.print(fiesta3.getInvitados() + " ");
		System.out.println(fiesta4.getInvitados() + " ");
		
		fiesta1.cancelarInvitacion();
		fiesta2.cancelarInvitacion();
		fiesta3.cancelarInvitacion();
		fiesta4.cancelarInvitacion();
		
		System.out.print(fiesta1.getInvitados() + " ");
		System.out.print(fiesta2.getInvitados() + " ");
		System.out.print(fiesta3.getInvitados() + " ");
		System.out.println(fiesta4.getInvitados() + " ");
		
		//Vamos a usar la fiesta 3 para probar que no nos deje entrar en negativo en el numero de invitados:
		System.out.println("- Vamos a usar la fiesta 3 para probar que no nos deje entrar en negativo en el numero de invitados:");
		
		for(int i=15; i>0; i--) {
			System.out.print(fiesta3.getInvitados() + " ");
			fiesta3.cancelarInvitacion();
		}
		
		System.out.println();
		System.out.println();

		//Prueba cancelarInvitacion(int cantidad) para restar a varios invitados:
		System.out.println("Prueba cancelarInvitacion(int cantidad) para restar a varios invitados:");
		
		System.out.print(fiesta1.getInvitados() + " ");
		System.out.print(fiesta2.getInvitados() + " ");
		System.out.print(fiesta3.getInvitados() + " ");
		System.out.println(fiesta4.getInvitados() + " ");
		
		//Intentamos restar más invitados de los que hay en fiesta3 y fiesta4, nos devolverá 0.
		fiesta1.cancelarInvitacion(9);
		fiesta2.cancelarInvitacion(40);
		fiesta3.cancelarInvitacion(1);
		fiesta4.cancelarInvitacion(30);
		
		System.out.print(fiesta1.getInvitados() + " ");
		System.out.print(fiesta2.getInvitados() + " ");
		System.out.print(fiesta3.getInvitados() + " ");
		System.out.println(fiesta4.getInvitados() + " ");
		
		System.out.println();		
		
		//Prueba precioFiesta():
		System.out.println("Prueba precioFiesta():");
		
		System.out.println("El cálculo de la fiesta 1 es: " +
							fiesta1.getInvitados() + " invitados * " + Fiesta.COSTE_INVITADO + "€ + " +
							fiesta1.getBebidas() + " bebidas * " + Fiesta.COSTE_BEBIDA + "€ + " + 
							fiesta1.getBocadillos() + " bocadillos * " + Fiesta.COSTE_BOCADILLO + "€.");
		System.out.println("El cálculo de la fiesta 2 es: " +
							fiesta2.getInvitados() + " invitados * " + Fiesta.COSTE_INVITADO + "€ + " +
							fiesta2.getBebidas() + " bebidas * " + Fiesta.COSTE_BEBIDA + "€ + " +
							fiesta2.getBocadillos() + " bocadillos * " + Fiesta.COSTE_BOCADILLO + "€.");
		System.out.println("El cálculo de la fiesta 3 es: " + 
							fiesta3.getInvitados() + " invitados * " + Fiesta.COSTE_INVITADO + "€ + " + 
							fiesta3.getBebidas() + " bebidas * " + Fiesta.COSTE_BEBIDA + "€ + " + 
							fiesta3.getBocadillos() + " bocadillos * " + Fiesta.COSTE_BOCADILLO + "€.");
		System.out.println("El cálculo de la fiesta 4 es: " +
							fiesta4.getInvitados() + " invitados * " + Fiesta.COSTE_INVITADO + "€ + " +
							fiesta4.getBebidas() + " bebidas * " + Fiesta.COSTE_BEBIDA + "€ + " +
							fiesta4.getBocadillos() + " bocadillos * " + Fiesta.COSTE_BOCADILLO + "€.");
		
		System.out.println("La fiesta 1 cuesta " + fiesta1.precioFiesta() + " euros.");
		System.out.println("La fiesta 2 cuesta " + fiesta2.precioFiesta() + " euros.");
		System.out.println("La fiesta 3 cuesta " + fiesta3.precioFiesta() + " euros.");
		System.out.println("La fiesta 4 cuesta " + fiesta4.precioFiesta() + " euros.");

	}

}

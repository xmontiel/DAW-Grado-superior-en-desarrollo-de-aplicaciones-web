package javabean;

import java.time.LocalDate;
import java.time.LocalTime;

public class Fiesta {
	
	//Atributos de clase:
	public static final int COSTE_INVITADO;
	public static final int COSTE_BEBIDA;
	public static final int COSTE_BOCADILLO;
	
	static {
		COSTE_INVITADO = 5;
		COSTE_BEBIDA = 2;
		COSTE_BOCADILLO = 3;
	}
	
	/*Atributos de instancia:

	  Se podría almacenar la fecha y la hora como una sola variable LocalDateTime.
	  Para mantener la similitud al enunciado lo dejaremos de esta manera.
	*/
	private String tipoFiesta;
	private String direccion;
	private int bocadillos;
	private int bebidas;
	private int invitados;
	private LocalDate fecha;
	private LocalTime hora;
	
	//Constructor con todos los atributos:
	public Fiesta(String tipoFiesta, String direccion, int bocadillos, int bebidas, int invitados, LocalDate fecha,
			LocalTime hora) {
		super();
		this.tipoFiesta = tipoFiesta;
		this.direccion = direccion;
		this.bocadillos = bocadillos;
		this.bebidas = bebidas;
		this.invitados = invitados;
		this.fecha = fecha;
		this.hora = hora;
	}

	//Constructor sin atributos:
	public Fiesta() {
		super();
	}

	//Getters and Setters:
	public String getTipoFiesta() {
		return tipoFiesta;
	}

	public void setTipoFiesta(String tipoFiesta) {
		this.tipoFiesta = tipoFiesta;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getBocadillos() {
		return bocadillos;
	}

	public void setBocadillos(int bocadillos) {
		this.bocadillos = bocadillos;
	}

	public int getBebidas() {
		return bebidas;
	}

	public void setBebidas(int bebidas) {
		this.bebidas = bebidas;
	}

	public int getInvitados() {
		return invitados;
	}

	public void setInvitados(int invitados) {
		this.invitados = invitados;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public LocalTime getHora() {
		return hora;
	}

	public void setHora(LocalTime hora) {
		this.hora = hora;
	}

	//ToString:
	@Override
	public String toString() {
		return "Fiesta [tipoFiesta=" + tipoFiesta + ", direccion=" + direccion + ", bocadillos=" + bocadillos
				+ ", bebidas=" + bebidas + ", invitados=" + invitados + ", fecha=" + fecha + ", hora=" + hora + "]";
	}
	
	//Métodos propios:
	
	//Método invitar() para sumar un invitado:
	public void invitar() {
		invitados++;
	}
	
	//Método invitar(int cantidad) para escoger número de invitados a sumar:
	public void invitar(int cantidad) {
		invitados+=cantidad;
	}
	
	//Método cancelarInvitacion() para restar un invitado:
	public int cancelarInvitacion() {
		if(invitados>0) {
			invitados--;
			return invitados;
		}
		else
			return invitados;
	}
	
	//Método cancelarInvitacion(int cantidad) para escoger número de invitados a restar:
	public int cancelarInvitacion(int cantidad) {
		if(cantidad<=invitados) {
			invitados-=cantidad;
			return invitados;
		}
		else
			invitados-=invitados; //Se podría poner invitados=0 pero así se ve más claro lo que pretendemos
			return invitados;
	}
	
	//Método precioFiesta() para saber el precio total de la fiesta:
	//Se podría añadir un if para indicar que si no hay invitados no hay fiesta y nos devuelva un 0 al precio de la fiesta.
	public int precioFiesta() {
		int precioInvitados, precioBebidas, precioBocadillos;
		precioInvitados = invitados*COSTE_INVITADO;
		precioBebidas = bebidas*COSTE_BEBIDA;
		precioBocadillos = bocadillos*COSTE_BOCADILLO;
		return precioInvitados + precioBebidas + precioBocadillos;
	}

}

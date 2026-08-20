package javabean;

import java.time.LocalDate;
import java.util.Objects;

public class Cliente {
	
	private String idCliente;
	private String nombre;
	private String email;
	private LocalDate createdAt;
	private DireccionCliente direccion;
	private TarjetaBancaria tarjeta;
	
	public Cliente() {
		super();
	}

	public Cliente(String idCliente, String nombre, String email, LocalDate createdAt, DireccionCliente direccion,
			TarjetaBancaria tarjeta) {
		super();
		this.idCliente = idCliente;
		this.nombre = nombre;
		this.email = email;
		this.createdAt = createdAt;
		this.direccion = direccion;
		this.tarjeta = tarjeta;
	}

	public String getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDate createdAt) {
		this.createdAt = createdAt;
	}

	public DireccionCliente getDireccion() {
		return direccion;
	}

	public void setDireccion(DireccionCliente direccion) {
		this.direccion = direccion;
	}

	public TarjetaBancaria getTarjeta() {
		return tarjeta;
	}

	public void setTarjeta(TarjetaBancaria tarjeta) {
		this.tarjeta = tarjeta;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idCliente);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Cliente))
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(idCliente, other.idCliente);
	}

	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", nombre=" + nombre + ", email=" + email + ", createdAt="
				+ createdAt + ", direccion=" + direccion + ", tarjeta=" + tarjeta + "]";
	}
	
	

}

package javabean;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public class Cliente2 {
	
	private String idCliente;
	private String nombre;
	private String email;
	private LocalDate createdAt;
	private DireccionCliente direccion;
	private ArrayList<TarjetaBancaria> tarjetas;
	
	public Cliente2() {
		super();
	}

	public Cliente2(String idCliente, String nombre, String email, LocalDate createdAt, DireccionCliente direccion,
			ArrayList<TarjetaBancaria> tarjetas) {
		super();
		this.idCliente = idCliente;
		this.nombre = nombre;
		this.email = email;
		this.createdAt = createdAt;
		this.direccion = direccion;
		this.tarjetas = tarjetas;
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

	public ArrayList<TarjetaBancaria> getTarjetas() {
		return tarjetas;
	}

	public void setTarjetas(ArrayList<TarjetaBancaria> tarjetas) {
		this.tarjetas = tarjetas;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idCliente);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Cliente2))
			return false;
		Cliente2 other = (Cliente2) obj;
		return Objects.equals(idCliente, other.idCliente);
	}

	@Override
	public String toString() {
		return "Cliente2 [idCliente=" + idCliente + ", nombre=" + nombre + ", email=" + email + ", createdAt="
				+ createdAt + ", direccion=" + direccion + ", tarjetas=" + tarjetas + "]";
	}
	
	public boolean addTarjetaBancaria(TarjetaBancaria tarjeta) {
		if (tarjetas == null)
			tarjetas = new ArrayList<TarjetaBancaria>();
		return tarjetas.add(tarjeta);
	}
	
	public boolean removeTarjetaBancaria(TarjetaBancaria tarjeta) {
		if (tarjetas == null)
			tarjetas = new ArrayList<TarjetaBancaria>();
		return tarjetas.remove(tarjeta);
	}

}

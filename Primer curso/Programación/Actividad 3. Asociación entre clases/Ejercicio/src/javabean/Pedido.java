package javabean;

import java.time.LocalDate;
import java.util.Objects;

public class Pedido {
	
	private int idPedido;
	private LocalDate createAt;
	private String estado;
	private Cliente cliente;
	
	public Pedido() {
		super();
	}

	public Pedido(int idPedido, LocalDate createAt, String estado, Cliente cliente) {
		super();
		this.idPedido = idPedido;
		this.createAt = createAt;
		this.estado = estado;
		this.cliente = cliente;
	}

	public int getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}

	public LocalDate getCreateAt() {
		return createAt;
	}

	public void setCreateAt(LocalDate createAt) {
		this.createAt = createAt;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idPedido);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Pedido))
			return false;
		Pedido other = (Pedido) obj;
		return idPedido == other.idPedido;
	}

	@Override
	public String toString() {
		return "Pedido [idPedido=" + idPedido + ", createAt=" + createAt + ", estado=" + estado + ", cliente=" + cliente
				+ "]";
	}
	
	

}

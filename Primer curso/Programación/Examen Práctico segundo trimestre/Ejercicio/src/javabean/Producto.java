package javabean;

import java.util.Objects;

public class Producto {
	
	private long idProducto;
	private String descripcionCorta;
	private String descripcionLarga;
	private String marca;
	private String color;
	private double precio;
	private Familia familia;
	private Proveedor proveedor;
	
	public Producto(long idProducto, String descripcionCorta, String descripcionLarga, String marca, String color,
			double precio, Familia familia, Proveedor proveedor) {
		super();
		this.idProducto = idProducto;
		this.descripcionCorta = descripcionCorta;
		this.descripcionLarga = descripcionLarga;
		this.marca = marca;
		this.color = color;
		this.precio = precio;
		this.familia = familia;
		this.proveedor = proveedor;
	}

	public Producto() {
		super();
	}

	public long getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(long idProducto) {
		this.idProducto = idProducto;
	}

	public String getDescripcionCorta() {
		return descripcionCorta;
	}

	public void setDescripcionCorta(String descripcionCorta) {
		this.descripcionCorta = descripcionCorta;
	}

	public String getDescripcionLarga() {
		return descripcionLarga;
	}

	public void setDescripcionLarga(String descripcionLarga) {
		this.descripcionLarga = descripcionLarga;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public Familia getFamilia() {
		return familia;
	}

	public void setFamilia(Familia familia) {
		this.familia = familia;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	@Override
	public String toString() {
		return "Producto [idProducto=" + idProducto + ", descripcionCorta=" + descripcionCorta + ", descripcionLarga="
				+ descripcionLarga + ", marca=" + marca + ", color=" + color + ", precio=" + precio + ", familia="
				+ familia + ", proveedor=" + proveedor + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(idProducto);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Producto other = (Producto) obj;
		return idProducto == other.idProducto;
	}

	
}

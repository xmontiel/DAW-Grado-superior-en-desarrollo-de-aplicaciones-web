package javabean;

public class Producto {
	
	//Atributos de instancia:
	private long codigoDeBarras;
	private String descripcion;
	private double precioUnitario;
	private int cantidadStock;
	private String talla;
	private String color;
	
	//Constructor con todos los atributos:
	public Producto(long codigoDeBarras, String descripcion, double precioUnitario, int cantidadStock, String talla,
			String color) {
		super();
		this.codigoDeBarras = codigoDeBarras;
		this.descripcion = descripcion;
		this.precioUnitario = precioUnitario;
		this.cantidadStock = cantidadStock;
		this.talla = talla;
		this.color = color;
	}
	
	//Constructor sin atributos:
	public Producto() {
		super();
	}

	//Getters and Setters:
	public long getCodigoDeBarras() {
		return codigoDeBarras;
	}

	public void setCodigoDeBarras(long codigoDeBarras) {
		this.codigoDeBarras = codigoDeBarras;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	public int getCantidadStock() {
		return cantidadStock;
	}

	public void setCantidadStock(int cantidadStock) {
		this.cantidadStock = cantidadStock;
	}

	public String getTalla() {
		return talla;
	}

	public void setTalla(String talla) {
		this.talla = talla;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	//ToString:
	@Override
	public String toString() {
		return "Producto [codigoDeBarras=" + codigoDeBarras + ", descripcion=" + descripcion + ", precioUnitario="
				+ precioUnitario + ", cantidadStock=" + cantidadStock + ", talla=" + talla + ", color=" + color + "]";
	}
	
	//Métodos propios:
	
	//Devuelve el precio del producto incrementado con el iva solicitado por argumento.
	public double precioConIva(double iva) {
		
		return precioUnitario*=(1+iva/100.0);
	}
	
	//Aumenta el stock en la cantidad especificada.
	public void aumentarStock(int cantidad) {
		cantidadStock+=cantidad;
	}
	
	/*
	 * Si la cantidad hace que el stock quede por debajo de cero, el stock ni se toca y se devuelve false,
	 * si no disminuir el stock en la cantidad especificada y devolver true.
	 */
	public boolean disminuirStock(int cantidad) {
		if (cantidad<cantidadStock) {
			cantidadStock-=cantidad;
			return true;
		}
		else {
			return false;
		}
	}
	
	//Devuelva el precio aplicado en función de la talla, que tiene el producto:
	public double precioAplicado(String talla) {
		String xs, s, m, l, xl, xxl, xxxl;
		if(talla.equals("xs")) {
			return precioUnitario;
		}
		else if(talla.equals("s")) {
			return precioUnitario*1.03;
		}
		else if(talla.equals("m")) {
			return precioUnitario*1.03;
		}
		else if(talla.equals("l")) {
			return precioUnitario*1.03;
		}
		else if(talla.equals("xl")) {
			return precioUnitario*1.03;
		}
		else if(talla.equals("xxl")) {
			return precioUnitario*1.04;
		}
		else if(talla.equals("xxxl")) {
			return precioUnitario*1.04;
		}
		
		}	
}
		


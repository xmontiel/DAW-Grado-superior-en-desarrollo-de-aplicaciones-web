package javabean;

import java.util.Objects;

public class TarjetaBancaria {
	
	private long numero;
	private int year;
	private int mes;
	private int cvv;
	private String titularTarjeta;
	private Banco banco;
	
	public TarjetaBancaria() {
		super();
	}

	public TarjetaBancaria(long numero, int year, int mes, int cvv, String titularTarjeta, Banco banco) {
		super();
		this.numero = numero;
		this.year = year;
		this.mes = mes;
		this.cvv = cvv;
		this.titularTarjeta = titularTarjeta;
		this.banco = banco;
	}

	public long getNumero() {
		return numero;
	}

	public void setNumero(long numero) {
		this.numero = numero;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public int getCvv() {
		return cvv;
	}

	public void setCvv(int cvv) {
		this.cvv = cvv;
	}

	public String getTitularTarjeta() {
		return titularTarjeta;
	}

	public void setTitularTarjeta(String titularTarjeta) {
		this.titularTarjeta = titularTarjeta;
	}

	public Banco getBanco() {
		return banco;
	}

	public void setBanco(Banco banco) {
		this.banco = banco;
	}

	@Override
	public int hashCode() {
		return Objects.hash(numero);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof TarjetaBancaria))
			return false;
		TarjetaBancaria other = (TarjetaBancaria) obj;
		return numero == other.numero;
	}

	@Override
	public String toString() {
		return "TarjetaBancaria [numero=" + numero + ", year=" + year + ", mes=" + mes + ", cvv=" + cvv
				+ ", titularTarjeta=" + titularTarjeta + ", banco=" + banco + "]";
	}
	
	

}

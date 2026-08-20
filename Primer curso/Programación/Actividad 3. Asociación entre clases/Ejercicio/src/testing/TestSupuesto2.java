package testing;

import java.time.LocalDate;
import java.util.ArrayList;

import javabean.Banco;
import javabean.Cliente;
import javabean.Cliente2;
import javabean.DireccionCliente;
import javabean.Factura;
import javabean.Pais;
import javabean.Pedido;
import javabean.TarjetaBancaria;

public class TestSupuesto2 {
	public static void main(String[] args) {
		
		//(copiar objetos del supuesto 1).
		Pais espana = new Pais(1,"España");
		Pais francia = new Pais();
		francia.setCodigo(2);
		francia.setNombre("Francia");
		
		Banco santander = new Banco(1001, "Santander", espana);
		Banco bnpParibas = new Banco();
		bnpParibas.setCodigo(1002);
		bnpParibas.setNombre("BNP Paribas");
		bnpParibas.setPaisOpera(francia);
		
		TarjetaBancaria card1 = new TarjetaBancaria(1111_2222_3333_4444L, 2025, 01, 201, "Pepe García García", santander);
		TarjetaBancaria card2 = new TarjetaBancaria();
		card2.setNumero(5555_6666_7777_8888L);
		card2.setYear(2026);
		card2.setMes(02);
		card2.setCvv(202);
		card2.setTitularTarjeta("Joe Duplantier");
		card2.setBanco(bnpParibas);
		
		DireccionCliente casita1 = new DireccionCliente("Calle Falsa 123", "Lorca", "Murcia", espana);
		
		Cliente pepe = new Cliente("12345678P", "Pepe García García", "pgg@protonmail.com", LocalDate.of(2020, 12, 31), casita1, card1);
		
		Pedido pedido1 = new Pedido(7000000, LocalDate.of(2025, 1, 4), "Completado", pepe);
		
		Factura factura1 = new Factura("1q2w3e4r5t", "200 kilos de plátanos", LocalDate.of(2025, 1, 5), pedido1);
				
		//Una lista de las tarjetas de un cliente que construimos en memoria
		System.out.println("Una lista de las tarjetas de un cliente que construimos en memoria");
		DireccionCliente casita2 = new DireccionCliente("Fausse Rue 321", "Marseille", "Côte d'Azur", francia);
		
		Cliente2 crepeAtelier = new Cliente2("58008","Crepe Atelier","CA@francegov.fr",LocalDate.of(2011, 11, 11),casita2,null);
		
		TarjetaBancaria card3 = new TarjetaBancaria(1234_4321_2222_3333L,2029,10,203,"Christian Andreu",bnpParibas);
		TarjetaBancaria card4 = new TarjetaBancaria(2345_4234_2342_7656L,2030,11,204,"Jean-Michel Labadie",santander);
		TarjetaBancaria card5 = new TarjetaBancaria(3564_7535_2754_2864L,2031,12,205,"Mario Duplantier",santander);
		
		ArrayList<TarjetaBancaria> lista = new ArrayList<TarjetaBancaria>();
		lista.add(card2);
		lista.add(card3);
		lista.add(card4);
		lista.add(card5);
		crepeAtelier.setTarjetas(lista);
		
		for(TarjetaBancaria tarjeta: crepeAtelier.getTarjetas()) {
			System.out.println(tarjeta);
		}
		
		System.out.println();

		//Y para cada tarjeta sacar el banco de cada tarjeta, y el país del Banco de cada tarjeta.
		System.out.println("Y para cada tarjeta sacar el banco de cada tarjeta, y el país del Banco de cada tarjeta.");
		
		for(TarjetaBancaria tarjeta: crepeAtelier.getTarjetas()) {
			System.out.print(tarjeta.getTitularTarjeta() + " ");
			System.out.print(tarjeta.getBanco().getNombre() + " ");
			System.out.println(tarjeta.getBanco().getPaisOpera().getNombre());
		}
		
		
	}

}

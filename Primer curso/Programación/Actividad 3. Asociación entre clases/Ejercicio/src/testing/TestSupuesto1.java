package testing;

import java.time.LocalDate;

import javabean.Banco;
import javabean.Cliente;
import javabean.DireccionCliente;
import javabean.Factura;
import javabean.Pais;
import javabean.Pedido;
import javabean.TarjetaBancaria;

public class TestSupuesto1 {
	public static void main(String[] args) {
		
		//Dos objetos de la clase País
		System.out.println("Dos objetos de la clase País");
		Pais espana = new Pais(1,"España");
		Pais francia = new Pais();
		francia.setCodigo(2);
		francia.setNombre("Francia");
		System.out.println(espana);
		System.out.println(francia);
		System.out.println();
		
		//Dos objetos de Banco, uno de cada País.
		System.out.println("Dos objetos de Banco, uno de cada País.");
		Banco santander = new Banco(1001, "Santander", espana);
		Banco bnpParibas = new Banco();
		bnpParibas.setCodigo(1002);
		bnpParibas.setNombre("BNP Paribas");
		bnpParibas.setPaisOpera(francia);
		System.out.println(santander);
		System.out.println(bnpParibas);
		System.out.println();
		
		//Dos tarjetas una de cada banco.
		System.out.println("Dos tarjetas una de cada banco.");
		TarjetaBancaria card1 = new TarjetaBancaria(1111_2222_3333_4444L, 2025, 01, 201, "Pepe García García", santander);
		TarjetaBancaria card2 = new TarjetaBancaria();
		card2.setNumero(5555_6666_7777_8888L);
		card2.setYear(2026);
		card2.setMes(02);
		card2.setCvv(202);
		card2.setTitularTarjeta("Joe Duplantier");
		card2.setBanco(bnpParibas);
		System.out.println(card1);
		System.out.println(card2);
		System.out.println();
		
		//Una dirección.
		System.out.println("Una dirección.");
		DireccionCliente casita1 = new DireccionCliente("Calle Falsa 123", "Lorca", "Murcia", espana);
		System.out.println(casita1);
		System.out.println();
		
		//Un cliente con su tarjeta y su dirección.
		System.out.println("Un cliente con su tarjeta y su dirección.");
		Cliente pepe = new Cliente("12345678P", "Pepe García García", "pgg@protonmail.com", LocalDate.of(2020, 12, 31), casita1, card1);
		System.out.println(pepe);
		System.out.println();
		
		//Un Pedido con su cliente
		System.out.println("Un Pedido con su cliente");
		Pedido pedido1 = new Pedido(7000000, LocalDate.of(2025, 1, 4), "Completado", pepe);
		System.out.println(pedido1);
		System.out.println();
		
		//y una Factura con su Pedido.
		System.out.println("y una Factura con su Pedido.");
		Factura factura1 = new Factura("1q2w3e4r5t", "200 kilos de plátanos", LocalDate.of(2025, 1, 5), pedido1);
		System.out.println(factura1);
		System.out.println();
		
		//Y ahora obtener mediante la variable de Factura creada la siguiente información (con syso):
		System.out.println("Y ahora obtener mediante la variable de Factura creada la siguiente información (con syso):");
		//La descripción de la Factura
		System.out.println("La descripción de la Factura");
		System.out.println(factura1.getDescripcion());
		System.out.println();
		
		//La fecha y el estado del pedido
		System.out.println("La fecha y el estado del pedido");
		System.out.println("Fecha factura: " + factura1.getFechaFactura());
		System.out.println("Fecha pedido: " + factura1.getPedido().getCreateAt());
		System.out.println(factura1.getPedido().getEstado());
		System.out.println();
		
		//El nombre del cliente de ese pedido de esa factura
		System.out.println("El nombre del cliente de ese pedido de esa factura");
		System.out.println(factura1.getPedido().getCliente().getNombre());
		System.out.println();
		
		//La dirección del cliente del pedido de la factura
		System.out.println("La dirección del cliente del pedido de la factura");
		System.out.println(factura1.getPedido().getCliente().getDireccion());
		System.out.println(factura1.getPedido().getCliente().getDireccion().getDireccion());
		System.out.println();
		
		//El número de tarjeta del cliente del pedido de la factura
		System.out.println("El número de tarjeta del cliente del pedido de la factura");
		System.out.println(factura1.getPedido().getCliente().getTarjeta().getNumero());
		System.out.println();
		
		//El nombre del titular de la tarjeta del cliente del pedido de la factura
		System.out.println("El nombre del titular de la tarjeta del cliente del pedido de la factura");
		System.out.println(factura1.getPedido().getCliente().getTarjeta().getTitularTarjeta());
		System.out.println();
		
		//El nombre del banco de la tarjeta del cliente del pedido de la factura
		System.out.println("El nombre del banco de la tarjeta del cliente del pedido de la factura");
		System.out.println(factura1.getPedido().getCliente().getTarjeta().getBanco().getNombre());
		System.out.println();
		
		//El país del banco de la tarjeta del cliente del pedido de la factura
		System.out.println("El país del banco de la tarjeta del cliente del pedido de la factura");
		System.out.println(factura1.getPedido().getCliente().getTarjeta().getBanco().getPaisOpera().getNombre());
		System.out.println();
		
		//El país de la dirección del cliente del pedido de la factura
		System.out.println("El país de la dirección del cliente del pedido de la factura");
		System.out.println(factura1.getPedido().getCliente().getDireccion().getPais().getNombre());
		System.out.println();
		
	}

}

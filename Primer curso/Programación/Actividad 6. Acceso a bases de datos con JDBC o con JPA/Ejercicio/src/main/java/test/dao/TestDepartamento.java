package test.dao;

import modelo.dao.DepartamentoDao;
import modelo.dao.DepartamentoDaoImplJpa;
import modelo.entities.Departamento;
import modelo.entities.Empleado;

public class TestDepartamento {

	public static void main(String[] args) {
		DepartamentoDao ddao = new DepartamentoDaoImplJpa();
		Departamento departamento50 = new Departamento(50,"Zaragoza","Direccion");
		Departamento departamento60 = new Departamento();
		departamento60.setIdDepar(60);
		departamento60.setDireccion("Malaga");
		departamento60.setNombre("Seguridad");
		
		System.out.println("findById:");
		System.out.println(ddao.findById(10));
		
		System.out.println("findAll:");
		ddao.findAll().forEach(System.out::println);
		
		System.out.println("insert:");
		ddao.insert(departamento50);
		ddao.insert(departamento60);
		ddao.findAll().forEach(System.out::println);
		
		System.out.println("update:");
		System.out.println(ddao.findById(10).getDireccion());
		Departamento actu = ddao.findById(10);
		actu.setDireccion("Getafe");
		System.out.println(ddao.update(actu));
		System.out.println(ddao.findById(10).getDireccion());
		
		System.out.println("deletebyId:");
		ddao.deletebyId(50);
		ddao.findAll().forEach(System.out::println);
		
		

	}

}

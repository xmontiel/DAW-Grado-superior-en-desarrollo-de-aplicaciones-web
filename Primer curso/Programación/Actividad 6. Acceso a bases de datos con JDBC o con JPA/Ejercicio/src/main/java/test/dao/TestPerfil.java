package test.dao;

import modelo.dao.PerfilDao;
import modelo.dao.PerfilDaoImplJpa;
import modelo.entities.Empleado;
import modelo.entities.Perfil;

public class TestPerfil {
// ES AUTOINCREMENTAL!!!
	public static void main(String[] args) {
		PerfilDao pdao = new PerfilDaoImplJpa();
//		Perfil perfil5 = new Perfil(5, "Matones", 111.00);
		Perfil perfil5 = new Perfil();
		Perfil perfil6 = new Perfil();
//		perfil6.setIdPerfil(6);
		perfil5.setNombre("Matones");
		perfil5.setTasaStandard(111.00);	
		perfil6.setNombre("Becarios");
		perfil6.setTasaStandard(10.00);
		
		System.out.println("findById:");
		System.out.println(pdao.findById(1));
		
		System.out.println("findAll:");
		pdao.findAll().forEach(System.out::println);
		
		System.out.println("insert:");
		pdao.insert(perfil5);
		pdao.insert(perfil6);
		pdao.findAll().forEach(System.out::println);
		
		System.out.println("update:");
		System.out.println(pdao.findById(2).getNombre());
		Perfil actu = pdao.findById(2);
		actu.setNombre("Jefazo");
		System.out.println(pdao.update(actu));
		System.out.println(pdao.findById(2).getNombre());
		
		System.out.println("deletebyId:");
		pdao.deletebyId(5);
		pdao.findAll().forEach(System.out::println);
		
		
		
	}

}

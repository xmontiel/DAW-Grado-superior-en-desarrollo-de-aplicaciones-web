package test.dao;

import java.time.LocalDate;

import modelo.dao.DepartamentoDao;
import modelo.dao.DepartamentoDaoImplJpa;
import modelo.dao.EmpleadoDao;
import modelo.dao.EmpleadoDaoImplJpa;
import modelo.dao.PerfilDao;
import modelo.dao.PerfilDaoImplJpa;
import modelo.entities.Departamento;
import modelo.entities.Empleado;
import modelo.entities.Perfil;

public class TestEmpleados {

	public static void main(String[] args) {
		EmpleadoDao edao = new EmpleadoDaoImplJpa();
		DepartamentoDao ddao = new DepartamentoDaoImplJpa();
		PerfilDao pdao = new PerfilDaoImplJpa();
		
		Departamento departamento = ddao.findById(10);	
		Perfil perfil = pdao.findById(1);
		
		Empleado empleadoNuevo = new Empleado();
		empleadoNuevo.setApellidos("DuBois");
		empleadoNuevo.setEmail("tequila@terra.es");
		empleadoNuevo.setFechaIngreso(LocalDate.of(2011,11,11));
		empleadoNuevo.setFechaNacimiento(LocalDate.of(1991,11,11));
		empleadoNuevo.setGenero("H");
		empleadoNuevo.setNombre("Harry");
		empleadoNuevo.setPassword("1234");
		empleadoNuevo.setSalario(60000.00);
		empleadoNuevo.setDepartamento(departamento);
		empleadoNuevo.setPerfil(perfil);
		
		System.out.println("findById:");
		System.out.println(edao.findById(100));
		
		System.out.println("insert:");
		System.out.println(edao.insert(empleadoNuevo));
		
		System.out.println("update:");
		System.out.println(edao.findById(100).getPassword());
		Empleado actu = edao.findById(100);
		actu.setPassword("admin");
		System.out.println(edao.update(actu));
		System.out.println(edao.findById(100).getPassword());
		
		System.out.println("deletebyId:");
		System.out.println(edao.deletebyId(121));
		System.out.println(edao.findById(121));
		
		System.out.println("findAll:");
		System.out.println(edao.findAll());
		
		System.out.println("empleadosByDepartamento:");
		System.out.println(edao.empleadosByDepartamento(10));
		
		System.out.println("empleadosByGenero:");
		System.out.println(edao.empleadosByGenero("M"));
		
		System.out.println("empleadosByApellido:");
		System.out.println(edao.empleadosByApellido("Diaz"));
		
		System.out.println("empleadosByIdPerfil:");
		System.out.println(edao.empleadosByIdPerfil(1));
		
		System.out.println("salarioTotal:");
		System.out.println(edao.salarioTotal());
		
		System.out.println("salarioTotal (Por departamento):");
		System.out.println(edao.salarioTotal(10));
		

	}

}

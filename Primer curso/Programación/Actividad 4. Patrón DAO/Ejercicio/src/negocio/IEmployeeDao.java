package negocio;

import java.util.List;

import javabean.Employee;

public interface IEmployeeDao extends ICrudGenerico<Employee, Integer>{
	
	List<Employee> BuscarPorDepartamento(int departmentId);
	List<Employee> BuscarPorTrabajo(String jobId);
	double calcularMasaSalarial();
	double masaSalarialPorDep(int departmentId);
	List<Employee> BuscarFueraSalario();

}

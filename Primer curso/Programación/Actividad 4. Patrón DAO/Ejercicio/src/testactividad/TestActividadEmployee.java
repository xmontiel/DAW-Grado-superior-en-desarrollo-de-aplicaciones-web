package testactividad;

import negocio.EmployeeDaoImplList;
import negocio.IEmployeeDao;

public class TestActividadEmployee {

	public static void main(String[] args) {
		
		//Test EmployeeDaoImplList
		System.out.println("\nTest EmployeeDaoImplList\n");
		
		IEmployeeDao iEmployeeDao = new EmployeeDaoImplList();
		
		System.out.println("Deberían salir los dos trabajadores del departamento de informática:");
		System.out.println(iEmployeeDao.BuscarPorDepartamento(30));
		
		System.out.println("Deberín salir el presidente:");
		System.out.println(iEmployeeDao.BuscarPorTrabajo("AD_PRESS"));
		
		System.out.println("Debería salir la suma de los cuatro sueldos (TOTAL DE 320.000):");
		System.out.println(iEmployeeDao.calcularMasaSalarial());
		
		System.out.println("Debería salir la suma de los dos sueldos del departamento de informática (TOTAL DE 50.000):");
		System.out.println(iEmployeeDao.masaSalarialPorDep(30));
		
		System.out.println("Deberían salir el jefe de proyecto y un informático:");
		System.out.println(iEmployeeDao.BuscarFueraSalario());
		
	}

}

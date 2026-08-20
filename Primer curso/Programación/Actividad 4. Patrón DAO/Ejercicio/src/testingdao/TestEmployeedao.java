package testingdao;

import javabean.Employee;
import negocio.EmployeeDaoImplList;
import negocio.IEmployeeDao;

public class TestEmployeedao {

	public static void main(String[] args) {
		IEmployeeDao iEmployeeDao = new EmployeeDaoImplList();
		
		for(Employee ele: iEmployeeDao.findAll())
			System.out.println(ele);
		
		System.out.println(iEmployeeDao.findById(114));
		
		

	}

}

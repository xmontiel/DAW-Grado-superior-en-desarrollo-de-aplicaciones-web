package testingdao;

import javabean.Department;
import negocio.DepartmentDaoImplList;
import negocio.IDepartmentDao;

public class TestDepartmentDao {

	public static void main(String[] args) {
		IDepartmentDao iDepartmentDao = new DepartmentDaoImplList();
		
		for (Department ele: iDepartmentDao.findAll())
			System.out.println(ele);
		
		System.out.println(iDepartmentDao.findById(30));

	}

}

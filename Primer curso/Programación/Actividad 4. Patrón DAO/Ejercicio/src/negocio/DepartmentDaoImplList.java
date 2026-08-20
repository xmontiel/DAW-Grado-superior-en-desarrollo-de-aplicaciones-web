package negocio;

import java.util.ArrayList;
import java.util.List;

import javabean.Department;
import javabean.Location;

public class DepartmentDaoImplList implements IDepartmentDao{
	
	private List<Department> lista;
	private ILocationDao iLocationDao;
	
	
	public DepartmentDaoImplList() {
		lista = new ArrayList<Department>();
		iLocationDao = new LocationDaoImplList();
		cargarDatos();
	}
	
	private void cargarDatos() {
		lista.add(new Department(10, "Financiero", 100, iLocationDao.findById(1500)));
		lista.add(new Department(20, "Ventas", 201, iLocationDao.findById(1600)));
		lista.add(new Department(30, "Informática", 114, iLocationDao.findById(1700)));
		
	}

	@Override
	public Department findById(Integer atributoPk) {
	
			for (Department ele: lista) {
				if (ele.getDepartmentId() == atributoPk)
					return ele;
			}
			
			return null;
	}

	@Override
	public int insertOne(Department objeto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateOne(Department objeto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteById(Integer atributoPk) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteObj(Department objeto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Department> findAll() {
		// TODO Auto-generated method stub
		return lista;
	}

}

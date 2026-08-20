package negocio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javabean.Country;
import javabean.Department;
import javabean.Employee;

public class EmployeeDaoImplList implements IEmployeeDao{
	
	private List<Employee> lista;
	private IDepartmentDao iDepartmentDao;
	private IJobDao  iJobDao;
	
	public EmployeeDaoImplList() {
		lista = new ArrayList<Employee>();
		iDepartmentDao = new DepartmentDaoImplList();
		iJobDao = new JobDaoImplList();
		
		cargarDatos();
		
		
	}
	
	private void cargarDatos() {
		lista.add(new Employee(114, "Esteban", "Raphaelly", "est@fp.com", "678678678", LocalDate.of(1996, 7, 7),
								iJobDao.findById("IT_PROG"), 15_000, 0.2,  iDepartmentDao.findById(30)));
		lista.add(new  Employee(115, "Ana", "Koo", "ana@fp.com", "678678678", LocalDate.of(1996, 7, 7), 
				iJobDao.findById("IT_PROG"), 35_000, 0.2,  iDepartmentDao.findById(30)));
		lista.add(new  Employee(116, "carlos", "Colmenares", "carlos@fp.com", "678678678", LocalDate.of(1996, 7, 7), 
				iJobDao.findById("AD_PRESS"), 135_000, 0.2,  iDepartmentDao.findById(20)));
		lista.add(new  Employee(117, "Mario", "Duplantier", "mario@fp.com", "666666666", LocalDate.of(1996, 7, 7), 
				iJobDao.findById("JF_PROY"), 135_000, 0.2,  iDepartmentDao.findById(10)));
		 
	}

	@Override
	public Employee findById(Integer atributoPk) {
		for (Employee ele: lista) {
			if (ele.getEmployeeId() == atributoPk)
				return ele;
		}
		
		return null;
	}

	@Override
	public int insertOne(Employee objeto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateOne(Employee objeto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteById(Integer atributoPk) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteObj(Employee objeto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return lista;
	}

	@Override
	public List<Employee> BuscarPorDepartamento(int departmentId) {
		List<Employee> aux = new ArrayList<Employee>();
		
		for (Employee employee: lista) {
			
			if (employee.getDepartment().getDepartmentId() == departmentId)
				aux.add(employee);
		
		}
				
		return aux;
	}

	@Override
	public List<Employee> BuscarPorTrabajo(String jobId) {
		List<Employee> aux = new ArrayList<Employee>();
		
		for (Employee employee: lista) {
			
			if (employee.getJob().getJobId().equals(jobId))
				aux.add(employee);
		
		}
				
		return aux;
	}

	@Override
	public double calcularMasaSalarial() {
		double masaTotal = 0;
		for (Employee employee: lista) {
			masaTotal = masaTotal + employee.getSalary();
		}
		return masaTotal;
	}

	@Override
	public double masaSalarialPorDep(int departmentId) {
		double masaDep = 0;
		for (Employee employee: lista) {
			if (employee.getDepartment().getDepartmentId() == departmentId)
			masaDep = masaDep + employee.getSalary();
		}
		return masaDep;
	}

	@Override
	public List<Employee> BuscarFueraSalario() {
		List<Employee> aux = new ArrayList<Employee>();
		
		for (Employee employee: lista) {
			
			if (employee.getSalary() < employee.getJob().getMinSalary() || employee.getSalary() > employee.getJob().getMaxSalary())
				aux.add(employee);
		
		}
				
		return aux;
	}
	
	

}

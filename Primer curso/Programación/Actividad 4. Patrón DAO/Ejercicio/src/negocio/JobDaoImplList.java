package negocio;

import java.util.ArrayList;
import java.util.List;

import javabean.Country;
import javabean.Job;

public class JobDaoImplList implements IJobDao{
	
	private List<Job> lista;
	
	public JobDaoImplList() {
		lista = new ArrayList<Job>();
		cargarDatos();
	}
	
	private void cargarDatos() {
		lista.add(new Job("IT_PROG","Programador", 20000,38000));
		lista.add(new Job("JF_PROY","Jefe de Proyecto", 38000,98000));
		lista.add(new Job("AD_PRESS","Presidente", 120000,380000));
		
	}

	@Override
	public Job findById(String atributoPk) {
		for (Job ele: lista) {
			if (ele.getJobId().equals(atributoPk))
				return ele;
		}
		
		return null;
	}

	@Override
	public int insertOne(Job objeto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateOne(Job objeto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteById(String atributoPk) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteObj(Job objeto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Job> findAll() {
		// TODO Auto-generated method stub
		return lista;
	}

}

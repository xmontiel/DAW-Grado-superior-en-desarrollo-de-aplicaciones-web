package negocio;

import java.util.ArrayList;
import java.util.List;

import javabean.Region;

public class RegionDaoImplList implements IRegionDao{
	
	List<Region> lista;
	
	public RegionDaoImplList() {
		lista= new ArrayList<Region>();
		cargarDatos();
	}
	
	private void cargarDatos() {
		lista.add(new Region(1,"Europa"));
		lista.add(new Region(2,"Asia"));
		lista.add(new Region(3,"America"));
		lista.add(new Region(4,"Oceania"));
		lista.add(new Region(5,"Africa"));
		
	}

	@Override
	public Region findById(Integer atributoPk) {
		for (Region region: lista) {
			if (region.getRegionId() == atributoPk)
				return region;
		}
		
		return null;
	}

	@Override
	public int insertOne(Region objeto) {
		if (lista.contains(objeto))
			return 0;
		else {
			lista.add(objeto);
			return 1;
		}
			
	}

	@Override
	public int updateOne(Region objeto) {
		int posicion = lista.indexOf(objeto);
		if (posicion != -1) {
			lista.set(posicion, objeto);
			return 1;
		}
			
		return 0;
	}

	@Override
	public int deleteById(Integer atributoPk) {
	//	Region region = findById(atributoPk);
	//	return deleteObj(region);
		
		return deleteObj(findById(atributoPk));
		
	}

	@Override
	public int deleteObj(Region objeto) {
		
 		return    lista.remove(objeto)  ? 1 : 0;
		/*
		if (lista.remove(objeto))
			return 1;
		else
			return 0;
		*/ 
	}

	@Override
	public List<Region> findAll() {
		// TODO Auto-generated method stub
		return lista;
	}

}

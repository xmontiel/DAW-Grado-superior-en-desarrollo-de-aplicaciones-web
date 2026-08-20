package negocio;

import java.util.ArrayList;
import java.util.List;

import javabean.Country;
import javabean.Region;

public class CountryDaoImplList implements ICountryDao{
	
	private List<Country> lista;
	private IRegionDao iRegionDao;
	
	public CountryDaoImplList() {
		lista = new ArrayList<Country>();
		iRegionDao = new RegionDaoImplList();
		cargarDatos();
	}
	
	private void cargarDatos() {
		
		lista.add(new Country("ES", "España", iRegionDao.findById(1)));
		lista.add(new Country("FR", "Francia", iRegionDao.findById(1)));
		lista.add(new Country("AL", "Alemania", iRegionDao.findById(1)));
		lista.add(new Country("AR", "Argentina", iRegionDao.findById(3)));
		lista.add(new Country("CO", "Colombia", iRegionDao.findById(3)));
		 
	}

	@Override
	public Country findById(String atributoPk) {
		for (Country country: lista) {
			if (country.getCountryId().equals(atributoPk))
				return country;
		}
		
		return null;
	}

	@Override
	public int insertOne(Country objeto) {
		if (lista.contains(objeto))
			return 0;
		else {
			lista.add(objeto);
			return 1;
		}
	}

	@Override
	public int updateOne(Country objeto) {
		int posicion = lista.indexOf(objeto);
		if (posicion != -1) {
			lista.set(posicion, objeto);
			return 1;
		}
			
		return 0;
	}

	@Override
	public int deleteById(String atributoPk) {
		// TODO Auto-generated method stub
		return deleteObj(findById(atributoPk));
	}

	@Override
	public int deleteObj(Country objeto) {
		// TODO Auto-generated method stub
		return lista.remove(objeto) ? 1 : 0;
	}

	@Override
	public List<Country> findAll() {
		// TODO Auto-generated method stub
		return lista;
	}

	@Override
	public List<Country> buscarPorRegion(int regionId) {
		List<Country> aux = new ArrayList<Country>();
		
		for (Country country: lista) {
			
			if (country.getRegion().getRegionId() == regionId)
				aux.add(country);
		
		}
				
		return aux;
	}

	@Override
	public List<Country> buscarPorEmpiezaEnName(String cadena) {
		List<Country> aux = new ArrayList<Country>();
		
		for (Country country: lista) {
			
			if (country.getCountryName().startsWith(cadena))
				aux.add(country);
			
		}
		
		
		return aux;
	}
	
	

}

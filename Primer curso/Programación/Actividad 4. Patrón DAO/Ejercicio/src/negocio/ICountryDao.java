package negocio;

import java.util.List;

import javabean.Country;

public interface ICountryDao extends ICrudGenerico<Country, String>{
	
	List<Country> buscarPorRegion(int regionId);
	List<Country> buscarPorEmpiezaEnName(String cadena);

}

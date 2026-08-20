package negocio;

import java.util.List;

import javabean.Location;

public interface ILocationDao extends ICrudGenerico<Location, Integer>{
	
	List<Location> buscarPorCity(String city);
	List<Location> buscarPorPostalCode(String postalCode);
	List<Location> buscarPorPais(String countryId);

}

package testingdao;

import javabean.Country;
import javabean.Region;
import negocio.CountryDaoImplList;
import negocio.ICountryDao;
import negocio.IRegionDao;
import negocio.RegionDaoImplList;

public class TestContryDao {
	
	private static ICountryDao iCountryDao = new CountryDaoImplList();
	private static IRegionDao iRegionDao = new RegionDaoImplList();
	
	private static int cont = 0;

	public static void main(String[] args) {
		
	 	todos();
		
	//	empiezaPor();
		
	//	porRegion();
	//	alta();
		
		
		System.out.println("\nFIN DE PROGRAMA");
	}
	
	public static void todos() {
		
		System.out.println("\nLISTADO DE FINDALL\n");
	 
		for (Country country: iCountryDao.findAll())
			System.out.println(country);
	 
	//	iCountryDao.findAll().forEach(System.out::println);
	}
	
	public static void alta() {
		
		
		Country pais = new Country("BR", "Brasil", iRegionDao.findById(3));
		
		System.out.println("resultado alta pais - true : " + iCountryDao.insertOne(pais));
		System.out.println("resultado alta pais : -false " + iCountryDao.insertOne(pais));
		
		todos();
	}
	
	public static void empiezaPor() {
		cont=0;
		System.out.println("\nLISTADO DE EMPIEZAN EN\n");
		 
		for (Country country: iCountryDao.buscarPorEmpiezaEnName("A")) {
			System.out.println(country);
			cont++;
		}
		
		if (cont == 0)
			System.out.println("No hay paises para esta seleccion");
	}
	
	public static void porRegion() {
		System.out.println("\nLISTADO DE UNA REGION\n");
		cont=0;
		int regionId = 7;
		Region region = iRegionDao.findById(regionId);
		if (region == null) {
			System.out.println("Region no existe");
		}else {
				for (Country country: iCountryDao.buscarPorRegion(2)) {
					System.out.println(country);
					cont++;
				}
				
				if (cont == 0)
					System.out.println("No hay paises para esta seleccion");
		}
	}

}

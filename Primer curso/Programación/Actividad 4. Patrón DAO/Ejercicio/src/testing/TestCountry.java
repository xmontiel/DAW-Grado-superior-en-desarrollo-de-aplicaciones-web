package testing;

import javabean.Country;
import javabean.Region;

public class TestCountry {

	public static void main(String[] args) {
		Region region1 = new Region(1, "Europa");
		Country esp = new Country("SP", "España", region1);
		
		Country arg = new Country("AR", "Argentina", new Region(2,"Sur América"));
		
		Country colombia = new Country("CO", "Colombia", arg.getRegion());
		Region region2 = arg.getRegion();
		
		System.out.println(region1);
		System.out.println(esp);
		System.out.println(arg);
		System.out.println(region2);
		
		
		System.out.println("nombre de la region del pais arg : " + arg.getRegion().getRegionName());
		
		System.out.println("nombre de la region del pais esp : " + esp
																.getRegion()
																.getRegionName()
																.substring(0,3)
																.toUpperCase());
		
		
		
		
		

	}

}

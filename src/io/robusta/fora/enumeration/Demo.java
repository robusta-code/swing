package io.robusta.fora.enumeration;

import java.util.ArrayList;
import java.util.List;



public class Demo {

	public static void main(String[] args) {

		for (Country c : Country.values()) {
//			System.out.println(c.toString()+" -> "+c.getIso());
		}
		
		
		ConstanteCountry france = ICountry.FRANCE;
		france.setName("GB");
		
		System.out.println(france);
		
		
		@SuppressWarnings({ "rawtypes", "unused" })
		List list = new ArrayList();
		
		
		
		

	}

	@Deprecated
	public static float getPIB(Country country) {

		switch (country) {

		case FRANCE:
			return 12555112f;
		
		default:
			return 100000;

		}

	}

}

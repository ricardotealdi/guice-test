package br.com.tealdi.service;

import java.util.GregorianCalendar;

public class AgeCalculator implements IAgeCalculator {

	@Override
	public int calculate(GregorianCalendar birthday,
			GregorianCalendar currentDate) {
		
		int age = currentDate.get(GregorianCalendar.YEAR) 
				- birthday.get(GregorianCalendar.YEAR);
		
		if(currentDate.get(GregorianCalendar.DAY_OF_YEAR) 
				< birthday.get(GregorianCalendar.DAY_OF_YEAR)) {
			age--;
		}
		
		return age;
	}

	
}


package br.com.tealdi.service;
import java.util.GregorianCalendar;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

public class AgeCalculatorTest {
	
	private IAgeCalculator calculator;
	
	@Before
	public void setUp() {
		calculator = new AgeCalculator();
	}

	@Test
	public void shouldCalculateWhenBirthdayDayOfYearIsFewerThanCurrentDayOfYear() {
		GregorianCalendar currentDate = new GregorianCalendar(2011, 4, 1);
		GregorianCalendar birthday = new GregorianCalendar(1985, 5, 18);
		
		Assert.assertEquals(25, calculator.calculate(birthday, currentDate));
	}
	
	@Test
	public void shouldCalculateWhenBirthdayDayOfYearIsTheSameAsCurrentDayOfYear() {
		GregorianCalendar currentDate = new GregorianCalendar(2011, 5, 18);
		GregorianCalendar birthday = new GregorianCalendar(1985, 5, 18);
		
		Assert.assertEquals(26, calculator.calculate(birthday, currentDate));
	}
	

	@Test
	public void shouldCalculateWhenBirthdayDayOfYearIsBiggerThanCurrentDayOfYear() {
		GregorianCalendar currentDate = new GregorianCalendar(2011, 5, 18);
		GregorianCalendar birthday = new GregorianCalendar(1985, 5, 18);
		
		Assert.assertEquals(26, calculator.calculate(birthday, currentDate));
	}
}

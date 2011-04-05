package br.com.tealdi.service;

import static org.mockito.Mockito.*;

import java.util.GregorianCalendar;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;

import br.com.tealdi.object.Person;
import br.com.tealdi.util.DependencyRepository;
import br.com.tealdi.util.IDateTime;
import br.com.tealdi.util.DependencyInjectionModule;

public class PersonAgeCalculatorTest {

	private int expectedAge;
	private int retrievedAge;
	private GregorianCalendar birthday;
	private GregorianCalendar currentDate;
	private Person person;
	private IAgeCalculator mockedAgeCalculator;
	private IDateTime mockedDate;
	private IPersonAgeCalculator calculator;

	@Before
	public void setUp() {
		expectedAge = 10;
		birthday = new GregorianCalendar(1985, 5, 1);
		currentDate = new GregorianCalendar(2011, 01, 01);
		
		person = new Person("bla", birthday);
		
		mockedAgeCalculator = mock(IAgeCalculator.class);
		mockedDate = mock(IDateTime.class);
		
		calculator = new PersonAgeCalculator(mockedAgeCalculator, mockedDate);
	}
	
	/*@Test
	public void shouldBla() {
		IPersonAgeCalculator calc = DependencyRepository.resolve(IPersonAgeCalculator.class);
		
		System.out.println(calc.calculateFor(person));
	}*/
	
	@Test
	public void shouldCalculate() {
		givenThisDate()
			.whenCalculatingAnAge()
			.shouldBeEqualToExpectedAge();
	}
	
	@Test
	public void shouldUseAgeCalculatorToCalculate() {
		givenThisDate()
			.whenCalculatingAnAge()
			.shouldUseTheCalculator();
	}
	
	@Test
	public void shouldUseCurrentDateToCalculate() {
		givenThisDate()
			.whenCalculatingAnAge()
			.shouldUseTheCurrentDateTime();
	}

	private int shouldUseTheCalculator() {
		return verify(mockedAgeCalculator, times(1))
			.calculate(birthday, currentDate);
	}

	private void shouldUseTheCurrentDateTime() {
		verify(mockedDate, times(1))
			.now();
	}

	private PersonAgeCalculatorTest givenThisDate() {
		when(mockedAgeCalculator
				.calculate(
						isA(GregorianCalendar.class), 
						isA(GregorianCalendar.class)))
			.thenReturn(expectedAge);
		
		when(mockedDate.now()).thenReturn(currentDate);
		
		return this;
	}
	
	private PersonAgeCalculatorTest whenCalculatingAnAge() {
		retrievedAge = calculator.calculateFor(person);
		return this;
	}
	
	private void shouldBeEqualToExpectedAge() {
		Assert.assertEquals(expectedAge, retrievedAge);
	}
}

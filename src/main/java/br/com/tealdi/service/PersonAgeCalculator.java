package br.com.tealdi.service;

import com.google.inject.Inject;

import br.com.tealdi.object.Person;
import br.com.tealdi.util.IDateTime;

public class PersonAgeCalculator implements IPersonAgeCalculator {

	private final IAgeCalculator calculator;
	private final IDateTime dateWrapper;

	@Inject
	public PersonAgeCalculator(IAgeCalculator calculator, IDateTime dateWrapper) {
		this.calculator = calculator;
		this.dateWrapper = dateWrapper;
	}

	@Override
	public int calculateFor(Person person) {
		return calculator.calculate(person.getBirthday(), dateWrapper.now());
	}
}

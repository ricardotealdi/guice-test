package br.com.tealdi.service;

import br.com.tealdi.object.Person;

public interface IPersonAgeCalculator {

	public abstract int calculateFor(Person person);

}
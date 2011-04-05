package br.com.tealdi.service;

import com.google.inject.ImplementedBy;

import br.com.tealdi.object.Person;

@ImplementedBy(PersonAgeCalculator.class)
public interface IPersonAgeCalculator {

	public abstract int calculateFor(Person person);

}
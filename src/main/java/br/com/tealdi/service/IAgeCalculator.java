package br.com.tealdi.service;

import java.util.GregorianCalendar;

import com.google.inject.ImplementedBy;

@ImplementedBy(AgeCalculator.class)
public interface IAgeCalculator {

	public abstract int calculate(GregorianCalendar birthday,
			GregorianCalendar currentDate);

}
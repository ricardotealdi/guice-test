package br.com.tealdi.service;

import java.util.GregorianCalendar;

public interface IAgeCalculator {

	public abstract int calculate(GregorianCalendar birthday,
			GregorianCalendar currentDate);

}
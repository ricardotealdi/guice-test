package br.com.tealdi.object;

import java.util.GregorianCalendar;

public class Person {
	private final String name;
	private final GregorianCalendar birthday; 

	public Person(String name, GregorianCalendar birthday) {
		this.name = name;
		this.birthday = birthday;
	}
	
	public String getName() {
		return name;
	}

	public GregorianCalendar getBirthday() {
		return birthday;
	}
}

package br.com.tealdi.util;

import java.util.GregorianCalendar;

import com.google.inject.ImplementedBy;

@ImplementedBy(SystemDateTime.class)
public interface IDateTime {

	public GregorianCalendar now();
}

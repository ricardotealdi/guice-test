package br.com.tealdi.util;

import java.util.GregorianCalendar;

public class SystemDateTime implements IDateTime {

	@Override
	public GregorianCalendar now() {
		return new GregorianCalendar();
	}

}

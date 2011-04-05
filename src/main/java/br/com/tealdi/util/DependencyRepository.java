package br.com.tealdi.util;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class DependencyRepository {
	
	private static Injector injector;
	
	public static <T> T resolve(Class<T> klazz) {
		return (T) getInjector().getInstance(klazz);
	}

	private static Injector getInjector() {
		if(injector == null) {
			injector = Guice.createInjector(new DependencyInjectionModule());
		}
		
		return injector;
	}
}

package com.mabellou.specification.composite;

import com.mabellou.specification.Container;

import java.util.function.Function;

public class EqualSpecification extends ValueBoundSpecification {

	private EqualSpecification(Integer aValue, Function<Container, Integer> aSymbol) {
		super(aValue, aSymbol);
	}

	public static EqualSpecification of(Integer aValue, Function<Container, Integer> aSymbol){
		return new EqualSpecification(aValue, aSymbol);
	}

	@Override
	public boolean isSatisfiedBy(Container container) {
		return aSymbol.apply(container).intValue() == aValue.intValue();
	}

	@Override
	public String toString(Container container) {
		return String.format(" %d == %d [=%s] ",
				aSymbol.apply(container),
				aValue,
				isSatisfiedBy(container));
	}
}

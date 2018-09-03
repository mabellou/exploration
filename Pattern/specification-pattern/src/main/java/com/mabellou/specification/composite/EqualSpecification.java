package com.mabellou.specification.composite;

import com.mabellou.specification.Container;

import java.util.function.Function;

public class EqualSpecification extends ValueBoundSpecification {

	public EqualSpecification(Integer aValue, Function<Container, Integer> aSymbol) {
		super(aValue, aSymbol);
	}

	@Override
	public boolean isSatisfiedBy(Container container) {
		return aSymbol.apply(container).intValue() == aValue.intValue();
	}
}

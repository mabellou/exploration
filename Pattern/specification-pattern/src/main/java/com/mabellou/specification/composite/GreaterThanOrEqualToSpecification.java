package com.mabellou.specification.composite;

import com.mabellou.specification.Container;

import java.util.function.Function;

public class GreaterThanOrEqualToSpecification extends ValueBoundSpecification {


	public GreaterThanOrEqualToSpecification(Integer aValue, Function<Container, Integer> aSymbol) {
		super(aValue, aSymbol);
	}

	@Override
	public boolean isSatisfiedBy(Container container) {
		return aSymbol.apply(container) >= aValue;
	}
}

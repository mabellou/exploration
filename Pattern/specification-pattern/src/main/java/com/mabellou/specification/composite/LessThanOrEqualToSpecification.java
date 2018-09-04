package com.mabellou.specification.composite;

import com.mabellou.specification.Container;

import java.util.function.Function;

public class LessThanOrEqualToSpecification extends ValueBoundSpecification {

	public LessThanOrEqualToSpecification(Integer aValue, Function<Container, Integer> aSymbol) {
		super(aValue, aSymbol);
	}

	@Override
	public boolean isSatisfiedBy(Container container) {
		return aSymbol.apply(container) <= aValue;
	}

	public String write(Container container) {
		return String.format("%d isLessThanOrEqual %d [%s]",
				aSymbol.apply(container),
				aValue,
				isSatisfiedBy(container));
	}
}

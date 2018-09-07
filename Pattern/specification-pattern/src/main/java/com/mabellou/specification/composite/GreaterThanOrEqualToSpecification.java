package com.mabellou.specification.composite;

import com.mabellou.specification.Container;

import java.util.function.Function;

public class GreaterThanOrEqualToSpecification extends ValueBoundSpecification {


	private GreaterThanOrEqualToSpecification(Integer aValue, Function<Container, Integer> aSymbol) {
		super(aValue, aSymbol);
	}

	public static GreaterThanOrEqualToSpecification of(Integer aValue, Function<Container, Integer> aSymbol){
		return new GreaterThanOrEqualToSpecification(aValue, aSymbol);
	}

	@Override
	public boolean isSatisfiedBy(Container container) {
		return aSymbol.apply(container) >= aValue;
	}

	@Override
	public boolean isGeneralizationOf(Specification specification) {
		if(!(specification instanceof GreaterThanOrEqualToSpecification)){
			throw new IllegalArgumentException("It must be a GreaterThanOrEqualToSpecification specification");
		}
		return aValue <= ((GreaterThanOrEqualToSpecification) specification).aValue;
	}

	@Override
	public boolean isSpecialCaseOf(Specification specification) {
		if(!(specification instanceof GreaterThanOrEqualToSpecification)){
			throw new IllegalArgumentException("It must be a GreaterThanOrEqualToSpecification specification");
		}
		return aValue >= ((GreaterThanOrEqualToSpecification) specification).aValue;
	}

	@Override
	public String toString(Container container) {
		return String.format(" %d >= %d [%s] ",
				aSymbol.apply(container),
				aValue,
				isSatisfiedBy(container));
	}
}

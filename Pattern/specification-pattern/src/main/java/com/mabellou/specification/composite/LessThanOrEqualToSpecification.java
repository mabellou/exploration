package com.mabellou.specification.composite;

import com.mabellou.specification.Container;

import java.util.function.Function;

public class LessThanOrEqualToSpecification extends ValueBoundSpecification {

	private LessThanOrEqualToSpecification(Integer aValue, Function<Container, Integer> aSymbol) {
		super(aValue, aSymbol);
	}

	public static LessThanOrEqualToSpecification of(Integer aValue, Function<Container, Integer> aSymbol){
		return new LessThanOrEqualToSpecification(aValue, aSymbol);
	}

	@Override
	public boolean isSatisfiedBy(Container container) {
		return aSymbol.apply(container) <= aValue;
	}

	@Override
	public boolean isGeneralizationOf(Specification specification) {
		if(!(specification instanceof LessThanOrEqualToSpecification)){
			throw new IllegalArgumentException("It must be a LessThanOrEqualToSpecification specification");
		}
		return aValue >= ((LessThanOrEqualToSpecification) specification).aValue;
	}

	@Override
	public boolean isSpecialCaseOf(Specification specification) {
		if(!(specification instanceof LessThanOrEqualToSpecification)){
			throw new IllegalArgumentException("It must be a LessThanOrEqualToSpecification specification");
		}
		return aValue <= ((LessThanOrEqualToSpecification) specification).aValue;
	}

	@Override
	public String toString(Container container) {
		return String.format(" %d <= %d [%s] ",
				aSymbol.apply(container),
				aValue,
				isSatisfiedBy(container));
	}
}

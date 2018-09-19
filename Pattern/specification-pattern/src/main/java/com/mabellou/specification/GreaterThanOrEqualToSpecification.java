package com.mabellou.specification;

import java.util.function.Function;

public class GreaterThanOrEqualToSpecification<T> extends ValueBoundSpecification<T> {


	public GreaterThanOrEqualToSpecification(Integer aValue, Function<T, Integer> aSymbol) {
		super(aValue, aSymbol);
	}

	public static <T> GreaterThanOrEqualToSpecification<T> of(Integer aValue, Function<T, Integer> aSymbol){
		return new GreaterThanOrEqualToSpecification<>(aValue, aSymbol);
	}

	@Override
	public boolean isSatisfiedBy(T t) {
		return aSymbol.apply(t) >= aValue;
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
	public String toString(T t) {
		return String.format(" %d >= %d [%s] ",
				aSymbol.apply(t),
				aValue,
				isSatisfiedBy(t));
	}
}

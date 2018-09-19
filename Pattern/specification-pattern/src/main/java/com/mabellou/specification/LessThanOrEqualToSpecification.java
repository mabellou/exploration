package com.mabellou.specification;

import java.util.function.Function;

public class LessThanOrEqualToSpecification<T> extends ValueBoundSpecification<T> {

	private LessThanOrEqualToSpecification(Integer aValue, Function<T, Integer> aSymbol) {
		super(aValue, aSymbol);
	}

	public static <T> LessThanOrEqualToSpecification<T> of(Integer aValue, Function<T, Integer> aSymbol){
		return new LessThanOrEqualToSpecification<>(aValue, aSymbol);
	}

	@Override
	public boolean isSatisfiedBy(T t) {
		return aSymbol.apply(t) <= aValue;
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
	public String toString(T t) {
		return String.format(" %d <= %d [%s] ",
				aSymbol.apply(t),
				aValue,
				isSatisfiedBy(t));
	}
}

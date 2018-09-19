package com.mabellou.specification;

import java.util.function.Function;

public class EqualSpecification<T> extends ValueBoundSpecification<T> {

	private EqualSpecification(Integer aValue, Function<T, Integer> aSymbol) {
		super(aValue, aSymbol);
	}

	public static <T> EqualSpecification<T> of(Integer aValue, Function<T, Integer> aSymbol){
		return new EqualSpecification<>(aValue, aSymbol);
	}

	@Override
	public boolean isSatisfiedBy(T t) {
		return aSymbol.apply(t).intValue() == aValue.intValue();
	}

	@Override
	public String toString(T t) {
		return String.format(" %d == %d [=%s] ",
				aSymbol.apply(t),
				aValue,
				isSatisfiedBy(t));
	}
}

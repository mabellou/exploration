package com.mabellou.specification;

import java.util.function.Function;

public abstract class ValueBoundSpecification<T> extends LeafSpecification<T> {
	protected Integer aValue;
	protected Function<T, Integer> aSymbol;


	protected ValueBoundSpecification(Integer aValue, Function<T,Integer> aSymbol) {
		this.aValue = aValue;
		this.aSymbol = aSymbol;
	}
}

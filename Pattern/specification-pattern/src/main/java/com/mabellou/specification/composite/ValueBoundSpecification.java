package com.mabellou.specification.composite;

import com.mabellou.specification.Container;

import java.util.function.Function;

public abstract class ValueBoundSpecification implements LeafSpecification {
	protected Integer aValue;
	protected Function<Container, Integer> aSymbol;


	public ValueBoundSpecification(Integer aValue, Function<Container,Integer> aSymbol) {
		this.aValue = aValue;
		this.aSymbol = aSymbol;
	}
}

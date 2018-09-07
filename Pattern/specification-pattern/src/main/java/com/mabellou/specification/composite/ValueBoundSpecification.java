package com.mabellou.specification.composite;

import com.mabellou.specification.Container;

import java.util.function.Function;

public abstract class ValueBoundSpecification extends LeafSpecification {
	protected Integer aValue;
	protected Function<Container, Integer> aSymbol;


	protected ValueBoundSpecification(Integer aValue, Function<Container,Integer> aSymbol) {
		this.aValue = aValue;
		this.aSymbol = aSymbol;
	}
}

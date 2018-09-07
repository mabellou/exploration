package com.mabellou.specification.composite;

import com.mabellou.specification.Container;

import java.util.function.Predicate;

public class SpecificationFromPredicate extends LeafSpecification {
	private Predicate<Container> predicate;

	private SpecificationFromPredicate(Predicate<Container> predicate, String name) {
		this.predicate = predicate;
		this.name = name;
	}

	public static SpecificationFromPredicate of(Predicate<Container> predicate, String name){
		return new SpecificationFromPredicate(predicate, name);
	}

	@Override
	public boolean isSatisfiedBy(Container container) {
		return predicate.test(container);
	}

	@Override
	public String toString(Container container) {
		return name + " is " + isSatisfiedBy(container);
	}
}

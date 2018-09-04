package com.mabellou.specification.composite;

import com.mabellou.specification.Container;

import java.util.function.Predicate;

public class SpecificationFromPredicate implements LeafSpecification {
	private Predicate<Container> predicate;
	private String name;

	public SpecificationFromPredicate(Predicate<Container> predicate, String name) {
		this.predicate = predicate;
		this.name = name;
	}

	@Override
	public boolean isSatisfiedBy(Container container) {
		return predicate.test(container);
	}

	@Override
	public String write(Container container) {
		return name + " is " + isSatisfiedBy(container);
	}
}

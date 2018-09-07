package com.mabellou.specification.composite;

import com.mabellou.specification.Container;

import java.util.function.Predicate;

public class SpecificationFromPredicate extends LeafSpecification {
	private Predicate<Container> predicate;

	private SpecificationFromPredicate(Predicate<Container> predicate) {
		this.predicate = predicate;
	}

	public static SpecificationFromPredicate of(Predicate<Container> predicate){
		return new SpecificationFromPredicate(predicate);
	}

	@Override
	protected boolean isSatisfiedBy(Container container) {
		return predicate.test(container);
	}

	@Override
	public String toString(Container container) {
		return name + " is " + isSatisfiedBy(container);
	}
}

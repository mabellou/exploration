package com.mabellou.specification;

import java.util.function.Predicate;

public class SpecificationFromPredicate<T> extends LeafSpecification<T> {
	private Predicate<T> predicate;

	private SpecificationFromPredicate(Predicate<T> predicate, String name) {
		this.predicate = predicate;
		this.name = name;
	}

	public static <T>  SpecificationFromPredicate<T> of(Predicate<T> predicate, String name){
		return new SpecificationFromPredicate<>(predicate, name);
	}

	@Override
	public boolean isSatisfiedBy(T t) {
		return predicate.test(t);
	}

	@Override
	public String toString(T t) {
		return name + " is " + isSatisfiedBy(t);
	}
}

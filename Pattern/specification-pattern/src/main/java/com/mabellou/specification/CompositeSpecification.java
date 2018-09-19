package com.mabellou.specification;

import java.util.*;

public abstract class CompositeSpecification<T> implements Specification<T> {
	protected List<Specification<T>> specifications;
	protected String name = "";

	protected CompositeSpecification(List<Specification<T>> specifications) {
		this.specifications = specifications;
	}

	@Override
	public Set<Specification<T>> getUnsatisfiedSpecificationsFor(final T t) {
		Set<Specification<T>> unsatisfied = new HashSet<>();
		for (Specification<T> specification : specifications) {
			unsatisfied.addAll(specification.getUnsatisfiedSpecificationsFor(t));
		}
		return Collections.unmodifiableSet(unsatisfied);
	}

	@Override
	public Set<Specification<T>> getSatisfiedSpecificationsFor(final T t) {
		Set<Specification<T>> satisfied = new HashSet<>();
		for (Specification<T> specification : specifications) {
			satisfied.addAll(specification.getSatisfiedSpecificationsFor(t));
		}
		return Collections.unmodifiableSet(satisfied);
	}

	@Override
	public Specification<T> withName(String name) {
		this.name = name;
		return this;
	}

	@Override
	public String getName() {
		return name;
	}
}

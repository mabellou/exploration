package com.mabellou.specification.composite;

import com.mabellou.specification.Container;

import java.util.*;

public abstract class CompositeSpecification implements Specification {
	protected List<Specification> specifications;

	public CompositeSpecification(Specification... specifications) {
		this.specifications = Arrays.asList(specifications);
	}

	public CompositeSpecification(List<Specification> specifications) {
		this.specifications = specifications;
	}

	public void addSpecification(Specification specification) {
		this.specifications.add(specification);
	}

	public void addSpecifications(List<Specification> specifications) {
		this.specifications.addAll(specifications);
	}

	public Set<Specification> getUnsatisfiedSpecificationsFor(final Container container) {
		Set<Specification> unsatisfied = new HashSet<>();
		for (Specification specification : specifications) {
			unsatisfied.addAll(specification.getUnsatisfiedSpecificationsFor(container));
		}
		return Collections.unmodifiableSet(unsatisfied);
	}

	public Set<Specification> getSatisfiedSpecificationsFor(final Container container) {
		Set<Specification> satisfied = new HashSet<>();
		for (Specification specification : specifications) {
			satisfied.addAll(specification.getSatisfiedSpecificationsFor(container));
		}
		return Collections.unmodifiableSet(satisfied);
	}
}

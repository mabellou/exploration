package com.mabellou.specification.composite;

import com.mabellou.specification.Container;

import java.util.*;

public abstract class CompositeSpecification implements Specification {
	protected List<Specification> specifications;
	protected String name = "";

	protected CompositeSpecification(Specification... specifications) {
		this.specifications = Arrays.asList(specifications);
	}

	@Override
	public Set<Specification> getUnsatisfiedSpecificationsFor(final Container container) {
		Set<Specification> unsatisfied = new HashSet<>();
		for (Specification specification : specifications) {
			unsatisfied.addAll(specification.getUnsatisfiedSpecificationsFor(container));
		}
		return Collections.unmodifiableSet(unsatisfied);
	}

	@Override
	public Set<Specification> getSatisfiedSpecificationsFor(final Container container) {
		Set<Specification> satisfied = new HashSet<>();
		for (Specification specification : specifications) {
			satisfied.addAll(specification.getSatisfiedSpecificationsFor(container));
		}
		return Collections.unmodifiableSet(satisfied);
	}

	@Override
	public Specification withName(String name) {
		this.name = name;
		return this;
	}

	@Override
	public String getName() {
		return name;
	}
}

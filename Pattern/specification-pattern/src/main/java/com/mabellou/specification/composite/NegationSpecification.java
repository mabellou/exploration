package com.mabellou.specification.composite;

import com.mabellou.specification.Container;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class NegationSpecification implements Specification {

	private Specification specificationToNegate;

	public NegationSpecification(Specification specificationToNegate) {
		this.specificationToNegate = specificationToNegate;
	}

	public Set<Specification> getUnsatisfiedSpecificationsFor(final Container container) {
		Set<Specification> unsatisfied = new HashSet<>();
		unsatisfied.addAll(specificationToNegate.getSatisfiedSpecificationsFor(container));
		return Collections.unmodifiableSet(unsatisfied);
	}

	public Set<Specification> getSatisfiedSpecificationsFor(final Container container) {
		Set<Specification> unsatisfied = new HashSet<>();
		unsatisfied.addAll(specificationToNegate.getUnsatisfiedSpecificationsFor(container));
		return Collections.unmodifiableSet(unsatisfied);
	}

	@Override
	public boolean isSatisfiedBy(Container container) {
		return !specificationToNegate.isSatisfiedBy(container);
	}

	@Override
	public boolean test(Container container) {
		System.out.println(this.write(container));
		return !specificationToNegate.test(container);
	}

	@Override
	public String write(Container container) {
		return String.format("Negation of %s [%s]",
				specificationToNegate.isSatisfiedBy(container),
				isSatisfiedBy(container));
	}
}

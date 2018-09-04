package com.mabellou.specification.composite;

import com.mabellou.specification.Container;

import java.util.HashSet;
import java.util.Set;

public interface LeafSpecification extends Specification {

	default Set<Specification> getUnsatisfiedSpecificationsFor(final Container container) {
		Set<Specification> unsatisfied = new HashSet<>();
		if (!this.isSatisfiedBy(container)) {
			unsatisfied.add(this);
		}
		return unsatisfied;
	}

	default Set<Specification> getSatisfiedSpecificationsFor(final Container container) {
		Set<Specification> satisfied = new HashSet<>();
		if (this.isSatisfiedBy(container)) {
			satisfied.add(this);
		}
		return satisfied;
	}

	default boolean test(Container container){
		System.out.println(this.write(container));
		return this.isSatisfiedBy(container);
	}
}

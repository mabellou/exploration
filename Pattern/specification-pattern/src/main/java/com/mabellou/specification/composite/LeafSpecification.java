package com.mabellou.specification.composite;

import com.mabellou.specification.Container;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.HashSet;
import java.util.Set;

public abstract class LeafSpecification implements Specification {
	protected String name = "";

	@Override
	public final boolean test(Container container){
		System.out.println(this.toString(container));
		return this.isSatisfiedBy(container);
	}

	public abstract boolean isSatisfiedBy(Container container);

	@Override
	public Set<Specification> getUnsatisfiedSpecificationsFor(final Container container) {
		Set<Specification> unsatisfied = new HashSet<>();
		if (!this.test(container)) {
			unsatisfied.add(this);
		}
		return unsatisfied;
	}

	@Override
	public Set<Specification> getSatisfiedSpecificationsFor(final Container container) {
		Set<Specification> satisfied = new HashSet<>();
		if (this.test(container)) {
			satisfied.add(this);
		}
		return satisfied;
	}

	@Override
	public Specification withName(String name){
		this.name = name;
		return this;
	}

	@Override
	public String getName() {
		return name;
	}

	public abstract String toString(Container container);

	@Override
	public String toString(Container container, StringFormatter formatter) {
		switch (formatter){
			case INLINE: return this.toString(container);
			case MULTIPLE_LINE: return this.toString(container) + System.lineSeparator();
			default: throw new NotImplementedException();
		}
	}
}

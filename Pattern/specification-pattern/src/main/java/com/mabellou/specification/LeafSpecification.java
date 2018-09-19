package com.mabellou.specification;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.HashSet;
import java.util.Set;

public abstract class LeafSpecification<T> implements Specification<T> {
	protected String name = "";

	@Override
	public final boolean test(T t){
		System.out.println(this.toString(t));
		return this.isSatisfiedBy(t);
	}

	public abstract boolean isSatisfiedBy(T t);

	@Override
	public Set<Specification<T>> getUnsatisfiedSpecificationsFor(final T t) {
		Set<Specification<T>> unsatisfied = new HashSet<>();
		if (!this.test(t)) {
			unsatisfied.add(this);
		}
		return unsatisfied;
	}

	@Override
	public Set<Specification<T>> getSatisfiedSpecificationsFor(final T t) {
		Set<Specification<T>> satisfied = new HashSet<>();
		if (this.test(t)) {
			satisfied.add(this);
		}
		return satisfied;
	}

	@Override
	public Specification<T> withName(String name){
		this.name = name;
		return this;
	}

	@Override
	public String getName() {
		return name;
	}

	public abstract String toString(T t);

	@Override
	public String toString(T t, StringFormatter formatter) {
		switch (formatter){
			case INLINE: return this.toString(t);
			case MULTIPLE_LINE: return this.toString(t) + System.lineSeparator();
			default: throw new NotImplementedException();
		}
	}
}

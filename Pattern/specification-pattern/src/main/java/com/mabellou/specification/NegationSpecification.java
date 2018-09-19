package com.mabellou.specification;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class NegationSpecification<T> implements Specification<T> {

	private Specification<T> specificationToNegate;
	private String name = "";

	private NegationSpecification(Specification<T> specificationToNegate) {
		this.specificationToNegate = specificationToNegate;
	}

	public static <T> NegationSpecification<T> of(Specification<T> specificationToNegate){
		return new NegationSpecification<>(specificationToNegate);
	}

	@Override
	public boolean test(T t) {
		System.out.println(this.toString(t));
		return !specificationToNegate.test(t);
	}

	public boolean isSatisfiedBy(T t) {
		return !specificationToNegate.isSatisfiedBy(t);
	}

	@Override
	public Set<Specification<T>> getUnsatisfiedSpecificationsFor(final T t) {
		Set<Specification<T>> unsatisfied = new HashSet<>();
		unsatisfied.addAll(specificationToNegate.getSatisfiedSpecificationsFor(t));
		return Collections.unmodifiableSet(unsatisfied);
	}

	@Override
	public Set<Specification<T>> getSatisfiedSpecificationsFor(final T t) {
		Set<Specification<T>> unsatisfied = new HashSet<>();
		unsatisfied.addAll(specificationToNegate.getUnsatisfiedSpecificationsFor(t));
		return Collections.unmodifiableSet(unsatisfied);
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

	@Override
	public String toString(T t, StringFormatter formatter) {
		switch (formatter) {
			case INLINE:
				return "!(" + specificationToNegate.toString(t, StringFormatter.INLINE) + ")";
			case MULTIPLE_LINE:
				return this.toString(t) + System.lineSeparator() + specificationToNegate.toString(t, StringFormatter.MULTIPLE_LINE);
			default:
				throw new NotImplementedException();
		}
	}

	private String toString(T t) {
		String nameToDisplay = name.equals("") ? name : (name + " : ");
		return String.format("%sNegation of %s [=%s]",
				nameToDisplay,
				specificationToNegate.isSatisfiedBy(t),
				isSatisfiedBy(t));
	}
}

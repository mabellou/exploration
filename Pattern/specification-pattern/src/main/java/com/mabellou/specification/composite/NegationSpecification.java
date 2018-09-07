package com.mabellou.specification.composite;

import com.mabellou.specification.Container;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static com.mabellou.specification.composite.Specification.StringFormatter.INLINE;
import static com.mabellou.specification.composite.Specification.StringFormatter.MULTIPLE_LINE;

public class NegationSpecification implements Specification {

	private Specification specificationToNegate;
	private String name = "";

	private NegationSpecification(Specification specificationToNegate) {
		this.specificationToNegate = specificationToNegate;
	}

	public static NegationSpecification of(Specification specificationToNegate){
		return new NegationSpecification(specificationToNegate);
	}

	@Override
	public boolean test(Container container) {
		System.out.println(this.toString(container));
		return !specificationToNegate.test(container);
	}

	public boolean isSatisfiedBy(Container container) {
		return !specificationToNegate.isSatisfiedBy(container);
	}

	@Override
	public Set<Specification> getUnsatisfiedSpecificationsFor(final Container container) {
		Set<Specification> unsatisfied = new HashSet<>();
		unsatisfied.addAll(specificationToNegate.getSatisfiedSpecificationsFor(container));
		return Collections.unmodifiableSet(unsatisfied);
	}

	@Override
	public Set<Specification> getSatisfiedSpecificationsFor(final Container container) {
		Set<Specification> unsatisfied = new HashSet<>();
		unsatisfied.addAll(specificationToNegate.getUnsatisfiedSpecificationsFor(container));
		return Collections.unmodifiableSet(unsatisfied);
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

	@Override
	public String toString(Container container, StringFormatter formatter) {
		switch (formatter) {
			case INLINE:
				return "!(" + specificationToNegate.toString(container, INLINE) + ")";
			case MULTIPLE_LINE:
				return this.toString(container) + System.lineSeparator() + specificationToNegate.toString(container, MULTIPLE_LINE);
			default:
				throw new NotImplementedException();
		}
	}

	private String toString(Container container) {
		String nameToDisplay = name.equals("") ? name : (name + " : ");
		return String.format("%sNegation of %s [=%s]",
				nameToDisplay,
				specificationToNegate.isSatisfiedBy(container),
				isSatisfiedBy(container));
	}
}

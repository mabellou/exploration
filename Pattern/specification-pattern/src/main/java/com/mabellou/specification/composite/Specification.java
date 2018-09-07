package com.mabellou.specification.composite;

import com.mabellou.specification.Container;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Set;

//TODO generics
public interface Specification {
	boolean test(Container container);
	boolean isSatisfiedBy(Container container);

	default Specification and(Specification andSpecification){
		return ConjunctionSpecification.of(this, andSpecification);
	}
	default Specification or(Specification orSpecification){
		return DisjunctionSpecification.of(this, orSpecification);
	}
	default Specification negate(){
		return NegationSpecification.of(this);
	}

	Set<Specification>  getUnsatisfiedSpecificationsFor(Container container);
	Set<Specification>  getSatisfiedSpecificationsFor(Container container);

	default boolean isSpecialCaseOf(Specification specification) {
		throw new NotImplementedException();
	}
	default boolean isGeneralizationOf(Specification specification) {
		throw new NotImplementedException();
	}

	String getName();
	Specification withName(String name);

	String toString(Container container, StringFormatter formatter);

	enum StringFormatter {
		INLINE, MULTIPLE_LINE
	}
}

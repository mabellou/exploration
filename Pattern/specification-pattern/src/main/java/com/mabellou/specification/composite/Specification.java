package com.mabellou.specification.composite;

import com.mabellou.specification.Container;

import java.util.Set;

public interface Specification {
	boolean isSatisfiedBy(Container container);
	boolean test(Container container);
	Set<Specification>  getUnsatisfiedSpecificationsFor(Container container);
	Set<Specification>  getSatisfiedSpecificationsFor(Container container);
	String write(Container container);

	default Specification and(Specification andSpecification){
		return new ConjunctionSpecification(this, andSpecification);
	}

	default Specification or(Specification orSpecification){
		return new DisjunctionSpecification(this, orSpecification);
	}

	default Specification negate(){
		return new NegationSpecification(this);
	}
}

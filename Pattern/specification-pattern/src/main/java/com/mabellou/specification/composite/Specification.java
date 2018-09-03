package com.mabellou.specification.composite;

import com.mabellou.specification.Container;

public interface Specification {
	boolean isSatisfiedBy(Container container);

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

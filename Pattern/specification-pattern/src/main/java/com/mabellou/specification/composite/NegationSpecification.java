package com.mabellou.specification.composite;

import com.mabellou.specification.Container;

public class NegationSpecification implements Specification {

	private Specification specificationToNegate;

	public NegationSpecification(Specification specificationToNegate) {
		this.specificationToNegate = specificationToNegate;
	}

	@Override
	public boolean isSatisfiedBy(Container container) {
		return !specificationToNegate.isSatisfiedBy(container);
	}
}

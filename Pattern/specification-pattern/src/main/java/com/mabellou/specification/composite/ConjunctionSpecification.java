package com.mabellou.specification.composite;

import com.mabellou.specification.Container;

import java.util.List;

public class ConjunctionSpecification extends CompositeSpecification  {

	public ConjunctionSpecification(List<Specification> specifications) {
		super(specifications);
	}

	public ConjunctionSpecification(Specification... specification) {
		super(specification);
	}

	@Override
	public boolean isSatisfiedBy(Container container) {
		return specifications.stream()
				.allMatch(s -> s.isSatisfiedBy(container));
	}
}

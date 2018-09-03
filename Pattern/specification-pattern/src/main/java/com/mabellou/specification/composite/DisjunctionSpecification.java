package com.mabellou.specification.composite;

import com.mabellou.specification.Container;

import java.util.List;

public class DisjunctionSpecification extends CompositeSpecification {

	public DisjunctionSpecification(List<Specification> specifications) {
		super(specifications);
	}

	public DisjunctionSpecification(Specification... specification) {
		super(specification);
	}

	@Override
	public boolean isSatisfiedBy(Container container) {
		return specifications.stream()
				.anyMatch(s -> s.isSatisfiedBy(container));
	}
}

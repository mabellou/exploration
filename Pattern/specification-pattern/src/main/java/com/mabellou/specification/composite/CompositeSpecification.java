package com.mabellou.specification.composite;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public abstract class CompositeSpecification implements Specification {
	protected List<Specification> specifications;

	public CompositeSpecification(Specification... specifications) {
		this.specifications = Arrays.asList(specifications);
	}

	public CompositeSpecification(List<Specification> specifications) {
		this.specifications = specifications;
	}

	public void addSpecification(Specification specification) {
		this.specifications.add(specification);
	}

	public void addSpecifications(List<Specification> specifications) {
		this.specifications.addAll(specifications);
	}
}

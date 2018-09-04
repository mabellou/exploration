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

	@Override
	public boolean test(Container container) {
		boolean orResult = false;
		boolean tempResult;
		boolean first = true;
		System.out.println("Begin or");
		for(Specification specification: specifications){
			if(!first){
				System.out.println("Or");
			}
			first = false;
			tempResult = specification.test(container);
			orResult = orResult || tempResult;
		}
		System.out.println("End or");
		return orResult;
	}

	@Override
	public String write(Container container) {
		return "Or";
	}
}

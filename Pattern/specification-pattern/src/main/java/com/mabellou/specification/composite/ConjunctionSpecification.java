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

	@Override
	public boolean test(Container container) {
		boolean andResult = true;
		boolean tempResult;
		boolean first = true;
		System.out.println("Begin and");
		for(Specification specification: specifications){
			if(!first){
				System.out.println("And");
			}
			first = false;
			tempResult = specification.test(container);
			andResult = andResult && tempResult;
		}
		System.out.println("End and");
		return andResult;
	}

	@Override
	public String write(Container container) {
		return "And";
	}
}

package com.mabellou.specification.composite;

import com.mabellou.specification.Container;

import java.util.List;

public class DisjunctionSpecification extends CompositeSpecification {

	private DisjunctionSpecification(Specification... specifications) {
		super(specifications);
	}

	public static DisjunctionSpecification of(Specification... specifications){
		return new DisjunctionSpecification(specifications);
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
	public boolean isSpecialCaseOf(Specification specification) {
		return specifications.stream().allMatch(s -> s.isSpecialCaseOf(specification));
	}

	@Override
	public boolean isGeneralizationOf(Specification specification) {
		return specifications.stream().anyMatch(s -> s.isGeneralizationOf(specification));
	}

	@Override
	public String getText(Container container) {
		StringBuilder text = new StringBuilder();
		boolean first = true;
		for(Specification specification: specifications){
			if(!first){
				text.append(" || ");
			}
			first = false;
			text.append("(");
			text.append(specification.getText(container));
			text.append(")");
		}
		return text.toString();
	}

	@Override
	public String write(Container container) {
		return "Or";
	}
}

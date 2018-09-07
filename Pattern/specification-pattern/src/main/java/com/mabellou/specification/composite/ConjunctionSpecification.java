package com.mabellou.specification.composite;

import com.mabellou.specification.Container;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;

public class ConjunctionSpecification extends CompositeSpecification  {

	private ConjunctionSpecification(Specification... specifications) {
		super(specifications);
	}

	public static ConjunctionSpecification of(Specification... specifications){
		return new ConjunctionSpecification(specifications);
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
	public boolean isSpecialCaseOf(Specification specification) {
		return specifications.stream().anyMatch(s -> s.isSpecialCaseOf(specification));
	}

	@Override
	public boolean isGeneralizationOf(Specification specification) {
		return specifications.stream().allMatch(s -> s.isGeneralizationOf(specification));
	}

	@Override
	public String toString(Container container, StringFormatter formatter) {
		StringBuilder text = new StringBuilder();
		boolean first = true;
		for(Specification specification: specifications){
			if(!first){
				text.append(" && ");
			}
			first = false;
			text.append("(");
			text.append(specification.getText(container));
			text.append(")");
		}
		return text.toString();
	}
}

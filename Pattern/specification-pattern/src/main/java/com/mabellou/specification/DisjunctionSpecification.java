package com.mabellou.specification;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;

public class DisjunctionSpecification<T> extends CompositeSpecification<T> {

	public DisjunctionSpecification(List<Specification<T>> specifications) {
		super(specifications);
	}

	@Override
	public boolean isSatisfiedBy(T t) {
		return specifications.stream().anyMatch(s -> s.isSatisfiedBy(t));
	}

	@Override
	public boolean test(T t) {
		boolean orResult = false;
		boolean tempResult;
		boolean first = true;
		System.out.println("Begin or");
		for(Specification<T> specification: specifications){
			if(!first){
				System.out.println("Or");
			}
			first = false;
			tempResult = specification.test(t);
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
	public String toString(T t, StringFormatter formatter) {
		switch (formatter) {
			case INLINE:
				return toStringInline(t);
			case MULTIPLE_LINE:
				return toStringMultipleLine(t);
			default:
				throw new NotImplementedException();
		}
	}

	private String toStringInline(T t) {
		StringBuilder text = new StringBuilder();
		boolean first = true;
		for(Specification<T> specification: specifications){
			if(!first){
				text.append(" || ");
			}
			first = false;
			text.append("(");
			text.append(specification.toString(t, StringFormatter.INLINE));
			text.append(")");
		}
		return text.toString();
	}

	private String toStringMultipleLine(T t) {
		StringBuilder text = new StringBuilder();
		boolean orResult = false;
		boolean tempResult;
		boolean first = true;
		text.append("Begin or").append(name).append(System.lineSeparator());
		for(Specification<T> specification: specifications){
			if(!first){
				text.append("Or").append(System.lineSeparator());
			}
			first = false;
			tempResult = specification.isSatisfiedBy(t);
			text.append(specification.toString(t, StringFormatter.MULTIPLE_LINE));
			orResult = orResult || tempResult;
		}
		text.append(String.format("End or [=%s]", orResult)).append(System.lineSeparator());
		return text.toString();
	}
}

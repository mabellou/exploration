package com.mabellou.specification;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;

public class ConjunctionSpecification<T> extends CompositeSpecification<T>  {

	public ConjunctionSpecification(List<Specification<T>> specifications) {
		super(specifications);
	}

	@Override
	public boolean isSatisfiedBy(T t) {
		return specifications.stream().allMatch(s -> s.isSatisfiedBy(t));
	}

	@Override
	public boolean test(T t) {
		boolean andResult = true;
		boolean tempResult;
		boolean first = true;
		System.out.println("Begin and " + name);
		for(Specification<T> specification: specifications){
			if(!first){
				System.out.println("And");
			}
			first = false;
			tempResult = specification.test(t);
			andResult = andResult && tempResult;
		}
		System.out.println("End and");
		return andResult;
	}

	@Override
	public boolean isSpecialCaseOf(Specification<T> specification) {
		return specifications.stream().anyMatch(s -> s.isSpecialCaseOf(specification));
	}

	@Override
	public boolean isGeneralizationOf(Specification<T> specification) {
		return specifications.stream().allMatch(s -> s.isGeneralizationOf(specification));
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
				text.append(" && ");
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
		boolean andResult = true;
		boolean tempResult;
		boolean first = true;
		text.append("Begin and ").append(name).append(System.lineSeparator());
		for(Specification<T> specification: specifications){
			if(!first){
				text.append("And").append(System.lineSeparator());
			}
			first = false;
			tempResult = specification.isSatisfiedBy(t);
			text.append(specification.toString(t, StringFormatter.MULTIPLE_LINE));
			andResult = andResult && tempResult;
		}
		text.append(String.format("End and [=%s]", andResult)).append(System.lineSeparator());
		return text.toString();
	}
}

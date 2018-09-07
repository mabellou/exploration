package com.mabellou.specification.composite;

import com.mabellou.specification.Container;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import static com.mabellou.specification.composite.Specification.StringFormatter.INLINE;
import static com.mabellou.specification.composite.Specification.StringFormatter.MULTIPLE_LINE;

public class ConjunctionSpecification extends CompositeSpecification  {

	private ConjunctionSpecification(Specification... specifications) {
		super(specifications);
	}

	public static ConjunctionSpecification of(Specification... specifications){
		return new ConjunctionSpecification(specifications);
	}

	@Override
	public boolean isSatisfiedBy(Container container) {
		return specifications.stream().allMatch(s -> s.isSatisfiedBy(container));
	}

	@Override
	public boolean test(Container container) {
		boolean andResult = true;
		boolean tempResult;
		boolean first = true;
		System.out.println("Begin and " + name);
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
		switch (formatter) {
			case INLINE:
				return toStringInline(container);
			case MULTIPLE_LINE:
				return toStringMultipleLine(container);
			default:
				throw new NotImplementedException();
		}
	}

	private String toStringInline(Container container) {
		StringBuilder text = new StringBuilder();
		boolean first = true;
		for(Specification specification: specifications){
			if(!first){
				text.append(" && ");
			}
			first = false;
			text.append("(");
			text.append(specification.toString(container, INLINE));
			text.append(")");
		}
		return text.toString();
	}

	private String toStringMultipleLine(Container container) {
		StringBuilder text = new StringBuilder();
		boolean andResult = true;
		boolean tempResult;
		boolean first = true;
		text.append("Begin and ").append(name).append(System.lineSeparator());
		for(Specification specification: specifications){
			if(!first){
				text.append("And").append(System.lineSeparator());
			}
			first = false;
			tempResult = specification.isSatisfiedBy(container);
			text.append(specification.toString(container, MULTIPLE_LINE));
			andResult = andResult && tempResult;
		}
		text.append(String.format("End and [=%s]", andResult)).append(System.lineSeparator());
		return text.toString();
	}
}

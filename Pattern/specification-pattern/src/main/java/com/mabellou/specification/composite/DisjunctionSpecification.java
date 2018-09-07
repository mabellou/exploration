package com.mabellou.specification.composite;

import com.mabellou.specification.Container;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;

import static com.mabellou.specification.composite.Specification.StringFormatter.INLINE;
import static com.mabellou.specification.composite.Specification.StringFormatter.MULTIPLE_LINE;

public class DisjunctionSpecification extends CompositeSpecification {

	private DisjunctionSpecification(Specification... specifications) {
		super(specifications);
	}

	public static DisjunctionSpecification of(Specification... specifications){
		return new DisjunctionSpecification(specifications);
	}

	@Override
	public boolean isSatisfiedBy(Container container) {
		return specifications.stream().anyMatch(s -> s.isSatisfiedBy(container));
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
				text.append(" || ");
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
		boolean orResult = false;
		boolean tempResult;
		boolean first = true;
		text.append("Begin or").append(name).append(System.lineSeparator());
		for(Specification specification: specifications){
			if(!first){
				text.append("Or").append(System.lineSeparator());
			}
			first = false;
			tempResult = specification.isSatisfiedBy(container);
			text.append(specification.toString(container, MULTIPLE_LINE));
			orResult = orResult || tempResult;
		}
		text.append(String.format("End or [=%s]", orResult)).append(System.lineSeparator());
		return text.toString();
	}
}

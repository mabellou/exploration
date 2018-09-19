package com.mabellou.specification;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Arrays;
import java.util.Set;

//TODO generics
public interface Specification<T> {
	boolean test(T t);
	boolean isSatisfiedBy(T t);

	default Specification<T> and(Specification<T> andSpecification){
		return new ConjunctionSpecification<>(Arrays.asList(this, andSpecification));
	}
	default Specification<T> or(Specification<T> orSpecification){
		return new DisjunctionSpecification<>(Arrays.asList(this, orSpecification));
	}
	default Specification<T> negate(){
		return NegationSpecification.of(this);
	}

	Set<Specification<T>>  getUnsatisfiedSpecificationsFor(T t);
	Set<Specification<T>>  getSatisfiedSpecificationsFor(T t);

	default boolean isSpecialCaseOf(Specification<T> specification) {
		throw new NotImplementedException();
	}
	default boolean isGeneralizationOf(Specification<T> specification) {
		throw new NotImplementedException();
	}

	String getName();
	Specification<T> withName(String name);

	String toString(T t, StringFormatter formatter);

	enum StringFormatter {
		INLINE, MULTIPLE_LINE
	}
}

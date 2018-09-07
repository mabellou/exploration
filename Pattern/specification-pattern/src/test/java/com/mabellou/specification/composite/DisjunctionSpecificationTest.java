package com.mabellou.specification.composite;

import org.junit.Test;

import java.util.Arrays;

import static com.mabellou.specification.composite.SampleDataTestCase.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DisjunctionSpecificationTest {


	@Test
	public void disjunctionSpecification_True_True(){
		Specification disjunctionSpecification =
				DisjunctionSpecification.of(IS_TRUE_1, IS_TRUE_2);

		boolean result = disjunctionSpecification.isSatisfiedBy(FOOD_CONTAINER);

		assertTrue(result);
	}

	@Test
	public void disjunctionSpecification_True_False(){
		Specification disjunctionSpecification =
				DisjunctionSpecification.of(IS_TRUE_1, IS_FALSE_1);

		boolean result = disjunctionSpecification.isSatisfiedBy(FOOD_CONTAINER);

		assertTrue(result);
	}

	@Test
	public void disjunctionSpecification_False_False(){
		Specification disjunctionSpecification =
				DisjunctionSpecification.of(IS_FALSE_1, IS_FALSE_2);

		boolean result = disjunctionSpecification.isSatisfiedBy(FOOD_CONTAINER);

		assertFalse(result);
	}

}
package com.mabellou.specification.composite;

import org.junit.Test;

import java.util.Arrays;

import static com.mabellou.specification.composite.SampleDataTestCase.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ConjunctionSpecificationTest {



	@Test
	public void conjunctionSpecification_True_True(){
		Specification conjunctionSpecification =
				ConjunctionSpecification.of(IS_TRUE_1, IS_TRUE_2);

		boolean result = conjunctionSpecification.isSatisfiedBy(FOOD_CONTAINER);

		assertTrue(result);
	}

	@Test
	public void conjunctionSpecification_True_False(){

		Specification conjunctionSpecification =
				ConjunctionSpecification.of(IS_TRUE_1, IS_FALSE_1);

		boolean result = conjunctionSpecification.isSatisfiedBy(FOOD_CONTAINER);

		assertFalse(result);
	}

	@Test
	public void conjunctionSpecification_False_False(){
		Specification conjunctionSpecification =
				ConjunctionSpecification.of(IS_FALSE_1, IS_FALSE_2);

		boolean result = conjunctionSpecification.isSatisfiedBy(FOOD_CONTAINER);

		assertFalse(result);
	}

}
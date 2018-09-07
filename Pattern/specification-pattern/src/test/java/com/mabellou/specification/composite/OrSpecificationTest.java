package com.mabellou.specification.composite;

import org.junit.Test;

import static com.mabellou.specification.composite.SampleDataTestCase.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class OrSpecificationTest {



	@Test
	public void orSpecification_True_True(){
		Specification orSpecification = IS_TRUE_1.or(IS_TRUE_2);

		boolean result = orSpecification.isSatisfiedBy(FOOD_CONTAINER);

		assertTrue(result);
	}

	@Test
	public void orSpecification_True_False(){
		Specification orSpecification = IS_TRUE_1.or(IS_FALSE_1);

		boolean result = orSpecification.isSatisfiedBy(FOOD_CONTAINER);

		assertTrue(result);
	}

	@Test
	public void orSpecification_False_False(){
		Specification orSpecification = IS_FALSE_1.or(IS_FALSE_2);

		boolean result = orSpecification.isSatisfiedBy(FOOD_CONTAINER);

		assertFalse(result);
	}
}

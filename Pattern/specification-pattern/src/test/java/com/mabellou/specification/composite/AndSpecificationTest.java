package com.mabellou.specification.composite;

import org.junit.Test;

import static com.mabellou.specification.composite.SampleDataTestCase.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AndSpecificationTest {

	@Test
	public void andSpecification_True_True(){
		Specification andSpecification = IS_TRUE_1.and(IS_TRUE_2);

		boolean result = andSpecification.isSatisfiedBy(FOOD_CONTAINER);

		assertTrue(result);
	}

	@Test
	public void andSpecification_True_False(){
		Specification andSpecification = IS_TRUE_1.and(IS_FALSE_1);

		boolean result = andSpecification.isSatisfiedBy(FOOD_CONTAINER);

		assertFalse(result);
	}

	@Test
	public void andSpecification_False_False(){
		Specification andSpecification = IS_FALSE_1.and(IS_FALSE_2);

		boolean result = andSpecification.isSatisfiedBy(FOOD_CONTAINER);

		assertFalse(result);
	}
}

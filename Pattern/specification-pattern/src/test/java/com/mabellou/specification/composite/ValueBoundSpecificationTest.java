package com.mabellou.specification.composite;

import org.junit.Test;

import static com.mabellou.specification.composite.SampleDataTestCase.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ValueBoundSpecificationTest {



	@Test
	public void equalSpecification_True(){
		boolean result = EQUALS_TRUE.isSatisfiedBy(FOOD_CONTAINER);
		assertTrue(result);
	}

	@Test
	public void equalSpecification_False(){
		boolean result = EQUALS_FALSE.isSatisfiedBy(FOOD_CONTAINER);
		assertFalse(result);
	}

	@Test
	public void greaterThanOrEqualToSpecification_True(){
		boolean result = SampleDataTestCase.GREATER_THAN_19.isSatisfiedBy(FOOD_CONTAINER);
		assertTrue(result);
		result = GREATER_THAN_20.isSatisfiedBy(FOOD_CONTAINER);
		assertTrue(result);
	}

	@Test
	public void greaterThanOrEqualToSpecification_False(){
		boolean result = GREATER_THAN_21.isSatisfiedBy(FOOD_CONTAINER);
		assertFalse(result);
	}

	@Test
	public void lessThanOrEqualToSpecification_True(){
		boolean result = LESS_THAN_21.isSatisfiedBy(FOOD_CONTAINER);
		assertTrue(result);
		result = LESS_THAN_20.isSatisfiedBy(FOOD_CONTAINER);
		assertTrue(result);
	}

	@Test
	public void lessThanOrEqualToSpecification_False(){
		boolean result = LESS_THAN_19.isSatisfiedBy(FOOD_CONTAINER);
		assertFalse(result);
	}
}
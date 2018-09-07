package com.mabellou.specification.composite;

import org.junit.Test;

import static com.mabellou.specification.composite.SampleDataTestCase.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class NegationSpecificationTest {



	@Test
	public void negationSpecification_True(){
		Specification negationSpecification = NegationSpecification.of(IS_FALSE_1);
		boolean result = negationSpecification.isSatisfiedBy(FOOD_CONTAINER);
		assertTrue(result);
	}

	@Test
	public void negationSpecification_False(){
		Specification negationSpecification = NegationSpecification.of(IS_TRUE_1);
		boolean result = negationSpecification.isSatisfiedBy(FOOD_CONTAINER);
		assertFalse(result);
	}

	@Test
	public void negateSpecification_True(){
		Specification negationSpecification = IS_FALSE_1.negate();
		boolean result = negationSpecification.isSatisfiedBy(FOOD_CONTAINER);
		assertTrue(result);
	}

	@Test
	public void negateSpecification_False(){
		Specification negationSpecification = IS_TRUE_1.negate();
		boolean result = negationSpecification.isSatisfiedBy(FOOD_CONTAINER);
		assertFalse(result);
	}
}
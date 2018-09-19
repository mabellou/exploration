package com.mabellou.specification;

import com.mabellou.specification.data.Container;
import org.junit.Test;

import static com.mabellou.specification.data.SampleDataTestCase.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class NegationSpecificationTest {



	@Test
	public void negationSpecification_True(){
	 	Specification<Container> negationSpecification = NegationSpecification.of(IS_FALSE_1);
		boolean result = negationSpecification.isSatisfiedBy(FOOD_CONTAINER);
		assertTrue(result);
	}

	@Test
	public void negationSpecification_False(){
	 	Specification<Container> negationSpecification = NegationSpecification.of(IS_TRUE_1);
		boolean result = negationSpecification.isSatisfiedBy(FOOD_CONTAINER);
		assertFalse(result);
	}

	@Test
	public void negateSpecification_True(){
	 	Specification<Container> negationSpecification = IS_FALSE_1.negate();
		boolean result = negationSpecification.isSatisfiedBy(FOOD_CONTAINER);
		assertTrue(result);
	}

	@Test
	public void negateSpecification_False(){
	 	Specification<Container> negationSpecification = IS_TRUE_1.negate();
		boolean result = negationSpecification.isSatisfiedBy(FOOD_CONTAINER);
		assertFalse(result);
	}
}
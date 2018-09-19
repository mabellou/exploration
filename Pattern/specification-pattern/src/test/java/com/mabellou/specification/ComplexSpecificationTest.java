package com.mabellou.specification;

import com.mabellou.specification.data.Container;
import org.junit.Test;

import static com.mabellou.specification.data.SampleDataTestCase.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ComplexSpecificationTest {

	@Test
	public void and_Or_Negate_Specification_True(){
	 	Specification<Container> andSpecification =        IS_FALSE_1.or(IS_FALSE_2)
										.and(
												IS_TRUE_1.or(IS_TRUE_2)
										).negate();

		boolean result = andSpecification.test(FOOD_CONTAINER);
		assertTrue(result);

	 	Specification<Container> orSpecification =        IS_FALSE_1.and(IS_TRUE_1)
										.or(
												IS_FALSE_2.and(IS_TRUE_2)
										).negate();

		result = orSpecification.isSatisfiedBy(FOOD_CONTAINER);
		assertTrue(result);
	}

	@Test
	public void and_Or_Negate_Specification_False(){
	 	Specification<Container> andSpecification =        IS_FALSE_1.or(IS_TRUE_1)
										.and(
												IS_TRUE_2.or(IS_FALSE_2)
										).negate();

		boolean result = andSpecification.test(FOOD_CONTAINER);
		assertFalse(result);

	 	Specification<Container> orSpecification =        IS_FALSE_1.and(IS_FALSE_2)
										.or(
												IS_TRUE_1.and(IS_TRUE_2)
										).negate();

		result = orSpecification.isSatisfiedBy(FOOD_CONTAINER);
		assertFalse(result);
	}
}

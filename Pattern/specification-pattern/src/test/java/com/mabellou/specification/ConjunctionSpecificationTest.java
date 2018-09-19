package com.mabellou.specification;

import com.mabellou.specification.data.Container;
import org.junit.Test;

import java.util.Arrays;

import static com.mabellou.specification.data.SampleDataTestCase.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ConjunctionSpecificationTest {



	@Test
	public void conjunctionSpecification_True_True(){
	 	Specification<Container> conjunctionSpecification =
				new ConjunctionSpecification<>(Arrays.asList(IS_TRUE_1, IS_TRUE_2));

		boolean result = conjunctionSpecification.isSatisfiedBy(FOOD_CONTAINER);

		assertTrue(result);
	}

	@Test
	public void conjunctionSpecification_True_False(){

	 	Specification<Container> conjunctionSpecification =
				new ConjunctionSpecification<>(Arrays.asList(IS_TRUE_1, IS_FALSE_1));

		boolean result = conjunctionSpecification.isSatisfiedBy(FOOD_CONTAINER);

		assertFalse(result);
	}

	@Test
	public void conjunctionSpecification_False_False(){
	 	Specification<Container> conjunctionSpecification =
				new ConjunctionSpecification<>(Arrays.asList(IS_FALSE_1, IS_FALSE_2));

		boolean result = conjunctionSpecification.isSatisfiedBy(FOOD_CONTAINER);

		assertFalse(result);
	}

}
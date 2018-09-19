package com.mabellou.specification;

import com.mabellou.specification.data.Container;
import com.mabellou.specification.data.SampleDataTestCase;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DisjunctionSpecificationTest {


	@Test
	public void disjunctionSpecification_True_True(){
	 	Specification<Container> disjunctionSpecification =
				new DisjunctionSpecification<>(
						Arrays.asList(SampleDataTestCase.IS_TRUE_1, SampleDataTestCase.IS_TRUE_2));

		boolean result = disjunctionSpecification.isSatisfiedBy(SampleDataTestCase.FOOD_CONTAINER);

		assertTrue(result);
	}

	@Test
	public void disjunctionSpecification_True_False(){
	 	Specification<Container> disjunctionSpecification =
				new DisjunctionSpecification<>(
						Arrays.asList(SampleDataTestCase.IS_TRUE_1, SampleDataTestCase.IS_FALSE_1));

		boolean result = disjunctionSpecification.isSatisfiedBy(SampleDataTestCase.FOOD_CONTAINER);

		assertTrue(result);
	}

	@Test
	public void disjunctionSpecification_False_False(){
	 	Specification<Container> disjunctionSpecification =
				new DisjunctionSpecification<>(
						Arrays.asList(SampleDataTestCase.IS_FALSE_1, SampleDataTestCase.IS_FALSE_2));

		boolean result = disjunctionSpecification.isSatisfiedBy(SampleDataTestCase.FOOD_CONTAINER);

		assertFalse(result);
	}

}
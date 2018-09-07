package com.mabellou.specification.composite;

import org.junit.Test;

import static com.mabellou.specification.composite.SampleDataTestCase.FOOD_CONTAINER;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SpecificationFromPredicateTest {



	@Test
	public void fromPredicateTest_True(){
		Specification fromPredicate =
				SpecificationFromPredicate
						.of(container -> container.getTemperatureMax() == 20, "name");
		assertThat(fromPredicate.isSatisfiedBy(FOOD_CONTAINER), is(true));
		assertThat(fromPredicate.getName(), is("name"));
	}

	@Test
	public void fromPredicateTest_False(){
		Specification fromPredicate =
				SpecificationFromPredicate
						.of(container -> container.getTemperatureMax() == 21, "name");
		assertThat(fromPredicate.isSatisfiedBy(FOOD_CONTAINER), is(false));
		assertThat(fromPredicate.getName(), is("name"));
	}

}
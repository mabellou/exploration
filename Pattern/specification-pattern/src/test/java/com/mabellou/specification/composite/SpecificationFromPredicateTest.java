package com.mabellou.specification.composite;

import org.junit.Test;

import static com.mabellou.specification.composite.SampleDataTestCase.FOOD_CONTAINER;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SpecificationFromPredicateTest {



	@Test
	public void fromPredicateTest_True() throws Exception {
		Specification fromPredicate =
				SpecificationFromPredicate
						.of(container -> container.getTemperatureMax() == 20)
						.withName("name");
		assertThat(fromPredicate.isSatisfiedBy(FOOD_CONTAINER), is(true));
		assertThat(fromPredicate.getName(), is("name"));
	}

	@Test
	public void fromPredicateTest_False() throws Exception {
		Specification fromPredicate =
				SpecificationFromPredicate
						.of(container -> container.getTemperatureMax() == 21)
						.withName("name");
		assertThat(fromPredicate.isSatisfiedBy(FOOD_CONTAINER), is(false));
		assertThat(fromPredicate.getName(), is("name"));
	}

}
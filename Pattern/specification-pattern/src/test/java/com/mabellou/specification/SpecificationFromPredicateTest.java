package com.mabellou.specification;

import com.mabellou.specification.data.Container;
import org.junit.Test;

import static com.mabellou.specification.data.SampleDataTestCase.FOOD_CONTAINER;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SpecificationFromPredicateTest {



	@Test
	public void fromPredicateTest_True(){
		Specification<Container> fromPredicate =
				SpecificationFromPredicate
						.of(container -> container.getTemperatureMax() == 20, "name");
		assertThat(fromPredicate.isSatisfiedBy(FOOD_CONTAINER), is(true));
		assertThat(fromPredicate.getName(), is("name"));
	}

	@Test
	public void fromPredicateTest_False(){
		Specification<Container> fromPredicate =
				SpecificationFromPredicate
						.of(container -> container.getTemperatureMax() == 21, "name");
		assertThat(fromPredicate.isSatisfiedBy(FOOD_CONTAINER), is(false));
		assertThat(fromPredicate.getName(), is("name"));
	}

}
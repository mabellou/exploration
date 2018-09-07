package com.mabellou.specification.composite;

import org.junit.Test;

import java.util.Set;

import static com.mabellou.specification.composite.SampleDataTestCase.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;

public class RemainingSpecificationTest {



	@Test
	public void and_Or_Specification_True(){
		Specification complexSpecification =        IS_FALSE_1.or(IS_FALSE_2)
											.and(
													IS_TRUE_1.or(IS_TRUE_2)
											);

		Set<Specification> unsatisfiedPredicates =
				complexSpecification.getUnsatisfiedSpecificationsFor(FOOD_CONTAINER);
		assertThat(unsatisfiedPredicates, hasSize(2));
		assertThat(unsatisfiedPredicates.contains(IS_FALSE_1), is(true));
		assertThat(unsatisfiedPredicates.contains(IS_FALSE_2), is(true));

		Set<Specification> satisfiedPredicates =
				complexSpecification.getSatisfiedSpecificationsFor(FOOD_CONTAINER);
		assertThat(satisfiedPredicates, hasSize(2));
		assertThat(satisfiedPredicates.contains(IS_TRUE_1), is(true));
		assertThat(satisfiedPredicates.contains(IS_TRUE_2), is(true));
	}

	@Test
	public void and_Or_Negate_Specification_True(){
		Specification complexSpecification =        IS_FALSE_1.or(IS_FALSE_2)
											.and(
													IS_TRUE_1.or(IS_TRUE_2)
											).negate();

		Set<Specification> unsatisfiedPredicates =
				complexSpecification.getUnsatisfiedSpecificationsFor(FOOD_CONTAINER);
		assertThat(unsatisfiedPredicates, hasSize(2));
		assertThat(unsatisfiedPredicates.contains(IS_TRUE_1), is(true));
		assertThat(unsatisfiedPredicates.contains(IS_TRUE_2), is(true));

		Set<Specification> satisfiedPredicates =
				complexSpecification.getSatisfiedSpecificationsFor(FOOD_CONTAINER);
		assertThat(satisfiedPredicates, hasSize(2));
		assertThat(satisfiedPredicates.contains(IS_FALSE_1), is(true));
		assertThat(satisfiedPredicates.contains(IS_FALSE_2), is(true));
	}

	@Test
	public void or_And_Specification_False(){
		Specification complexSpecification =        IS_FALSE_1.and(IS_FALSE_2)
											.or(
													IS_TRUE_1.and(IS_TRUE_2)
											);

		Set<Specification> unsatisfiedPredicates =
				complexSpecification.getUnsatisfiedSpecificationsFor(FOOD_CONTAINER);
		assertThat(unsatisfiedPredicates, hasSize(2));
		assertThat(unsatisfiedPredicates.contains(IS_FALSE_1), is(true));
		assertThat(unsatisfiedPredicates.contains(IS_FALSE_2), is(true));

		Set<Specification> satisfiedPredicates =
				complexSpecification.getSatisfiedSpecificationsFor(FOOD_CONTAINER);
		assertThat(satisfiedPredicates, hasSize(2));
		assertThat(satisfiedPredicates.contains(IS_TRUE_1), is(true));
		assertThat(satisfiedPredicates.contains(IS_TRUE_2), is(true));
	}

	@Test
	public void or_And_Negate_Specification_False(){
		Specification complexSpecification =        IS_FALSE_1.and(IS_FALSE_2)
											.or(
													IS_TRUE_1.and(IS_TRUE_2)
											).negate();

		Set<Specification> unsatisfiedPredicates =
				complexSpecification.getUnsatisfiedSpecificationsFor(FOOD_CONTAINER);
		assertThat(unsatisfiedPredicates, hasSize(2));
		assertThat(unsatisfiedPredicates.contains(IS_TRUE_1), is(true));
		assertThat(unsatisfiedPredicates.contains(IS_TRUE_2), is(true));

		Set<Specification> satisfiedPredicates =
				complexSpecification.getSatisfiedSpecificationsFor(FOOD_CONTAINER);
		assertThat(satisfiedPredicates, hasSize(2));
		assertThat(satisfiedPredicates.contains(IS_FALSE_1), is(true));
		assertThat(satisfiedPredicates.contains(IS_FALSE_2), is(true));
	}
}

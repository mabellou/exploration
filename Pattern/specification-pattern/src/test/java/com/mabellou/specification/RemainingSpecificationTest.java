package com.mabellou.specification;

import com.mabellou.specification.data.Container;
import org.junit.Test;

import java.util.Set;

import static com.mabellou.specification.data.SampleDataTestCase.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;

public class RemainingSpecificationTest {



	@Test
	public void and_Or_Specification_True(){
	 	Specification<Container> complexSpecification =        IS_FALSE_1.or(IS_FALSE_2)
											.and(
													IS_TRUE_1.or(IS_TRUE_2)
											);

		Set<Specification<Container>> unsatisfiedPredicates =
				complexSpecification.getUnsatisfiedSpecificationsFor(FOOD_CONTAINER);
		assertThat(unsatisfiedPredicates, hasSize(2));
		assertThat(unsatisfiedPredicates.contains(IS_FALSE_1), is(true));
		assertThat(unsatisfiedPredicates.contains(IS_FALSE_2), is(true));

		Set<Specification<Container>> satisfiedPredicates =
				complexSpecification.getSatisfiedSpecificationsFor(FOOD_CONTAINER);
		assertThat(satisfiedPredicates, hasSize(2));
		assertThat(satisfiedPredicates.contains(IS_TRUE_1), is(true));
		assertThat(satisfiedPredicates.contains(IS_TRUE_2), is(true));
	}

	@Test
	public void and_Or_Negate_Specification_True(){
	 	Specification<Container> complexSpecification =        IS_FALSE_1.or(IS_FALSE_2)
											.and(
													IS_TRUE_1.or(IS_TRUE_2)
											).negate();

		Set<Specification<Container>> unsatisfiedPredicates =
				complexSpecification.getUnsatisfiedSpecificationsFor(FOOD_CONTAINER);
		assertThat(unsatisfiedPredicates, hasSize(2));
		assertThat(unsatisfiedPredicates.contains(IS_TRUE_1), is(true));
		assertThat(unsatisfiedPredicates.contains(IS_TRUE_2), is(true));

		Set<Specification<Container>> satisfiedPredicates =
				complexSpecification.getSatisfiedSpecificationsFor(FOOD_CONTAINER);
		assertThat(satisfiedPredicates, hasSize(2));
		assertThat(satisfiedPredicates.contains(IS_FALSE_1), is(true));
		assertThat(satisfiedPredicates.contains(IS_FALSE_2), is(true));
	}

	@Test
	public void or_And_Specification_False(){
	 	Specification<Container> complexSpecification =        IS_FALSE_1.and(IS_FALSE_2)
											.or(
													IS_TRUE_1.and(IS_TRUE_2)
											);

		Set<Specification<Container>> unsatisfiedPredicates =
				complexSpecification.getUnsatisfiedSpecificationsFor(FOOD_CONTAINER);
		assertThat(unsatisfiedPredicates, hasSize(2));
		assertThat(unsatisfiedPredicates.contains(IS_FALSE_1), is(true));
		assertThat(unsatisfiedPredicates.contains(IS_FALSE_2), is(true));

		Set<Specification<Container>> satisfiedPredicates =
				complexSpecification.getSatisfiedSpecificationsFor(FOOD_CONTAINER);
		assertThat(satisfiedPredicates, hasSize(2));
		assertThat(satisfiedPredicates.contains(IS_TRUE_1), is(true));
		assertThat(satisfiedPredicates.contains(IS_TRUE_2), is(true));
	}

	@Test
	public void or_And_Negate_Specification_False(){
	 	Specification<Container> complexSpecification =        IS_FALSE_1.and(IS_FALSE_2)
											.or(
													IS_TRUE_1.and(IS_TRUE_2)
											).negate();

		Set<Specification<Container>> unsatisfiedPredicates =
				complexSpecification.getUnsatisfiedSpecificationsFor(FOOD_CONTAINER);
		assertThat(unsatisfiedPredicates, hasSize(2));
		assertThat(unsatisfiedPredicates.contains(IS_TRUE_1), is(true));
		assertThat(unsatisfiedPredicates.contains(IS_TRUE_2), is(true));

		Set<Specification<Container>> satisfiedPredicates =
				complexSpecification.getSatisfiedSpecificationsFor(FOOD_CONTAINER);
		assertThat(satisfiedPredicates, hasSize(2));
		assertThat(satisfiedPredicates.contains(IS_FALSE_1), is(true));
		assertThat(satisfiedPredicates.contains(IS_FALSE_2), is(true));
	}
}

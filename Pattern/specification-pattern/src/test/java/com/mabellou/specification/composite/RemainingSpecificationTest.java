package com.mabellou.specification.composite;

import com.mabellou.specification.Container;
import org.junit.Test;

import java.util.Set;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class RemainingSpecificationTest {

	private Container refrigeratedContainer = Container.builder()
			.temperatureMax(-20)
			.temperatureMin(-30)
			.isSanitaryForFood(true)
			.build();

	@Test
	public void and_Or_Specification_True(){
		Specification isTrue1 =
				new EqualSpecification(-20, Container::getTemperatureMax);
		Specification isTrue2 =
				new EqualSpecification(-30, Container::getTemperatureMin);
		Specification isFalse1 =
				new EqualSpecification(-21, Container::getTemperatureMax);
		Specification isFalse2 =
				new EqualSpecification(-31, Container::getTemperatureMin);

		Specification complexSpecification =        isFalse1.or(isFalse2)
											.and(
													isTrue1.or(isTrue2)
											);

		Set<Specification> unsatisfiedPredicates = complexSpecification.getUnsatisfiedSpecificationsFor(refrigeratedContainer);
		assertThat(unsatisfiedPredicates, hasSize(2));
		assertThat(unsatisfiedPredicates.contains(isFalse1), is(true));
		assertThat(unsatisfiedPredicates.contains(isFalse2), is(true));

		Set<Specification> satisfiedPredicates = complexSpecification.getSatisfiedSpecificationsFor(refrigeratedContainer);
		assertThat(satisfiedPredicates, hasSize(2));
		assertThat(satisfiedPredicates.contains(isTrue1), is(true));
		assertThat(satisfiedPredicates.contains(isTrue2), is(true));
	}

	@Test
	public void and_Or_Negate_Specification_True(){
		Specification isTrue1 =
				new EqualSpecification(-20, Container::getTemperatureMax);
		Specification isTrue2 =
				new EqualSpecification(-30, Container::getTemperatureMin);
		Specification isFalse1 =
				new EqualSpecification(-21, Container::getTemperatureMax);
		Specification isFalse2 =
				new EqualSpecification(-31, Container::getTemperatureMin);

		Specification complexSpecification =        isFalse1.or(isFalse2)
											.and(
													isTrue1.or(isTrue2)
											).negate();

		Set<Specification> unsatisfiedPredicates = complexSpecification.getUnsatisfiedSpecificationsFor(refrigeratedContainer);
		assertThat(unsatisfiedPredicates, hasSize(2));
		assertThat(unsatisfiedPredicates.contains(isTrue1), is(true));
		assertThat(unsatisfiedPredicates.contains(isTrue2), is(true));

		Set<Specification> satisfiedPredicates = complexSpecification.getSatisfiedSpecificationsFor(refrigeratedContainer);
		assertThat(satisfiedPredicates, hasSize(2));
		assertThat(satisfiedPredicates.contains(isFalse1), is(true));
		assertThat(satisfiedPredicates.contains(isFalse2), is(true));
	}

	@Test
	public void or_And_Specification_False(){
		Specification isTrue1 =
				new EqualSpecification(-20, Container::getTemperatureMax);
		Specification isTrue2 =
				new EqualSpecification(-30, Container::getTemperatureMin);
		Specification isFalse1 =
				new EqualSpecification(-21, Container::getTemperatureMax);
		Specification isFalse2 =
				new EqualSpecification(-31, Container::getTemperatureMin);

		Specification complexSpecification =        isFalse1.and(isFalse2)
											.or(
													isTrue1.and(isTrue2)
											);

		Set<Specification> unsatisfiedPredicates = complexSpecification.getUnsatisfiedSpecificationsFor(refrigeratedContainer);
		assertThat(unsatisfiedPredicates, hasSize(2));
		assertThat(unsatisfiedPredicates.contains(isFalse1), is(true));
		assertThat(unsatisfiedPredicates.contains(isFalse2), is(true));

		Set<Specification> satisfiedPredicates = complexSpecification.getSatisfiedSpecificationsFor(refrigeratedContainer);
		assertThat(satisfiedPredicates, hasSize(2));
		assertThat(satisfiedPredicates.contains(isTrue1), is(true));
		assertThat(satisfiedPredicates.contains(isTrue2), is(true));
	}

	@Test
	public void or_And_Negate_Specification_False(){
		Specification isTrue1 =
				new EqualSpecification(-20, Container::getTemperatureMax);
		Specification isTrue2 =
				new EqualSpecification(-30, Container::getTemperatureMin);
		Specification isFalse1 =
				new EqualSpecification(-21, Container::getTemperatureMax);
		Specification isFalse2 =
				new EqualSpecification(-31, Container::getTemperatureMin);

		Specification complexSpecification =        isFalse1.and(isFalse2)
											.or(
													isTrue1.and(isTrue2)
											).negate();

		Set<Specification> unsatisfiedPredicates = complexSpecification.getUnsatisfiedSpecificationsFor(refrigeratedContainer);
		assertThat(unsatisfiedPredicates, hasSize(2));
		assertThat(unsatisfiedPredicates.contains(isTrue1), is(true));
		assertThat(unsatisfiedPredicates.contains(isTrue2), is(true));

		Set<Specification> satisfiedPredicates = complexSpecification.getSatisfiedSpecificationsFor(refrigeratedContainer);
		assertThat(satisfiedPredicates, hasSize(2));
		assertThat(satisfiedPredicates.contains(isFalse1), is(true));
		assertThat(satisfiedPredicates.contains(isFalse2), is(true));
	}
}

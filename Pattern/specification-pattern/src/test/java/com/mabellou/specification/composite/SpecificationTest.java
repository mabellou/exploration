package com.mabellou.specification.composite;

import com.mabellou.specification.Container;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SpecificationTest {

	private Container refrigeratedContainer = Container.builder()
			.temperatureMax(-20)
			.temperatureMin(-30)
			.isSanitaryForFood(true)
			.build();

	@Test
	public void andSpecification_True_True(){
		Specification equalSpecificationMax =
				new EqualSpecification(-20, Container::getTemperatureMax);
		Specification equalSpecificationMin =
				new EqualSpecification(-30, Container::getTemperatureMin);

		Specification andSpecification = equalSpecificationMax.and(equalSpecificationMin);

		boolean result = andSpecification.isSatisfiedBy(refrigeratedContainer);

		assertTrue(result);
	}

	@Test
	public void andSpecification_True_False(){
		Specification equalSpecificationMax =
				new EqualSpecification(-20, Container::getTemperatureMax);
		Specification equalSpecificationMin =
				new EqualSpecification(-31, Container::getTemperatureMax);

		Specification andSpecification = equalSpecificationMax.and(equalSpecificationMin);

		boolean result = andSpecification.isSatisfiedBy(refrigeratedContainer);

		assertFalse(result);
	}

	@Test
	public void andSpecification_False_False(){
		Specification equalSpecificationMax =
				new EqualSpecification(-21, Container::getTemperatureMax);
		Specification equalSpecificationMin =
				new EqualSpecification(-31, Container::getTemperatureMax);

		Specification andSpecification = equalSpecificationMax.and(equalSpecificationMin);

		boolean result = andSpecification.isSatisfiedBy(refrigeratedContainer);

		assertFalse(result);
	}

	@Test
	public void orSpecification_True_True(){
		Specification equalSpecificationMax =
				new EqualSpecification(-20, Container::getTemperatureMax);
		Specification equalSpecificationMin =
				new EqualSpecification(-30, Container::getTemperatureMin);

		Specification orSpecification = equalSpecificationMax.or(equalSpecificationMin);

		boolean result = orSpecification.isSatisfiedBy(refrigeratedContainer);

		assertTrue(result);
	}

	@Test
	public void orSpecification_True_False(){
		Specification equalSpecificationMax =
				new EqualSpecification(-20, Container::getTemperatureMax);
		Specification equalSpecificationMin =
				new EqualSpecification(-31, Container::getTemperatureMax);

		Specification orSpecification = equalSpecificationMax.or(equalSpecificationMin);

		boolean result = orSpecification.isSatisfiedBy(refrigeratedContainer);

		assertTrue(result);
	}

	@Test
	public void orSpecification_False_False(){
		Specification equalSpecificationMax =
				new EqualSpecification(-21, Container::getTemperatureMax);
		Specification equalSpecificationMin =
				new EqualSpecification(-31, Container::getTemperatureMax);

		Specification orSpecification = equalSpecificationMax.or(equalSpecificationMin);

		boolean result = orSpecification.isSatisfiedBy(refrigeratedContainer);

		assertFalse(result);
	}

	@Test
	public void negationSpecification_True(){
		Specification specificationToNegate =
				new EqualSpecification(-19, Container::getTemperatureMax);
		Specification negationSpecification = specificationToNegate.negate();
		boolean result = negationSpecification.isSatisfiedBy(refrigeratedContainer);
		assertTrue(result);

		specificationToNegate =
				new EqualSpecification(-21, Container::getTemperatureMax);
		negationSpecification = specificationToNegate.negate();
		result = negationSpecification.isSatisfiedBy(refrigeratedContainer);
		assertTrue(result);
	}

	@Test
	public void negationSpecification_False(){
		Specification specificationToNegate =
				new EqualSpecification(-20, Container::getTemperatureMax);
		Specification negationSpecification = specificationToNegate.negate();
		boolean result = negationSpecification.isSatisfiedBy(refrigeratedContainer);
		assertFalse(result);
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

		Specification andSpecification =        isFalse1.or(isFalse2)
										.and(
												isTrue1.or(isTrue2)
										).negate();

		boolean result = andSpecification.isSatisfiedBy(refrigeratedContainer);
		assertTrue(result);

		Specification orSpecification =        isFalse1.and(isTrue1)
										.or(
												isFalse2.and(isTrue2)
										).negate();

		result = orSpecification.isSatisfiedBy(refrigeratedContainer);
		assertTrue(result);
	}

	@Test
	public void and_Or_Negate_Specification_False(){
		Specification isTrue1 =
				new EqualSpecification(-20, Container::getTemperatureMax);
		Specification isTrue2 =
				new EqualSpecification(-30, Container::getTemperatureMin);
		Specification isFalse1 =
				new EqualSpecification(-21, Container::getTemperatureMax);
		Specification isFalse2 =
				new EqualSpecification(-31, Container::getTemperatureMin);

		Specification andSpecification =        isFalse1.or(isTrue1)
										.and(
												isTrue2.or(isFalse2)
										).negate();

		boolean result = andSpecification.isSatisfiedBy(refrigeratedContainer);
		assertFalse(result);

		Specification orSpecification =        isFalse1.and(isFalse2)
										.or(
												isTrue1.and(isTrue2)
										).negate();

		result = orSpecification.isSatisfiedBy(refrigeratedContainer);
		assertFalse(result);
	}
}

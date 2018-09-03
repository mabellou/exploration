package com.mabellou.specification.composite;

import com.mabellou.specification.Container;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ValueBoundSpecificationTest {

	private Container refrigeratedContainer = Container.builder()
			.temperatureMax(-20)
			.temperatureMin(-30)
			.isSanitaryForFood(true)
			.build();

	@Test
	public void equalSpecification_True(){
		Specification equalSpecification = new EqualSpecification(-20,
				Container::getTemperatureMax);
		boolean result = equalSpecification.isSatisfiedBy(refrigeratedContainer);
		assertTrue(result);
	}

	@Test
	public void equalSpecification_False(){
		Specification equalSpecification = new EqualSpecification(-19,
				Container::getTemperatureMax);
		boolean result = equalSpecification.isSatisfiedBy(refrigeratedContainer);
		assertFalse(result);

		equalSpecification = new EqualSpecification(-21,
				Container::getTemperatureMax);
		result = equalSpecification.isSatisfiedBy(refrigeratedContainer);
		assertFalse(result);
	}

	@Test
	public void greaterThanOrEqualToSpecification_True(){
		Specification equalSpecification = new GreaterThanOrEqualToSpecification(-20,
				Container::getTemperatureMax);
		boolean result = equalSpecification.isSatisfiedBy(refrigeratedContainer);
		assertTrue(result);

		equalSpecification = new GreaterThanOrEqualToSpecification(-21,
				Container::getTemperatureMax);
		result = equalSpecification.isSatisfiedBy(refrigeratedContainer);
		assertTrue(result);
	}

	@Test
	public void greaterThanOrEqualToSpecification_False(){
		Specification equalSpecification = new GreaterThanOrEqualToSpecification(-19,
				Container::getTemperatureMax);
		boolean result = equalSpecification.isSatisfiedBy(refrigeratedContainer);
		assertFalse(result);
	}

	@Test
	public void lessThanOrEqualToSpecification_True(){
		Specification equalSpecification = new LessThanOrEqualToSpecification(-20,
				Container::getTemperatureMax);
		boolean result = equalSpecification.isSatisfiedBy(refrigeratedContainer);
		assertTrue(result);

		equalSpecification = new LessThanOrEqualToSpecification(-19,
				Container::getTemperatureMax);
		result = equalSpecification.isSatisfiedBy(refrigeratedContainer);
		assertTrue(result);
	}

	@Test
	public void lessThanOrEqualToSpecification_False(){
		Specification equalSpecification = new LessThanOrEqualToSpecification(-21,
				Container::getTemperatureMax);
		boolean result = equalSpecification.isSatisfiedBy(refrigeratedContainer);
		assertFalse(result);
	}
}
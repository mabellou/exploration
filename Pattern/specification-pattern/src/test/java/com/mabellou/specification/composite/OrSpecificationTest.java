package com.mabellou.specification.composite;

import com.mabellou.specification.Container;
import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class OrSpecificationTest {

	private Container refrigeratedContainer = Container.builder()
			.temperatureMax(-20)
			.temperatureMin(-30)
			.isSanitaryForFood(true)
			.build();

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
}

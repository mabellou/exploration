package com.mabellou.specification.composite;

import com.mabellou.specification.Container;
import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AndSpecificationTest {

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
}

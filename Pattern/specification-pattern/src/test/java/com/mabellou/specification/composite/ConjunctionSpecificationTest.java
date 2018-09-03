package com.mabellou.specification.composite;

import com.mabellou.specification.Container;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class ConjunctionSpecificationTest {

	private Container refrigeratedContainer = Container.builder()
			.temperatureMax(-20)
			.temperatureMin(-30)
			.isSanitaryForFood(true)
			.build();

	@Test
	public void conjunctionSpecification_True_True(){
		Specification equalSpecificationMax =
				new EqualSpecification(-20, Container::getTemperatureMax);
		Specification equalSpecificationMin =
				new EqualSpecification(-30, Container::getTemperatureMin);

		Specification conjunctionSpecification =
				new ConjunctionSpecification(Arrays.asList(equalSpecificationMax, equalSpecificationMin));

		boolean result = conjunctionSpecification.isSatisfiedBy(refrigeratedContainer);

		assertTrue(result);
	}

	@Test
	public void conjunctionSpecification_True_False(){
		Specification equalSpecificationMax =
				new EqualSpecification(-20, Container::getTemperatureMax);
		Specification equalSpecificationMin =
				new EqualSpecification(-31, Container::getTemperatureMax);

		Specification conjunctionSpecification =
				new ConjunctionSpecification(Arrays.asList(equalSpecificationMax, equalSpecificationMin));

		boolean result = conjunctionSpecification.isSatisfiedBy(refrigeratedContainer);

		assertFalse(result);
	}

	@Test
	public void conjunctionSpecification_False_False(){
		Specification equalSpecificationMax =
				new EqualSpecification(-21, Container::getTemperatureMax);
		Specification equalSpecificationMin =
				new EqualSpecification(-31, Container::getTemperatureMax);

		Specification conjunctionSpecification =
				new ConjunctionSpecification(Arrays.asList(equalSpecificationMax, equalSpecificationMin));

		boolean result = conjunctionSpecification.isSatisfiedBy(refrigeratedContainer);

		assertFalse(result);
	}

}
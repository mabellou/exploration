package com.mabellou.specification.composite;

import com.mabellou.specification.Container;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DisjunctionSpecificationTest {
	private Container refrigeratedContainer = Container.builder()
			.temperatureMax(-20)
			.temperatureMin(-30)
			.isSanitaryForFood(true)
			.build();

	@Test
	public void disjunctionSpecification_True_True(){
		Specification equalSpecificationMax =
				new EqualSpecification(-20, Container::getTemperatureMax);
		Specification equalSpecificationMin =
				new EqualSpecification(-30, Container::getTemperatureMin);

		Specification disjunctionSpecification =
				new DisjunctionSpecification(Arrays.asList(equalSpecificationMax, equalSpecificationMin));

		boolean result = disjunctionSpecification.isSatisfiedBy(refrigeratedContainer);

		assertTrue(result);
	}

	@Test
	public void disjunctionSpecification_True_False(){
		Specification equalSpecificationMax =
				new EqualSpecification(-20, Container::getTemperatureMax);
		Specification equalSpecificationMin =
				new EqualSpecification(-31, Container::getTemperatureMax);

		Specification disjunctionSpecification =
				new DisjunctionSpecification(Arrays.asList(equalSpecificationMax, equalSpecificationMin));

		boolean result = disjunctionSpecification.isSatisfiedBy(refrigeratedContainer);

		assertTrue(result);
	}

	@Test
	public void disjunctionSpecification_False_False(){
		Specification equalSpecificationMax =
				new EqualSpecification(-21, Container::getTemperatureMax);
		Specification equalSpecificationMin =
				new EqualSpecification(-31, Container::getTemperatureMax);

		Specification disjunctionSpecification =
				new DisjunctionSpecification(Arrays.asList(equalSpecificationMax, equalSpecificationMin));

		boolean result = disjunctionSpecification.isSatisfiedBy(refrigeratedContainer);

		assertFalse(result);
	}

}
package com.mabellou.specification.composite;

import com.mabellou.specification.Container;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class NegationSpecificationTest {

	private Container refrigeratedContainer = Container.builder()
			.temperatureMax(-20)
			.temperatureMin(-30)
			.isSanitaryForFood(true)
			.build();

	@Test
	public void negationSpecification_True(){
		Specification specificationToNegate =
				new EqualSpecification(-19, Container::getTemperatureMax);
		Specification negationSpecification = new NegationSpecification(specificationToNegate);
		boolean result = negationSpecification.isSatisfiedBy(refrigeratedContainer);
		assertTrue(result);

		specificationToNegate =
				new EqualSpecification(-21, Container::getTemperatureMax);
		negationSpecification = new NegationSpecification(specificationToNegate);
		result = negationSpecification.isSatisfiedBy(refrigeratedContainer);
		assertTrue(result);
	}

	@Test
	public void negationSpecification_False(){
		Specification specificationToNegate =
				new EqualSpecification(-20, Container::getTemperatureMax);
		Specification negationSpecification = new NegationSpecification(specificationToNegate);
		boolean result = negationSpecification.isSatisfiedBy(refrigeratedContainer);
		assertFalse(result);
	}

	@Test
	public void negateSpecification_True(){
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
	public void negateSpecification_False(){
		Specification specificationToNegate =
				new EqualSpecification(-20, Container::getTemperatureMax);
		Specification negationSpecification = specificationToNegate.negate();
		boolean result = negationSpecification.isSatisfiedBy(refrigeratedContainer);
		assertFalse(result);
	}
}
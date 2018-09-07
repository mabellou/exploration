package com.mabellou.specification.composite;

import org.junit.Test;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import static com.mabellou.specification.composite.SampleDataTestCase.*;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class SubsumptionSpecificationTest {

	@Test(expected = NotImplementedException.class)
	public void isSpecialCaseOf_Negate(){
		Specification specification = NegationSpecification.of(IS_TRUE_1);
		specification.isSpecialCaseOf(IS_FALSE_1);
	}

	@Test(expected = NotImplementedException.class)
	public void isGeneralizationOf_Negate(){
		Specification specification = NegationSpecification.of(IS_TRUE_1);
		specification.isGeneralizationOf(IS_FALSE_1);
	}

	@Test
	public void isSpecialCaseOf_GreaterThanOrEqualTo(){
		boolean result = GREATER_THAN_19.isSpecialCaseOf(GREATER_THAN_18);
		assertTrue(result);
		result = GREATER_THAN_18.isSpecialCaseOf(GREATER_THAN_19);
		assertFalse(result);
	}

	@Test
	public void isGeneralizationOf_GreaterThanOrEqualTo(){
		boolean result = GREATER_THAN_18.isGeneralizationOf(GREATER_THAN_19);
		assertTrue(result);
		result = GREATER_THAN_19.isGeneralizationOf(GREATER_THAN_18);
		assertFalse(result);
	}

	@Test
	public void isSpecialCaseOf_LessThanOrEqualTo(){
		boolean result = LESS_THAN_21.isSpecialCaseOf(LESS_THAN_22);
		assertTrue(result);
		result = LESS_THAN_22.isSpecialCaseOf(LESS_THAN_21);
		assertFalse(result);
	}

	@Test
	public void isGeneralizationOf_LessThanOrEqualTo(){
		boolean result = LESS_THAN_22.isGeneralizationOf(LESS_THAN_21);
		assertTrue(result);
		result = LESS_THAN_21.isGeneralizationOf(LESS_THAN_22);
		assertFalse(result);
	}

	@Test(expected = IllegalArgumentException.class)
	public void isSpecialCaseOf_DifferentType(){
		LESS_THAN_21.isSpecialCaseOf(GREATER_THAN_18);

	}

	@Test(expected = IllegalArgumentException.class)
	public void isGeneralizationOf_DifferentType(){
		GREATER_THAN_19.isGeneralizationOf(LESS_THAN_21);
	}

	@Test
	public void isSpecialCaseOf_And(){
		Specification andSpecification = GREATER_THAN_18.and(GREATER_THAN_20);
		boolean result = andSpecification.isSpecialCaseOf(GREATER_THAN_19);
		assertTrue(result);
		result = andSpecification.isSpecialCaseOf(GREATER_THAN_21);
		assertFalse(result);
	}

	@Test
	public void isGeneralizationOf_And(){
		Specification andSpecification = GREATER_THAN_18.and(GREATER_THAN_20);
		boolean result = andSpecification.isGeneralizationOf(GREATER_THAN_21);
		assertTrue(result);
		result = andSpecification.isGeneralizationOf(GREATER_THAN_19);
		assertFalse(result);
	}

	@Test
	public void isSpecialCaseOf_Or(){
		Specification orSpecification = GREATER_THAN_19.or(GREATER_THAN_21);
		boolean result = orSpecification.isSpecialCaseOf(GREATER_THAN_18);
		assertTrue(result);
		result = orSpecification.isSpecialCaseOf(GREATER_THAN_20);
		assertFalse(result);
	}

	@Test
	public void isGeneralizationOf_Or(){
		Specification orSpecification = GREATER_THAN_19.or(GREATER_THAN_21);
		boolean result = orSpecification.isGeneralizationOf(GREATER_THAN_20);
		assertTrue(result);
		result = orSpecification.isGeneralizationOf(GREATER_THAN_18);
		assertFalse(result);
	}
}

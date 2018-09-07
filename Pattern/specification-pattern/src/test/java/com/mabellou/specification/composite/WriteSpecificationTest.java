package com.mabellou.specification.composite;

import org.junit.Test;

import static com.mabellou.specification.composite.SampleDataTestCase.*;
import static org.junit.Assert.assertEquals;

public class WriteSpecificationTest {



	@Test
	public void and_Or_Negate_Specification_True(){
		Specification andSpecification =        IS_FALSE_1.or(IS_FALSE_2)
										.and(
												IS_TRUE_1.or(IS_TRUE_2)
										).negate();

		String result = andSpecification.getText(FOOD_CONTAINER);
		assertEquals("!((( 20 == 19 [false] ) || ( 10 == 9 [false] )) && (( 20 == 20 [true] ) || ( 10 == 10 [true] )))", result);
	}

	@Test
	public void and_Or_Negate_Specification_False(){
		Specification andSpecification =        IS_FALSE_1.or(IS_TRUE_1)
										.and(
												IS_TRUE_2.or(IS_FALSE_2)
										).negate();

		String result = andSpecification.getText(FOOD_CONTAINER);
		assertEquals("!((( 20 == 19 [false] ) || ( 20 == 20 [true] )) && (( 10 == 10 [true] ) || ( 10 == 9 [false] )))", result);
	}
}

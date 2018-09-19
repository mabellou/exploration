package com.mabellou.specification;

import com.mabellou.specification.data.Container;
import org.junit.Test;

import static com.mabellou.specification.data.SampleDataTestCase.*;
import static org.junit.Assert.assertEquals;

public class WriteSpecificationTest {

	@Test
	public void write_Specification_True_Inline(){
		Specification<Container> specification =        IS_FALSE_1.or(IS_FALSE_2)
										.and(
												IS_TRUE_1.or(IS_TRUE_2)
										).negate();

		String result = specification.toString(FOOD_CONTAINER, Specification.StringFormatter.INLINE);
		assertEquals("!((( 20 == 19 [=false] ) || ( 10 == 9 [=false] )) && (( 20 == 20 [=true] ) || ( 10 == 10 [=true] )))", result);
	}

	@Test
	public void write_Specification_False_Inline(){
		Specification<Container> specification =        IS_FALSE_1.or(IS_TRUE_1)
										.and(
												IS_TRUE_2.or(IS_FALSE_2)
										).negate();

		String result = specification.toString(FOOD_CONTAINER, Specification.StringFormatter.INLINE);
		assertEquals("!((( 20 == 19 [=false] ) || ( 20 == 20 [=true] )) && (( 10 == 10 [=true] ) || ( 10 == 9 [=false] )))", result);
	}

	@Test
	public void write_Specification_True_MultipleLine(){
		Specification<Container> specification =        IS_FALSE_1.or(IS_FALSE_2)
									.and(
											IS_TRUE_1.or(IS_TRUE_2)
									).negate();

		String result = specification.toString(FOOD_CONTAINER, Specification.StringFormatter.MULTIPLE_LINE);
		assertEquals("Negation of false [=true]" + System.lineSeparator() +
				"Begin and " + System.lineSeparator() +
				"Begin or" + System.lineSeparator() +
				" 20 == 19 [=false] " + System.lineSeparator() +
				"Or" + System.lineSeparator() +
				" 10 == 9 [=false] " + System.lineSeparator() +
				"End or [=false]" + System.lineSeparator() +
				"And" + System.lineSeparator() +
				"Begin or" + System.lineSeparator() +
				" 20 == 20 [=true] " + System.lineSeparator() +
				"Or" + System.lineSeparator() +
				" 10 == 10 [=true] " + System.lineSeparator() +
				"End or [=true]" + System.lineSeparator() +
				"End and [=false]" + System.lineSeparator(), result);
	}

	@Test
	public void write_Specification_False_MultipleLine(){
		Specification<Container> specification =        IS_FALSE_1.or(IS_TRUE_1)
									.and(
											IS_TRUE_2.or(IS_FALSE_2)
									).negate();

		String result = specification.toString(FOOD_CONTAINER, Specification.StringFormatter.MULTIPLE_LINE);
		assertEquals("Negation of true [=false]" + System.lineSeparator() +
				"Begin and " + System.lineSeparator() +
				"Begin or" + System.lineSeparator() +
				" 20 == 19 [=false] " + System.lineSeparator() +
				"Or" + System.lineSeparator() +
				" 20 == 20 [=true] " + System.lineSeparator() +
				"End or [=true]" + System.lineSeparator() +
				"And" + System.lineSeparator() +
				"Begin or" + System.lineSeparator() +
				" 10 == 10 [=true] " + System.lineSeparator() +
				"Or" + System.lineSeparator() +
				" 10 == 9 [=false] " + System.lineSeparator() +
				"End or [=true]" + System.lineSeparator() +
				"End and [=true]" + System.lineSeparator(), result);
	}
}

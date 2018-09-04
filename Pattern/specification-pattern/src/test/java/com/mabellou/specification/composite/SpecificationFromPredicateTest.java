package com.mabellou.specification.composite;

import com.mabellou.specification.Container;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class SpecificationFromPredicateTest {

	private Container refrigeratedContainer = Container.builder()
			.temperatureMax(-20)
			.temperatureMin(-30)
			.isSanitaryForFood(true)
			.build();

	@Test
	public void fromPredicateTest_True() throws Exception {
		Specification fromPredicate =
				new SpecificationFromPredicate(container -> container.getTemperatureMax() == -20,
						"name");
		assertThat(fromPredicate.isSatisfiedBy(refrigeratedContainer), is(true));
	}

	@Test
	public void fromPredicateTest_False() throws Exception {
		Specification fromPredicate =
				new SpecificationFromPredicate(container -> container.getTemperatureMax() == -21,
						"name");
		assertThat(fromPredicate.isSatisfiedBy(refrigeratedContainer), is(false));
	}

}
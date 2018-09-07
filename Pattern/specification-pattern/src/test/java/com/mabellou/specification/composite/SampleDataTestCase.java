package com.mabellou.specification.composite;

import com.mabellou.specification.Container;

public class SampleDataTestCase {

	public static final Container FOOD_CONTAINER = Container.builder()
			.temperatureMax(20)
			.temperatureMin(10)
			.isSanitaryForFood(true)
			.build();

	public static final Specification IS_TRUE_1 =
			EqualSpecification.of(20, Container::getTemperatureMax);
	public static final Specification IS_TRUE_2 =
			EqualSpecification.of(10, Container::getTemperatureMin);
	public static final Specification IS_FALSE_1 =
			EqualSpecification.of(19, Container::getTemperatureMax);
	public static final Specification IS_FALSE_2 =
			EqualSpecification.of(9, Container::getTemperatureMin);


	public static final Specification EQUALS_TRUE =
			EqualSpecification.of(20, Container::getTemperatureMax);
	public static final Specification EQUALS_FALSE =
			EqualSpecification.of(21, Container::getTemperatureMax);

	public static final Specification GREATER_THAN_18 =
			GreaterThanOrEqualToSpecification.of(18, Container::getTemperatureMax);
	public static final Specification GREATER_THAN_19 =
			GreaterThanOrEqualToSpecification.of(19, Container::getTemperatureMax);
	public static final Specification GREATER_THAN_20 =
			GreaterThanOrEqualToSpecification.of(20, Container::getTemperatureMax);
	public static final Specification GREATER_THAN_21 =
			GreaterThanOrEqualToSpecification.of(21, Container::getTemperatureMax);

	public static final Specification LESS_THAN_19 =
			LessThanOrEqualToSpecification.of(19, Container::getTemperatureMax);
	public static final Specification LESS_THAN_20 =
			LessThanOrEqualToSpecification.of(20, Container::getTemperatureMax);
	public static final Specification LESS_THAN_21 =
			LessThanOrEqualToSpecification.of(21, Container::getTemperatureMax);
	public static final Specification LESS_THAN_22 =
			LessThanOrEqualToSpecification.of(22, Container::getTemperatureMax);

}

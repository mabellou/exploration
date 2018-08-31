package com.mabellou.specification.hardcoded;

import com.mabellou.specification.Container;
import com.mabellou.specification.Specification;

public class IceSpecification implements Specification {

	public static final Integer MAX_TEMPERATURE_REFRIGERATE = -15;
	public static final Integer MIN_TEMPERATURE_REFRIGERATE = -32;

	@Override
	public boolean isSatisfiedBy(Container container) {
		return  container.isSanitaryForFood()
				&& container.getTemperatureMax() <= MAX_TEMPERATURE_REFRIGERATE
				&& container.getTemperatureMin() >= MIN_TEMPERATURE_REFRIGERATE;
	}
}

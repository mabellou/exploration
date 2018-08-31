package com.mabellou.specification.parameterized;

import com.mabellou.specification.Container;
import com.mabellou.specification.Specification;

public class CargoSpecification implements Specification {

	private Integer maxTemperature;
	private Integer minTemperature;
	private boolean checkSanitaryFood;

	public CargoSpecification(Integer maxTemperature,
							  Integer minTemperature,
							  boolean checkSanitaryFood) {
		this.maxTemperature = maxTemperature;
		this.minTemperature = minTemperature;
		this.checkSanitaryFood = checkSanitaryFood;
	}

	@Override
	public boolean isSatisfiedBy(Container container) {
		return  checkSanitaryFood ? container.isSanitaryForFood() : !container.isSanitaryForFood()
				&& container.getTemperatureMax() <= maxTemperature
				&& container.getTemperatureMin() >= minTemperature;
	}
}
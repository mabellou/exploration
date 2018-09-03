package com.mabellou.specification.parameterized;

import com.mabellou.specification.Cargo;
import com.mabellou.specification.Container;
import com.mabellou.specification.composite.Specification;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ParameterizedSpecificationTest {

	private Container refrigeratedContainer = Container.builder()
			.temperatureMax(-20)
			.temperatureMin(-30)
			.isSanitaryForFood(true)
			.build();

	private Container clothingContainer = Container.builder()
			.temperatureMax(25)
			.temperatureMin(-15)
			.isSanitaryForFood(false)
			.build();

	@Test
	public void parameterizedSpecification_For_Food_Test(){
		Specification iceSpecification = new CargoSpecification(-15, -30, true);
		Cargo iceCargo = new Cargo(iceSpecification);

		boolean refrigeratedContainerResult =
				iceCargo.getSpecification().isSatisfiedBy(refrigeratedContainer);
		boolean shoesContainerResult =
				iceCargo.getSpecification().isSatisfiedBy(clothingContainer);

		assertTrue(refrigeratedContainerResult);
		assertFalse(shoesContainerResult);
	}

	@Test
	public void parameterizedSpecification_For_Shoes_Test(){
		Specification shoesSpecification = new CargoSpecification(30, -20, false);
		Cargo shoesCargo = new Cargo(shoesSpecification);

		boolean refrigeratedContainerResult =
				shoesCargo.getSpecification().isSatisfiedBy(refrigeratedContainer);
		boolean shoesContainerResult =
				shoesCargo.getSpecification().isSatisfiedBy(clothingContainer);

		assertTrue(shoesContainerResult);
		assertFalse(refrigeratedContainerResult);
	}
}
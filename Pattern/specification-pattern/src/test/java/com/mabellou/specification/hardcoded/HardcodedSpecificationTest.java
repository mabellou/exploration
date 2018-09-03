package com.mabellou.specification.hardcoded;

import com.mabellou.specification.Cargo;
import com.mabellou.specification.Container;
import com.mabellou.specification.composite.Specification;
import org.junit.Test;

import static org.junit.Assert.*;

public class HardcodedSpecificationTest {

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
	public void hardcodedSpecification_For_Cargo_Test(){
		Specification iceSpecification = new IceSpecification();
		Cargo iceCargo = new Cargo(iceSpecification);

		boolean refrigeratedContainerResult =
				iceCargo.getSpecification().isSatisfiedBy(refrigeratedContainer);
		boolean shoesContainerResult =
				iceCargo.getSpecification().isSatisfiedBy(clothingContainer);

		assertTrue(refrigeratedContainerResult);
		assertFalse(shoesContainerResult);
	}

	@Test
	public void hardcodedSpecification_For_Shoes_Test(){
		Specification shoesSpecification = new ShoesSpecification();
		Cargo shoesCargo = new Cargo(shoesSpecification);

		boolean refrigeratedContainerResult =
				shoesCargo.getSpecification().isSatisfiedBy(refrigeratedContainer);
		boolean shoesContainerResult =
				shoesCargo.getSpecification().isSatisfiedBy(clothingContainer);

		assertTrue(shoesContainerResult);
		assertFalse(refrigeratedContainerResult);
	}
}
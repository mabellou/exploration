package com.mabellou.java9.stream;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.junit.Test;

public class StreamFlatMapTest {
	
	@Test
	public void testFlatMap() {
		var list1 = List.of(new PersonDTO("test11", 18, List.of("a", "b"), Optional.of("lambo")), 
							new PersonDTO("test12", 21, List.of("c", "d"), Optional.of("ferrari")));
		var list2 = List.of(new PersonDTO("test21", 19, List.of("e", "f"), Optional.of("vw")), 
							new PersonDTO("test22", 22, List.of("g", "h"), Optional.of("bmw")));
		var list3 = List.of(new PersonDTO("test31", 20, List.of("i", "j"), Optional.empty()), 
							new PersonDTO("test32", 23, List.of("k", "l"), Optional.of("renault")));
		var listOfList = List.of(list1, list2, list3);
		
		var resultList = listOfList.stream()
				//.flatMap(ps -> ps.stream().map(p -> p.getCarName()))
				.flatMap(ps -> ps.stream()
							.flatMap(p -> p.getCarName().stream()))
				.collect(Collectors.toList());
		
		System.out.println(resultList);
		assertThat(true).isTrue();
	}

}

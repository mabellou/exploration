package com.mabellou.reactor.spring;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;

public class Java10VarTest {
		
	@Test
	public void testVar() throws Exception {
		var test = List.of("test1", "test2");
		assertThat(test.get(0)).isEqualTo("test1");
	}

}

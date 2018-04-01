package com.mabellou.reactor.spring;

import org.junit.Test;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.Duration;
import java.util.List;

public class ReactorSimpleTest {

	private static List<String> words = List.of(
	        "the",
	        "quick",
	        "brown",
	        "fox",
	        "jumped",
	        "over",
	        "the",
	        "lazy",
	        "dog"
	        );
	
	@Test
	public void test1() throws Exception {
		Flux
			.fromIterable(words)
			.flatMap(word -> Flux.fromArray(word.split("")))
			.distinct()
			.concatWith(Flux.just("s"))
			.sort()
			.zipWith(Flux.range(0, 50), 
					(word, count) -> String.format("%2d) %s", count, word))
			.subscribe(w -> System.out.println(w));
		System.out.println("test");
	}
	
	@Test
	public void shortCircuit() throws Exception {
	  Flux<String> helloPauseWorld = 
	              Mono.just("Hello")
	                  .concatWith(Mono.just("world")
	                		  		  .delaySubscription(Duration.ofSeconds(1)));

	  helloPauseWorld.subscribe(System.out::println);
	  System.out.println("haha");
	  Thread.sleep(2000);
	}
	
	@Test
	public void testSynch() throws Exception {
		Flux<Integer> flux = Flux
			.range(0, 1000000);
		
		System.out.println("before");
		flux.subscribe(w -> System.out.println(w));
		System.out.println("after");
	}
}

package com.mabellou.java9.stream;

import static com.jayway.awaitility.Awaitility.await;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.concurrent.SubmissionPublisher;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.Test;

public class TransformProcessorTest {
	
	@Test
	public void test() throws Exception {
		// Given
		SubmissionPublisher<Integer> publisher = new SubmissionPublisher<>();
		Function<Integer, String> transformToFrenchString = i -> "Il y a " + i + " croissant" + (i > 2 ? "s" : "");
		TransformProcessor<Integer, String> transformProcessor = new TransformProcessor<>(transformToFrenchString);
		EndSubscriber<String> endSubscriber = new EndSubscriber<>();
		List<Integer> items = IntStream.range(1, 20)
				.mapToObj(n -> Integer.valueOf(n))
				.collect(Collectors.toList());
		
		publisher.subscribe(transformProcessor);
		transformProcessor.subscribe(endSubscriber);
		
		// When
		items.forEach(item -> {
			System.out.println("- FOREACH: " + item + " will be submitted");
			publisher.submit(item);
		});
		System.out.println("HAHAH, I will close");
		publisher.close();
		System.out.println("Now, I am really closed");
		
		// Then
		await()
			.atMost(1, TimeUnit.SECONDS)
			.until(() -> assertThat(endSubscriber.consumedElements));
	}
}

package com.mabellou.java9.stream;

import java.util.List;
import java.util.concurrent.SubmissionPublisher;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.Test;

import static com.jayway.awaitility.Awaitility.await;
import static org.assertj.core.api.Assertions.*;

public class EndSubscriberTest {
	
	@Test
	public void test() throws Exception {
		// Given
		SubmissionPublisher<String> publisher = new SubmissionPublisher<>();
		EndSubscriber<String> subscriber = new EndSubscriber<>();
		publisher.subscribe(subscriber);
		List<String> items = IntStream.range(1, 20)
				.mapToObj(n -> n + "")
				.collect(Collectors.toList());
		
		// When
		items.forEach(item -> {
			System.out.println("FOREACH: " + item + " will be submitted");
			publisher.submit(item);
			System.out.println(item + " is submitted");
		});
		System.out.println("HAHAH, I will close");
		publisher.close();
		System.out.println("Now, I am really closed");
		
		System.out.println("Wait 2 seconds before 5 new");
		Thread.sleep(2000);
		
		subscriber.changeRequestNb(5);
		
		System.out.println("Wait 2 seconds before 11 new");
		Thread.sleep(2000);
		
		subscriber.changeRequestNb(11);
		// Then
		await()
			.atMost(1, TimeUnit.SECONDS)
			.until(() -> assertThat(subscriber.consumedElements).containsExactlyElementsOf(items));
	}
}

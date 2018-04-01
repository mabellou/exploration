package com.mabellou.java9.stream;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;

public class EndSubscriber<T> implements Subscriber<T> {

	private Subscription subscription;
	public List<T> consumedElements = new LinkedList<>();
	
	@Override
	public void onComplete() {
		System.out.println("I'm done, go fuck yourself.");
	}

	@Override
	public void onError(Throwable t) {
		t.printStackTrace();
	}

	@Override
	public void onNext(T item) {
		System.out.println("----- Finally I have : " + item);
		consumedElements.add(item);
	}

	@Override
	public void onSubscribe(Subscription subscription) {
		this.subscription = subscription;
		this.subscription.request(5);
	}
	
	public void changeRequestNb(int n) {
		this.subscription.request(n);
	}

}

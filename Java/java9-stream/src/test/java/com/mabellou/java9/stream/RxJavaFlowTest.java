package com.mabellou.java9.stream;

import org.junit.Test;

import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;

public class RxJavaFlowTest {

	@Test
	public void testFlow() {
        Flowable<Integer> flow = Flowable.range(1, 1000)
        		.map(v -> v * v);
        System.out.println("Before");
        flow.subscribe(f -> System.out.println(f));
        System.out.println("The End");
    }
	
	@Test
	public void testFlowCallable() throws Exception {
		Flowable.fromCallable(() -> {
		    Thread.sleep(2000); //  imitate expensive computation
		    return "Task Executed";
		})
		  .subscribeOn(Schedulers.io())
		  .observeOn(Schedulers.single())
		  .subscribe(System.out::println, Throwable::printStackTrace);
		
		System.out.println("Waiting for the task");

		Thread.sleep(3000); // <--- wait for the flow to finish
    }
	
}

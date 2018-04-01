package com.mabellou.java9.stream;

import io.reactivex.observers.DisposableObserver;

public class ObserverOfPerson extends DisposableObserver<PersonDTO> {

	private String prefix;
	
	public ObserverOfPerson(String prefix) {
		super();
		this.prefix = prefix;
	}

	@Override
	public void onComplete() {
		System.out.println("Stop it man, it's done");		
	}

	@Override
	public void onError(Throwable t) {
		System.out.println("There have to be an error");
		t.printStackTrace();
	}

	@Override
	public void onNext(PersonDTO person) {
		System.out.println("Hello " + prefix + " we received: " + person);
	}

}

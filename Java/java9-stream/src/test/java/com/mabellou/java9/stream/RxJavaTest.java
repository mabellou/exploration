package com.mabellou.java9.stream;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observables.ConnectableObservable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;

public class RxJavaTest {
	
	@Test
	public void returnValue() {
		
		ObserverOfPerson observer1 = new ObserverOfPerson("MaBelle69");
		ObserverOfPerson observer2 = new ObserverOfPerson("MonBeau69");
		
		Observable<PersonDTO> observable = Observable.create(new ObservableOfPerson());
		
		observable.subscribe(observer1);
//		observable.subscribe(observer2);
		
		System.out.println("The END of the test");
	}
	
	@Test
	public void subject() {
		
		ObserverOfPerson observer1 = new ObserverOfPerson("MaBelle69");
		ObserverOfPerson observer2 = new ObserverOfPerson("MonBeau69");
		
		Observable<PersonDTO> observable = Observable.create(new ObservableOfPerson());
		
		var persons = new ArrayList<PersonDTO>();
		observable.subscribe(p -> persons.add(p));
		
		PublishSubject<PersonDTO> subject = PublishSubject.create(); 
		
		System.out.println("-- Begin True Test");
		
		subject.onNext(persons.get(0));
		
		subject.subscribe(observer1);
		subject.subscribe(observer2);
		
		subject.onNext(persons.get(0));
		subject.onNext(persons.get(1));
		subject.onNext(persons.get(2));
		subject.onNext(persons.get(3));
		
		
		
		subject.onNext(persons.get(4));
		subject.onComplete();
		
		System.out.println("The END of the test");
	}
	
	@Test
	public void testBackPressure() throws Exception {
		Observable.range(1, 5)
		  .observeOn(Schedulers.computation())
		  .subscribe(RxJavaTest::compute);
		System.out.println("haha nimport quoi");
		TimeUnit.SECONDS.sleep(3);
	}
	
	public static void compute(Integer v) {
		System.out.println("compute integer v: " + v);
    }
}

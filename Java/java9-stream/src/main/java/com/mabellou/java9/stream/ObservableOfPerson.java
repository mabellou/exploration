package com.mabellou.java9.stream;

import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

public class ObservableOfPerson implements ObservableOnSubscribe<PersonDTO>{

	@Override
	public void subscribe(ObservableEmitter<PersonDTO> emitter) throws Exception {
		try {
			for(int i : IntStream.range(0, 5).toArray()) {
				System.out.println("I will send the last dumb " + i);
				emitter.onNext(new PersonDTO("test" + i, i, List.of(), Optional.empty()));
				//TimeUnit.SECONDS.sleep(2);
			}
			emitter.onComplete();
		} catch (Exception e) {
			emitter.onError(e);
		}
	}

}

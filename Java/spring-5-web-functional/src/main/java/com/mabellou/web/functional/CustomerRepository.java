package com.mabellou.web.functional;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CustomerRepository extends ReactiveCrudRepository<Customer, String>{

	Flux<Customer> findByLastName(String lastName);
	Flux<Customer> findByAge(int age);
	
	@Query("{ 'firstname': ?0, 'lastname': ?1}")
	Mono<Customer> findByFirstnameAndLastname(String firstname, String lastname);
}

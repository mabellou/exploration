package com.javasampleapproach.webclient;

import com.javasampleapproach.model.Customer;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface WebClientTransport {
	public Mono<Customer> getById(Long id);
	public Flux<Customer> getAll();
	public Mono<Customer> save(Customer customer);
	public Mono<Customer> update(Long id, Customer customer);
	public Mono<Void> delete(Long id);
}

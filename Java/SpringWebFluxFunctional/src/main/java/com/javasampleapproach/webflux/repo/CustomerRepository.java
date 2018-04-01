package com.javasampleapproach.webflux.repo;

import com.javasampleapproach.webflux.model.Customer;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CustomerRepository {
	public Mono<Customer> getCustomerById(Long id);
	public Flux<Customer> getAllCustomers();
	public Mono<Customer> saveCustomer(Mono<Customer> customer);
	public Mono<Customer> putCustomer(Long id, Mono<Customer> customer);
	public Mono<Void> deleteCustomer(Long id);
}

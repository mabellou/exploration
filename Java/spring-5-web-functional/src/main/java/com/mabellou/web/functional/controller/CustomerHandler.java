package com.mabellou.web.functional.controller;

import static org.springframework.web.reactive.function.BodyInserters.fromObject;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.mabellou.web.functional.entity.Customer;
import com.mabellou.web.functional.repository.CustomerRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class CustomerHandler {
	
	CustomerRepository customerRepository;

	@Autowired
	public CustomerHandler(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	public Mono<ServerResponse> getAllCustomers(ServerRequest serverRequest) {
		System.out.println("Welcome in the get method");
		Flux<Customer> flux = customerRepository
				.findAll()
				.doOnNext(s -> {
					System.out.println("Hello " + s.getFirstName() + " and wait for 1 sec");
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				});
	    return ServerResponse.ok().body(flux, Customer.class);
	}
	
	public Mono<ServerResponse> findByName(ServerRequest serverRequest){
		Optional<String> name = serverRequest.queryParam("name");
		if(name.isPresent()) {
			return ServerResponse
					.ok()
					.body(customerRepository.findByLastName(name.get()), Customer.class);
		} else {
			return ServerResponse
					.badRequest()
					.build();
		}
	}
	
	public Mono<ServerResponse> createCustomer(ServerRequest serverRequest){
		Mono<Customer> customerToSave = serverRequest.bodyToMono(Customer.class);
		return customerRepository
				.save(customerToSave.block())
				.flatMap(customer -> ServerResponse
						.ok()
						.body(fromObject(customer)));
	}
	
	public Mono<ServerResponse> createAllCustomer(ServerRequest serverRequest){
		System.out.println("Welcome in the put method");
		int maxNb = Integer.parseInt(serverRequest.pathVariable("maxNb"));
		Flux<Customer> customerFlux = Flux.range(0, maxNb)
				.flatMap(i -> {
					Customer customer = new Customer("test" + i, "test" + i, i);
					System.out.println("Creating customer " + customer.getFirstName() + " " + customer.getLastName());
					return customerRepository.save(customer);
				});
		return ServerResponse
				.ok()
				.body(customerFlux, Customer.class);
	}
	
	public Mono<ServerResponse> updateCustomer(ServerRequest serverRequest){
		String id = serverRequest.pathVariable("id");
		Customer customerToSave = serverRequest
				.bodyToMono(Customer.class)
				.block();
		return customerRepository
				.findById(id)
				.flatMap(customerFromRepo -> {
					customerFromRepo.setFirstName(customerToSave.getFirstName());
					customerFromRepo.setLastName(customerToSave.getLastName());
					customerFromRepo.setAge(customerToSave.getAge());
					return customerRepository.save(customerFromRepo);
				})
				.flatMap(updatedCustomer -> ServerResponse
						.ok()
						.body(fromObject(updatedCustomer)));
	}
	
	public Mono<ServerResponse> deleteAllCustomers(ServerRequest serverRequest){
		return ServerResponse
				.ok()
				.build(customerRepository
						.deleteAll());
	}
	
	public Mono<ServerResponse> deleteCustomer(ServerRequest serverRequest){
		String id = serverRequest.pathVariable("id");
		return ServerResponse
				.ok()
				.build(customerRepository
						.deleteById(id));
	}
}

package com.mabellou.spring.flux.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mabellou.spring.flux.entity.Customer;
import com.mabellou.spring.flux.repository.CustomerRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class CustomerController {

	CustomerRepository customerRepository;
	
	@Autowired
	public CustomerController(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	@GetMapping(value = "/customers")
	public Flux<Customer> getAllCustomers() {
		System.out.println("Welcome in the get method");
		Flux<Customer> flux = customerRepository
				.findAll()
				.doOnNext(s -> {
					System.out.println("Hello " + s.getFirstName() + " and wait for 1 sec bitch");
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				});
	    return flux;
	}
	
	@GetMapping("/customers/findbylastname")
	public Flux<Customer> findByName(@RequestParam String name){
		return customerRepository.findByLastName(name);
	}
	
	@PutMapping("/customers")
	public Mono<Customer> createCustomer(@RequestBody Customer customer){
		return customerRepository.save(customer);
	}
	
	@PutMapping("/customers/{maxNb}")
	public Flux<Customer> createAllCustomer(@PathVariable("maxNb") int maxNb){
		System.out.println("Welcome in the put method");
		return Flux.range(0, maxNb)
			.flatMap(i -> {
				Customer customer = new Customer("test" + i, "test" + i, i);
				System.out.println("Creating customer " + customer.getFirstName() + " " + customer.getLastName());
				return customerRepository.save(customer);
			});
	}
	
	@PostMapping("/customers/{id}")
	public Mono<ResponseEntity<Customer>> updateCustomer(@PathVariable("id") String id, @RequestBody Customer customer){
		return customerRepository
				.findById(id)
				.flatMap(customerFromRepo -> {
					customerFromRepo.setFirstName(customer.getFirstName());
					customerFromRepo.setLastName(customer.getLastName());
					customerFromRepo.setAge(customer.getAge());
					return customerRepository.save(customerFromRepo);
				})
				.map(updatedCustomer -> new ResponseEntity<>(updatedCustomer, HttpStatus.OK))
				.defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	@DeleteMapping("/customers")
	public ResponseEntity<?> deleteAllCustomers(){
		try {
			customerRepository.deleteAll().subscribe();
		} catch (Exception e) {
			new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}
		return new ResponseEntity<>(HttpStatus.OK); 
	}
	
	@DeleteMapping("/customers/{id}")
	public ResponseEntity<?> deleteCustomer(@PathVariable("id") String id){
		try {
			customerRepository.deleteById(id).subscribe();
		} catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}

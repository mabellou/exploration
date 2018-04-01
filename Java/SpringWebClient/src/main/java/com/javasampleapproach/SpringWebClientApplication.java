package com.javasampleapproach;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.javasampleapproach.model.Customer;
import com.javasampleapproach.webclient.WebClientTransport;

@SpringBootApplication
public class SpringWebClientApplication implements CommandLineRunner{

	@Autowired
	WebClientTransport webClient;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringWebClientApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		// get all customers
		System.out.println("################### Get All Customers");
		webClient.getAll().subscribe(System.out::println);
		
		Thread.sleep(2000);
		
		// get a customer
		System.out.println("################### Get a Customer with id = 1");
		webClient.getById(new Long(1)).subscribe(System.out::println);
		
		Thread.sleep(2000);
		
		// post a customer
		System.out.println("################### Save a Customer");
		webClient.save(new Customer(3, "Mary", "Taylor", 27)).subscribe(System.out::println);
		
		Thread.sleep(2000);
		
		// update a customer
		System.out.println("################### Update a Customer");
		webClient.update(new Long(3), new Customer(3, "Amy", "Taylor", 24)).subscribe(System.out::println);
		
		Thread.sleep(2000);
		
		// delete a customer
		System.out.println("################### Delete a Customer with id = 1");
		webClient.delete(new Long(1)).subscribe(response -> System.out.println("Delete Successfuly!"));
		
		Thread.sleep(2000);
		
		// get all customers
		System.out.println("################### Get All Customers for final checking");
		webClient.getAll().subscribe(System.out::println);
		
		Thread.sleep(2000);
	}
}


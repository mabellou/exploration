package com.mabellou.spring.flux.client;

import java.io.IOException;
import java.net.URI;
import java.time.Duration;
import java.util.stream.IntStream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.socket.client.ReactorNettyWebSocketClient;
import org.springframework.web.reactive.socket.client.WebSocketClient;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class CommandLiner implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Begin the CommandLiner");

		//this.put2();
		this.get();
		//this.getWebsocket();
	}
	
	private void getWebsocket() {
		WebSocketClient client = new ReactorNettyWebSocketClient();
		ObjectMapper objectMapper = new ObjectMapper();
		client.execute(
				URI.create("ws://localhost:8080/event-emitter"), 
					session -> session.receive()
				              .doOnNext(message -> {
				            	  	Customer customer;
									try {
										customer = objectMapper.readValue(message.getPayloadAsText(), Customer.class);
										System.out.println("WebSocket customer: " + customer.getId() + " " + customer.getFirstName()); 
									} catch (IOException e) {
										e.printStackTrace();
									}
				              })
				            .then())
				            .block();
		System.out.println("the end");
	}
	
	// The field APPLICATION_STREAM_JSON allows to receive the request as a stream
	// In fact, the stream will be sent as SSE (Server Sent Events) to the client
	// Then, the program will send each item of the stream when it is ready
	// If multiple comes quite fast, then it will send them
	private void get() throws Exception {
		 System.out.println("Before bodyToFlux get");
		 WebClient
				 .create("http://localhost:8080")
				 .get()
				 .uri("/customers")
				 .accept(MediaType.APPLICATION_STREAM_JSON)
				 .retrieve()
				 .bodyToFlux(Customer.class)
				 .subscribe(c -> System.out.println("-- Getting Customer " + c.getLastName() + " " + c.getId()));
		 IntStream
		 	.range(1,50)
		 	.forEach(i -> {
		 		try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
		 		System.out.println("Wait for " + i*100 + " milliseconds");
		 	});
		 
	}
	
//	private void put() throws Exception {
//		WebClient webClient = WebClient.create("http://localhost:8080");
//		 RequestBodyUriSpec requestBodyUriSpec = webClient.put();
//		 RequestBodySpec requestBodySpec = requestBodyUriSpec.uri("/customers/5");
//		 ResponseSpec responseSpec = requestBodySpec.retrieve();
//		 System.out.println("Before bodyToFlux put");
//		 Flux<Customer> flux = responseSpec.bodyToFlux(Customer.class);
//		 flux.doOnNext(c -> System.out.println("Getting Customer " + c.getFirstName() + " " + c.getLastName()));
//		 Thread.sleep(2000);
//	}
//	
//	private void put2() throws Exception {
//		WebClient webClient = WebClient.create("http://localhost:8080");
//		 RequestBodyUriSpec requestBodyUriSpec = webClient.put();
//		 RequestBodySpec requestBodySpec = requestBodyUriSpec.uri("/customers/5");
//		 Mono<ClientResponse> clientResponse = requestBodySpec.exchange();
//		 System.out.println("Before bodyToFlux put");
//		 Flux<Customer> flux = clientResponse
//				 .flatMapMany(response -> response.bodyToFlux(Customer.class));
//		 flux.doOnNext(c -> System.out.println("Getting Customer " + c.getFirstName() + " " + c.getLastName()));
//		 Thread.sleep(2000);
//	}
}

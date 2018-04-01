package com.mabellou.spring.flux.websocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.socket.WebSocketHandler;
import org.springframework.web.reactive.socket.WebSocketSession;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mabellou.spring.flux.repository.CustomerRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class ReactiveWebSocketHandler implements WebSocketHandler {

	CustomerRepository customerRepository;
	
	@Autowired
	public ReactiveWebSocketHandler(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}
	
	@Override
	public Mono<Void> handle(WebSocketSession webSocketSession){
		ObjectMapper mapper = new ObjectMapper();
		return webSocketSession
				.send(customerRepository
						.findAll()
						.doOnNext(s -> {
							System.out.println("Socket " + s.getFirstName() + " and wait for 5 sec bitch");
							try {
								Thread.sleep(5000);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						})
						.flatMap(customer -> {
							try {
								return Flux.just(webSocketSession.textMessage(mapper.writeValueAsString(customer)));
							} catch (JsonProcessingException e) {
								System.out.println("Cannot print customer: " + customer);
								return Flux.empty();
							}
						}));
	}
     
}
package com.javasampleapproach.webclient.impl;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import com.javasampleapproach.model.Customer;
import com.javasampleapproach.webclient.WebClientTransport;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class WebClientTransportImpl implements WebClientTransport{
	
	private final WebClient webClient;

    public WebClientTransportImpl(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
        									.baseUrl("http://localhost:8080/api/customer").build();
    }

	@Override
	public Mono<Customer> getById(Long id) {
		
		return this.webClient.get().uri("/{id}", id)
                					.retrieve().bodyToMono(Customer.class);
	}

	@Override
	public Flux<Customer> getAll() {
		
		return webClient.get()
							.retrieve().bodyToFlux(Customer.class);
	}

	@Override
	public Mono<Customer> save(Customer customer) {
		
		return webClient.post().uri("/post")
										.body(BodyInserters.fromObject(customer))
										.exchange().flatMap( clientResponse -> clientResponse.bodyToMono(Customer.class) );
	}

	@Override
	public Mono<Customer> update(Long id, Customer customer) {
		
		return webClient.put().uri("/put/{id}", id)
										.body(BodyInserters.fromObject(customer))
										.exchange().flatMap(clientResponse -> clientResponse.bodyToMono(Customer.class));
	}

	@Override
	public Mono<Void> delete(Long id) {
		
		return webClient.delete().uri("/delete/{id}", id)
										.retrieve().bodyToMono(Void.class);
	}

}

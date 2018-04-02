package com.mabellou.web.functional.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class FunctionalRouting {

	@Bean
	public RouterFunction<ServerResponse> monoRouterFunction(CustomerHandler customerHandler){
		return route(GET("/customers"), customerHandler::getAllCustomers)
				.andRoute(GET("/customer/findbylastname"), customerHandler::findByName)
				.andRoute(PUT("/customers"), customerHandler::createCustomer)
				.andRoute(PUT("/customers/{maxNb}"), customerHandler::createAllCustomer)
				.andRoute(POST("/customers{id}"), customerHandler::updateCustomer)
				.andRoute(DELETE("/customers"), customerHandler::deleteAllCustomers)
				.andRoute(DELETE("/customers/{id}"), customerHandler::deleteCustomer);
	}
}

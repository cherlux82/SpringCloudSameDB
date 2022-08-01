package com.axtel.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

public class Devs4jGatewayConfig {

	@Bean
//	@Profile("localhostRouter-noEureka")
	public RouteLocator configuracionLocalNoErureka(RouteLocatorBuilder builder) {
		return builder.routes().build();
	}
}

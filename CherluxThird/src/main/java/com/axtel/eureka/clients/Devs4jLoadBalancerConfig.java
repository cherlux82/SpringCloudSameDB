package com.axtel.eureka.clients;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Devs4jLoadBalancerConfig {

	private static final Logger log = LoggerFactory.getLogger(Devs4jLoadBalancerConfig.class);

	@Bean
	public ServiceInstanceListSupplier discoveryClientServiceInstanceListSupplier(
			ConfigurableApplicationContext context) {
		log.info("Configuring Load Balancing: {}");
		return ServiceInstanceListSupplier.builder().withBlockingDiscoveryClient().build(context);
	}

}

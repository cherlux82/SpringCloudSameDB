package com.axtel.eureka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.http.ResponseEntity;

import com.axtel.eureka.clients.DragonBallCharacterClient;

@SpringBootApplication
@EnableFeignClients
public class CherluxThirdApplication implements ApplicationRunner {

	private static final Logger log = LoggerFactory.getLogger(CherluxThirdApplication.class);

	@Autowired
	private DragonBallCharacterClient dragonBallCharacterClient; 
//	
//	@Autowired
//	private EurekaClient eurekaClient;

	public static void main(String[] args) {
		SpringApplication.run(CherluxThirdApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		ResponseEntity<String> responseEntity = dragonBallCharacterClient.getApplicationName();
		
		log.info("Status:{}", responseEntity.getStatusCode());
		String body = responseEntity.getBody();
		log.info("Body {}", body);
//		Application application = eurekaClient.getApplication("devs4j-dragon-ball");
//		log.info("Application Name {}", application.getName());
//
//		List<InstanceInfo> instances = application.getInstances();
//
//		for (InstanceInfo instanceInfo : instances) {
//			log.info("IP Address {}:{}", instanceInfo.getIPAddr(), instanceInfo.getPort());
//		}

	}

}

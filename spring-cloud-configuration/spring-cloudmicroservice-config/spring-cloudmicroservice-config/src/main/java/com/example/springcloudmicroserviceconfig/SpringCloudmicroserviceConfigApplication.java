package com.example.springcloudmicroserviceconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class SpringCloudmicroserviceConfigApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudmicroserviceConfigApplication.class, args);
	}

}

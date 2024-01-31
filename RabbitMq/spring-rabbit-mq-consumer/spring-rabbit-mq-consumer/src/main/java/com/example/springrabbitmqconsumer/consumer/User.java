package com.example.springrabbitmqconsumer.consumer;


import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.example.springrabbitmqconsumer.config.MessagingConfig;
import com.example.springrabbitmqconsumer.dto.OrderStatus;



@Component
public class User {

	@RabbitListener(queues = MessagingConfig.QUEUE)
	public void consumeMessageFromQueue(OrderStatus orderStatus) {
		System.out.println("Message recieved from queue : " + orderStatus);
	}
}

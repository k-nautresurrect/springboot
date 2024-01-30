package com.example.microserviceconfig.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.microserviceconfig.dbSetting;

@RestController
public class GreetingController {
	
	@Value("${my.greeting:defaultvalue}")
	private String greetingmessage;
	
	@Value("some static message")
	private String staticMessage;
	
	@Value("${list.values}")
	private List<Integer> listvalues;
	
//	@Value("#{${dbvalues}}")
//	private Map<String,String> dbvalues;
	
	@Autowired
	private dbSetting dbvalue;
	
	
	
	@GetMapping("/")
	public  String greeting() {
		return dbvalue.getHost();
				 
	}

}

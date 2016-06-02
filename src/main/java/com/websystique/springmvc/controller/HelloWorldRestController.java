package com.websystique.springmvc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.websystique.springmvc.domain.Car;
import com.websystique.springmvc.domain.Message;


@Controller
@RequestMapping("/")
public class HelloWorldRestController {

	/*@RequestMapping("/hello/{player}" )
	public Message message(@PathVariable String player) {

		Message msg = new Message(player, "Hello " + player);
		return msg;
	}*/
	@RequestMapping("/test")
	public ResponseEntity<Car> getAgencyResource(HttpEntity<byte[]> requestEntity) 
	{
		
	    String requestHeader = requestEntity.getHeaders().getFirst("MyRequestHeader");
	    byte[] requestBody = requestEntity.getBody();
	    
	    HttpHeaders responseHeaders = new HttpHeaders();
	    responseHeaders.set("MyResponseHeader", "MyValue");
	    
	    Car car = new Car();
	    car.setColor("Blue");
	    car.setMiles(100);
	    car.setVIN("1234");

	    return new ResponseEntity<Car>(car, HttpStatus.OK);
	    
	   /* ResponseEnity<AgencyResource> resources = new ArrayList<AgencyResource>();
	    resources.add(new AgencyResource(1, "All State", "123"));
	    resources.add(new AgencyResource(2, "FCCI Insurance Group", "456"));
	    resources.add(new AgencyResource(3, "Farmers", "789"));
	    resources.add(new AgencyResource(4, "Met life", "167"));
	    return resources;*/

	}
}

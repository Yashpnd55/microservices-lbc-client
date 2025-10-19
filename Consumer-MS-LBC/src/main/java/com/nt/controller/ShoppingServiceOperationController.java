package com.nt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.client.BillingServiceConsumerClient;

@RestController
@RequestMapping("/shopping")
public class ShoppingServiceOperationController {
	
	@Autowired
	private BillingServiceConsumerClient client;
	
	@GetMapping("/cart")
	public ResponseEntity<String> doShopping() {
		String res = client.getBillingInfo();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return new ResponseEntity<String>("Shopping the item(shirt, trouser)::: " + res,HttpStatus.OK);
	}
	
	
}

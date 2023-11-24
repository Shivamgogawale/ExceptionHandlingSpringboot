package com.exceptionhandler.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.exceptionhandler.entity.Customer;
import com.exceptionhandler.request.CustomerRequest;
import com.exceptionhandler.service.CustomerService;

@RestController
public class ExcepController {

	private static final Logger logger=LoggerFactory.getLogger(CustomerService.class);

	
	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/saveCustomer")
	public ResponseEntity<Customer> saveCustomer(@RequestBody CustomerRequest customerRequest)
	{
		logger.info("ExcepController.saveCustomer() is start");
		
		Customer saveCustomer = customerService.saveCustomer(customerRequest);
		return new ResponseEntity<>(saveCustomer,HttpStatus.OK);
	}
	
	
	@GetMapping("/getAllCust")
	public ResponseEntity<List<Customer>> getAllCust()
	{
		List<Customer> allCustomer = customerService.getAllCustomer();
		return new ResponseEntity<List<Customer>>(allCustomer,HttpStatus.OK);
	}
	
	@GetMapping("/getCustomer/{id}")
	public ResponseEntity<Customer> getCustById(@RequestParam int id)
	{
		Customer customer = customerService.getCustomer(id);
		return new ResponseEntity<Customer>(customer,HttpStatus.OK);
	}
}

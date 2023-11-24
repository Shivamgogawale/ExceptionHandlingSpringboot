package com.exceptionhandler.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exceptionhandler.dao.CustomerRepository;
import com.exceptionhandler.entity.Customer;
import com.exceptionhandler.request.CustomerRequest;


@Service
public class CustomerService {

	@Autowired
	CustomerRepository customerRepository;
	
	private static final Logger logger=LoggerFactory.getLogger(CustomerService.class);
	
	public Customer saveCustomer(CustomerRequest customerRequest)
	{
		logger.info("CustomerService.saveCustomer() is start");
		Customer customer=Customer.build(0,customerRequest.getName(),customerRequest.getAddress(),customerRequest.getAge(),customerRequest.getContactNumber());
		Customer saveCustomer = customerRepository.save(customer);
		logger.info("CustomerService.saveCustomer() is end",saveCustomer);
		return saveCustomer;
	}
	
	 public List<Customer> getAllCustomer()
	 {
			logger.info("CustomerService.getAllCustomer() is start");
		 return customerRepository.findAll();
	 }
	 
	 public Customer getCustomer(int id)
	 {
			logger.info("CustomerService.getCustomer() is start");
		 return customerRepository.findById(id);
	 }
}

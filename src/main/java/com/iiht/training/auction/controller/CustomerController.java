package com.iiht.training.auction.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iiht.training.auction.dto.CustomerDto;
import com.iiht.training.auction.exceptions.InvalidDataException;
import com.iiht.training.auction.service.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {

	private CustomerService customerService;

	@PostMapping("/register")
	public ResponseEntity<?> registerCustomer(@RequestBody CustomerDto customerDto, BindingResult result) {
		if (result.hasErrors()) {
			throw new InvalidDataException("Customer data is not Valid!");
		}
		customerService.registerCustomer(customerDto);
		return ResponseEntity.ok(customerDto);
	}

	@PutMapping("/update")
	public ResponseEntity<?> updateCustomer(@Valid @RequestBody CustomerDto customerDto, BindingResult result) {
		if (result.hasErrors()) {
			throw new InvalidDataException("Customer data is not Valid!");
		}
		customerService.updateCustomer(customerDto);
		return ResponseEntity.ok(customerDto);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteCustomer(@PathVariable Long id) {
		customerService.deleteCustomer(id);
		return ResponseEntity.ok(false);
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<?> getCustomerById(@PathVariable Long id) {
		CustomerDto customer = customerService.getCustomerById(id);
		return ResponseEntity.ok(customer);
	}

	@GetMapping("/get/all")
	public ResponseEntity<?> getAllCustomers() {
		List<CustomerDto> customers = null;
		return ResponseEntity.ok(customers);
	}

}

package com.netsmartz.springsecurity.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netsmartz.springsecurity.model.Customer;
import com.netsmartz.springsecurity.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	@Autowired
	   RestTemplate template;

	@PostMapping("/insert")
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
		try {
			if (customer == null) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		customerService.addCustomer(customer);
		return ResponseEntity.of(Optional.of(customer));
	}
	
//	 @GetMapping("/handle")
//	 public void handle(RequestEntity<String> request) throws URISyntaxException{
//	   HttpMethod method = request.getMethod();
//	   URI url = request.getUrl();
//	   
//	   String body = request.getBody();
//	   
//			   RequestEntity <String> request1 = RequestEntity
//			       .post(new URI("http://localhost:8080/getAll"))
//			       .accept(MediaType.APPLICATION_JSON)
//			       .body(body);
//			ResponseEntity<Customer> response = template.exchange(request, Customer.class);
//			   
//
//	   
//	   System.out.println(request);
//	 }

	@GetMapping("/getAll")
	public ResponseEntity<List<Customer>> getAll() {
		List<Customer> list = customerService.getAll();
		if (list.size() <= 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(list));
	}

	@GetMapping("/getId/{id}")
	public ResponseEntity<Customer> getCustomer(@PathVariable int id) {
		Customer customer = customerService.getCustomer(id);
		if (customer == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(customer));
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteCustomer(@PathVariable int id) {
		try {
			customerService.deleteCustomer(id);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}

	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable int id, @RequestBody Customer customer) {
		Customer customer2 = null;
		try {
			customer2 = customerService.updateCustomer(id, customer);
			return ResponseEntity.ok().body(customer2);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}

	}

}

package PedidoPJa.APIOrder.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import PedidoPJa.APIOrder.modal.Customer;
import PedidoPJa.APIOrder.service.interfaces.ICustomerService;

@RestController
@RequestMapping(value = "api/Cliente")
public class CustomerController {

	private final ICustomerService serviceCustomer;
	
	public CustomerController(ICustomerService serviceCustomer) {
		this.serviceCustomer = serviceCustomer;
	}
	
	@GetMapping()
	public Collection<Customer> AllCustomers() {
		return this.serviceCustomer.LookAll();
	}
	
	@PostMapping()
	public void addCustomer(@RequestBody Customer customer) {
		 this.serviceCustomer.AddCustomer(customer);
	}
	
	@PutMapping("/{id}")
	public Customer EditCustomer(@RequestBody Customer customer, @PathVariable long id) {
		return this.serviceCustomer.EditCustumer(customer, id);
	}
	
	@DeleteMapping("/{id}")
	public void remove(long id) {
		this.serviceCustomer.DeleteCustomerById(id);
	}
	
	
}


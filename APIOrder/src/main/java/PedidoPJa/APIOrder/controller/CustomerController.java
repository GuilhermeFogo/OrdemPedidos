package PedidoPJa.APIOrder.controller;

import java.util.Collection;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import PedidoPJa.APIOrder.dominio.modal.Customer;
import PedidoPJa.APIOrder.service.interfaces.ICustomerService;

@RestController
@RequestMapping(value = "api/Cliente")
public class CustomerController {

	private final ICustomerService serviceCustomer;
	
	public CustomerController(ICustomerService serviceCustomer) {
		this.serviceCustomer = serviceCustomer;
	}
	
	@GetMapping()
	public ResponseEntity<Collection<Customer>> AllCustomers() {
		return ResponseEntity.ok(this.serviceCustomer.LookAll());
	}
	@GetMapping("/{id}")
	public ResponseEntity<Customer> LookOnlyCustomer(@PathVariable long id){
		var customer = this.serviceCustomer.FindCustomers(id);
		
		if(customer == null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(customer);
	}
	
	@PostMapping()
	@ResponseStatus(HttpStatus.CREATED)
	public Customer addCustomer(@Valid @RequestBody Customer customer) {
		 return this.serviceCustomer.AddCustomer(customer);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Customer> EditCustomer(@Valid @RequestBody Customer customer, @PathVariable long id) {
		var cust = this.serviceCustomer.EditCustumer(customer, id);
		if(cust == null) {
			return ResponseEntity.notFound().build();
		}else {
			return ResponseEntity.ok(cust);
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> remove(@PathVariable long id) {
		this.serviceCustomer.DeleteCustomerById(id);
		return ResponseEntity.noContent().build();
	}
	
	
}


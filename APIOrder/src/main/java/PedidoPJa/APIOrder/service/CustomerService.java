package PedidoPJa.APIOrder.service;


import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import PedidoPJa.APIOrder.modal.Customer;
import PedidoPJa.APIOrder.repository.IRepositoryCustomer;
import PedidoPJa.APIOrder.service.interfaces.ICustomerService;

@Service
public class CustomerService implements ICustomerService {

	private IRepositoryCustomer respository;
	@Autowired
	public CustomerService(IRepositoryCustomer respository) {
		this.respository = respository;
	}
	
	
	@Override
	public Collection<Customer> LookAll() {
		return this.respository.findAll();
	}

	@Override
	public void AddCustomer(Customer customer) {
		this.respository.save(customer);
		
	}

	@Override
	public Customer EditCustumer(Customer newCustomer, long id) {
		return this.respository.findById(id).map(customer -> {
			customer.setEmail(newCustomer.getEmail());
			customer.setName(newCustomer.getName());
			customer.setPhone(customer.getPhone());
			return this.respository.save(customer);
		}).orElseGet(()->{
			
			newCustomer.setId(id);
	        return this.respository.save(newCustomer);
		});
	}

	@Override
	public void DeleteCustomerById(long id) {
		this.respository.deleteById(id);
		
	}
	
}

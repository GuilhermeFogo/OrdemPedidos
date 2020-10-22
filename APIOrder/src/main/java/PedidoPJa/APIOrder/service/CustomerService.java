package PedidoPJa.APIOrder.service;


import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import PedidoPJa.APIOrder.dominio.exeption.BussinesExeption;
import PedidoPJa.APIOrder.dominio.modal.Customer;
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
	public Customer AddCustomer(Customer customer) {
		var ExistCustomer = this.respository.findByEmail(customer.getEmail());
		
		if(ExistCustomer !=null && !ExistCustomer.equals(customer)) {
			throw new BussinesExeption("Já existe um cliente com o memso email");
		}
		return this.respository.save(customer);
		
		
	}

	@Override
	public Customer EditCustumer(Customer newCustomer, long id) {
		if(!this.respository.existsById(id)) {
			return null;
		}
		
		return this.respository.findById(id).map(customer -> {
			customer.setEmail(newCustomer.getEmail());
			customer.setName(newCustomer.getName());
			customer.setPhone(newCustomer.getPhone());
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


	@Override
	public Customer FindCustomers(long id) {
		var opCliente = this.respository.findById(id);
		if(opCliente.isPresent()) {
			return opCliente.get();
		}else {
			return null;
		}
	}
	
}

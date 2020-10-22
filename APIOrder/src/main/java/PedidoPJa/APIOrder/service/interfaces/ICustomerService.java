package PedidoPJa.APIOrder.service.interfaces;

import java.util.Collection;

import PedidoPJa.APIOrder.dominio.modal.Customer;

public interface ICustomerService {
	Collection<Customer> LookAll();
	
	Customer FindCustomers(long id);
	
	Customer AddCustomer(Customer customer);

	Customer EditCustumer(Customer newCustomer, long id);

	void DeleteCustomerById(long id);
}

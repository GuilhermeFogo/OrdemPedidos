package PedidoPJa.APIOrder.service.interfaces;

import java.util.Collection;

import PedidoPJa.APIOrder.modal.Customer;


public interface ICustomerService {
	Collection<Customer> LookAll();

	void AddCustomer(Customer customer);

	Customer EditCustumer(Customer newCustomer, long id);

	void DeleteCustomerById(long id);
}

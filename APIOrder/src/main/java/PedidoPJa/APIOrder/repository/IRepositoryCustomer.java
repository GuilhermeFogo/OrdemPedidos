package PedidoPJa.APIOrder.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import PedidoPJa.APIOrder.modal.Customer;

public interface IRepositoryCustomer extends JpaRepository<Customer, Long> {
	
}

package PedidoPJa.APIOrder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import PedidoPJa.APIOrder.dominio.modal.Customer;

@Repository
public interface IRepositoryCustomer extends JpaRepository<Customer, Long> {
	Customer findByEmail(String email);
}

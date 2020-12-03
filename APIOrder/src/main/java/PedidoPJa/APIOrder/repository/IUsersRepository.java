package PedidoPJa.APIOrder.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import PedidoPJa.APIOrder.dominio.modal.Users;

@Repository
public interface IUsersRepository extends JpaRepository<Users, Long> {
	Users findByNameAndPasswordAndRole(String nome, String password, String role);
	Users findByPassword(String pass);
	Users findByNameAndPassword(String name, String pass);
	Optional<Users> findByName(String nome);
}

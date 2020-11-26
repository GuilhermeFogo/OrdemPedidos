package PedidoPJa.APIOrder.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import PedidoPJa.APIOrder.dominio.modal.Commet;

public interface ICommentRepository extends JpaRepository<Commet, Long> {

}

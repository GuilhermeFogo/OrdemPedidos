package PedidoPJa.APIOrder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import PedidoPJa.APIOrder.dominio.modal.Demand;
import PedidoPJa.APIOrder.model.DemandModel;

@Repository
public interface IDemandRepository extends JpaRepository<Demand, Long> {

}

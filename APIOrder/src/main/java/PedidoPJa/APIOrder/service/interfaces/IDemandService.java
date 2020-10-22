package PedidoPJa.APIOrder.service.interfaces;

import java.util.Collection;

import PedidoPJa.APIOrder.dominio.modal.Demand;

public interface IDemandService {
	Collection<Demand> LookAll();

	Demand FindOrder(long id);

	void AddOrder(Demand order);

	Demand UpdateOrder(Demand order, long id);

	void DeleteOrder(long id);
}

package PedidoPJa.APIOrder.service.interfaces;

import java.util.Collection;

import PedidoPJa.APIOrder.dominio.modal.Demand;
import PedidoPJa.APIOrder.model.DemandInputModel;
import PedidoPJa.APIOrder.model.DemandModel;

public interface IDemandService {
	Collection<DemandModel> LookAll();

	DemandModel FindOrder(long id);

	DemandModel AddOrder(DemandInputModel order);

	DemandModel UpdateOrder(DemandInputModel order, long id);

	void DeleteOrder(long id);
}

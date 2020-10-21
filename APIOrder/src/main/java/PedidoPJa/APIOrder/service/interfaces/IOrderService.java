package PedidoPJa.APIOrder.service.interfaces;

import java.util.Collection;

import PedidoPJa.APIOrder.modal.Order;

public interface IOrderService {
	Collection<Order> LookAll();
	void AddOrder(Order order);
	Order UpdateOrder(Order order, long id);
	void DeleteOrder(long id);
}

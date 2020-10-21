package PedidoPJa.APIOrder.service;

import java.util.Collection;

import org.springframework.stereotype.Service;

import PedidoPJa.APIOrder.modal.Order;
import PedidoPJa.APIOrder.service.interfaces.IOrderService;

@Service
public class OrderService implements IOrderService {

	@Override
	public Collection<Order> LookAll() {
		return null;
	}

	@Override
	public void AddOrder(Order order) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Order UpdateOrder(Order order, long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void DeleteOrder(long id) {
		// TODO Auto-generated method stub
		
	}

}

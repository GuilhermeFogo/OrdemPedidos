package PedidoPJa.APIOrder.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import PedidoPJa.APIOrder.dominio.modal.Customer;
import PedidoPJa.APIOrder.dominio.modal.Demand;
import PedidoPJa.APIOrder.repository.IDemandRepository;
import PedidoPJa.APIOrder.service.interfaces.IDemandService;

@Service
public class DemandService implements IDemandService {

	private IDemandRepository repository;

	@Autowired
	public DemandService(IDemandRepository repository) {
		this.repository = repository;
	}

	@Override
	public Collection<Demand> LookAll() {
		return this.repository.findAll();
	}

	@Override
	public void AddOrder(Demand order) {
		this.repository.save(order);
	}

	@Override
	public Demand UpdateOrder(Demand neworder, long id) {
		if (!this.repository.existsById(id)) {
			var customerNull = new Customer();
			customerNull.setId(-1L);
			return neworder;
		}

		return this.repository.findById(id).map(order -> {
			order.setDescricao(neworder.getDescricao());
			order.setPrice(neworder.getPrice());
			order.setStatus(neworder.getStatus());
			order.setEndDay(neworder.getEndDay());
			order.setOpenDay(neworder.getOpenDay());
			return this.repository.save(order);
		}).orElseGet(() -> {

			neworder.setId(id);
			return this.repository.save(neworder);
		});
	}

	@Override
	public void DeleteOrder(long id) {
		
	}

	@Override
	public Demand FindOrder(long id) {
		var opDemand = this.repository.findById(id);
		if(opDemand.isPresent()) {
			return opDemand.get();
		}
		return null;
	}
}

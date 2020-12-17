package PedidoPJa.APIOrder.service;

import java.time.OffsetDateTime;
import java.util.Collection;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import PedidoPJa.APIOrder.dominio.exeption.BussinesExeption;
import PedidoPJa.APIOrder.dominio.modal.Customer;
import PedidoPJa.APIOrder.dominio.modal.Demand;
import PedidoPJa.APIOrder.dominio.modal.StatusOrder;
import PedidoPJa.APIOrder.model.DemandInputModel;
import PedidoPJa.APIOrder.model.DemandModel;
import PedidoPJa.APIOrder.repository.IDemandRepository;
import PedidoPJa.APIOrder.repository.IRepositoryCustomer;
import PedidoPJa.APIOrder.service.interfaces.IDemandService;

@Service
public class DemandService implements IDemandService {

	private IDemandRepository repository;
	private IRepositoryCustomer repositoryCustomer;

	@Autowired
	private ModelMapper modalmaaper;
	
	@Autowired
	public DemandService(IDemandRepository repository, IRepositoryCustomer repositoryCustomer) {
		this.repository = repository;
		this.repositoryCustomer = repositoryCustomer;
	}

	@Override
	public Collection<DemandModel> LookAll() {
		return toModalCollection(this.repository.findAll());
	}

	@Override
	public DemandModel AddOrder(DemandInputModel order) {
		Demand myDemand = new Demand();
		Customer customer = this.repositoryCustomer.findById(order.getId_customer())
				.orElseThrow(()-> new BussinesExeption("Cliente não encontrado"));
		myDemand.setId(0L);
		myDemand.setCustomer(customer);
		myDemand.setStatus(StatusOrder.Open);
		myDemand.setOpenDay(OffsetDateTime.now());
		myDemand.setPrice(order.getPrice());
		myDemand.setDescricao(order.getDescricao());
		
		return toModal(this.repository.save(myDemand));
		
	}

	public DemandModel UpdateOrder(DemandInputModel neworder, long id) {
		if (this.repository.existsById(id)) {
			Demand demand = this.repository.findById(id).get();
			demand.setDescricao(neworder.getDescricao());
			demand.setPrice(neworder.getPrice());
			return toModal(this.repository.save(demand));
		}
		return null;
	}
	
	public DemandModel CloseOrder(DemandInputModel neworder, long id) {
		if (this.repository.existsById(id)) {
			Demand demand = this.repository.findById(id).get();
			demand.setStatus(StatusOrder.Finish);
			demand.setEndDay(OffsetDateTime.now());
			return toModal(this.repository.save(demand));
		}
		return null;
	}

	@Override
	public void DeleteOrder(long id) {
		this.repository.deleteById(id);
	}

	@Override
	public DemandModel FindOrder(long id) {
		var opDemand = this.repository.findById(id).orElseThrow(()-> new BussinesExeption("Pedido não encontrado"));
		DemandModel demandModel = toModal(opDemand);
		return demandModel;
	}
	
	
	private DemandModel toModal(Demand demand) {
		return modalmaaper.map(demand, DemandModel.class);
	}
	
	private Collection<DemandModel> toModalCollection(Collection<Demand> list){
		return list.stream()
				.map(ordem -> toModal(ordem))
				.collect(Collectors.toList());
	}
	
	
	private Demand toEntity(DemandInputModel input) {
		return modalmaaper.map(input, Demand.class);
	}
	
}

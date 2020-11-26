package PedidoPJa.APIOrder.service;

import java.time.OffsetDateTime;
import java.util.Collection;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import PedidoPJa.APIOrder.config.ModalMapperConfig;
import PedidoPJa.APIOrder.dominio.exeption.BussinesExeption;
import PedidoPJa.APIOrder.dominio.modal.Commet;
import PedidoPJa.APIOrder.dominio.modal.Customer;
import PedidoPJa.APIOrder.dominio.modal.Demand;
import PedidoPJa.APIOrder.dominio.modal.StatusOrder;
import PedidoPJa.APIOrder.model.CommetInputModel;
import PedidoPJa.APIOrder.model.DemandInputModel;
import PedidoPJa.APIOrder.model.DemandModel;
import PedidoPJa.APIOrder.repository.ICommentRepository;
import PedidoPJa.APIOrder.repository.IDemandRepository;
import PedidoPJa.APIOrder.service.interfaces.ICommetService;

@Service
public class CommetService implements ICommetService {

	private ICommentRepository commetRepository;
	private IDemandRepository demandRepository;
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	public CommetService(ICommentRepository commetRepository, IDemandRepository demandRepository) {
		this.commetRepository = commetRepository;
		this.demandRepository =  demandRepository;
	}
	
	@Override
	public Collection<CommetInputModel> LookALL(){
		return toModalCollection(this.commetRepository.findAll());
	}
	
	@Override
	public CommetInputModel addComment(CommetInputModel commet, Long id) {
		Commet myDescription = toEntity(commet);
		Demand demand = this.demandRepository.findById(id)
				.orElseThrow(()-> new BussinesExeption("Pedido não encontrado"));
		
		myDescription.setDemand(demand);
		myDescription.setDate(OffsetDateTime.now());
		
		return toModal(this.commetRepository.save(myDescription));
	}
	
	
	
	@Override
	public CommetInputModel LookCommensts(Long id) {
		Commet commits = this.commetRepository.findById(id).
				orElseThrow(()-> new BussinesExeption("Ordem de serviço não encontrada"));
		return toModal(commits);
	}
	
	
	
	private CommetInputModel toModal(Commet comment) {
		return mapper.map(comment, CommetInputModel.class);
	}
	
	private Collection<CommetInputModel> toModalCollection(Collection<Commet> list){
		return list.stream()
				.map(ordem -> toModal(ordem))
				.collect(Collectors.toList());
	}
	
	
	private Commet toEntity(CommetInputModel input) {
		return mapper.map(input, Commet.class);
	}

}

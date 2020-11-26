package PedidoPJa.APIOrder.service.interfaces;

import java.util.Collection;

import PedidoPJa.APIOrder.model.CommetInputModel;

public interface ICommetService {

	Collection<CommetInputModel> LookALL();
	CommetInputModel LookCommensts(Long id);
	CommetInputModel addComment(CommetInputModel commet, Long id);
}

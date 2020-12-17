package PedidoPJa.APIOrder.service.interfaces;

import java.util.Collection;

import PedidoPJa.APIOrder.model.CommetInputModel;
import PedidoPJa.APIOrder.model.CommetModel;

public interface ICommetService {

	Collection<CommetModel> LookALL();
	CommetModel LookCommensts(Long id);
	CommetModel addComment(CommetInputModel commet, Long id);
}

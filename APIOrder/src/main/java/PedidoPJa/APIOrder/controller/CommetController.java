package PedidoPJa.APIOrder.controller;

import java.util.Collection;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import PedidoPJa.APIOrder.dominio.modal.Commet;
import PedidoPJa.APIOrder.model.CommetInputModel;
import PedidoPJa.APIOrder.service.interfaces.ICommetService;

@RestController
@RequestMapping(value = "/api/Pedidos/{ordemServicoId}/comentarios")
public class CommetController {
	
	@Autowired
	private ICommetService commetService;
	
	
	@GetMapping()
	public CommetInputModel listar(@PathVariable Long ordemServicoId){
		return this.commetService.LookCommensts(ordemServicoId);
	}
	
	@PostMapping()
	public CommetInputModel AddComments(@PathVariable Long ordemServicoId, @Valid @RequestBody CommetInputModel comentario) {
		return this.commetService.addComment(comentario, ordemServicoId);
	}
	
}
package PedidoPJa.APIOrder.controller;

import java.util.Collection;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import PedidoPJa.APIOrder.dominio.modal.Commet;
import PedidoPJa.APIOrder.model.CommetInputModel;
import PedidoPJa.APIOrder.model.CommetModel;
import PedidoPJa.APIOrder.service.interfaces.ICommetService;

@RestController
@RequestMapping(value = "/api/Pedidos/{ordemServicoId}/comentarios")
public class CommetController {
	
	@Autowired
	private ICommetService commetService;
	
	
	@GetMapping("/listagem")
	public ResponseEntity<Collection<CommetModel>> Listagem(){
		return ResponseEntity.ok(this.commetService.LookALL()); 
	}
	
	@GetMapping()
	public ResponseEntity<CommetModel> LookOnecommit(@PathVariable Long ordemServicoId){
		var commit =this.commetService.LookCommensts(ordemServicoId);
		return ResponseEntity.ok(commit);
	}
	
	@PostMapping()
	@ResponseStatus(HttpStatus.CREATED)
	public CommetModel AddComments(@PathVariable Long ordemServicoId, 
			@Valid @RequestBody CommetInputModel comentario) {
		return this.commetService.addComment(comentario, ordemServicoId);
	}
	
}

package PedidoPJa.APIOrder.controller;

import java.util.Collection;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import PedidoPJa.APIOrder.dominio.modal.Users;
import PedidoPJa.APIOrder.model.UserModal;
import PedidoPJa.APIOrder.service.interfaces.IUserService;

@RestController
@RequestMapping(value = "/api/Users")
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:3000"})
public class UserController {
	
	@Autowired
	private IUserService servico;
	
	@GetMapping()
	public ResponseEntity<Collection<UserModal>> listar(){
		return ResponseEntity.ok(this.servico.LookAllUsers());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UserModal> listar(@Valid @PathVariable Long id){
		var user = this.servico.FindUser(id);
		if(user == null) {
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok(user);
	}
}

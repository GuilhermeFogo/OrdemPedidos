package PedidoPJa.APIOrder.controller;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import PedidoPJa.APIOrder.dominio.modal.Demand;
import PedidoPJa.APIOrder.service.interfaces.IDemandService;

@RestController
@RequestMapping("/api/Pedidos")
public class DemandController {
	
	private IDemandService service;
	public DemandController(IDemandService service) {
		this.service = service;
	}
	
	@GetMapping()
	public ResponseEntity<Collection<Demand>> LookAllOrders() {
		return ResponseEntity.ok(this.service.LookAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Demand> LookOnlyDemand(@PathVariable long id) {
		var a = this.service.FindOrder(id);
		
		
		return ResponseEntity.ok(a);
	}
	
	@PostMapping()
	@ResponseStatus(HttpStatus.CREATED)
	public void addOrder(@Valid @RequestBody Demand order) {
		this.service.AddOrder(order);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Demand> updateOrder(@Valid @RequestBody Demand order, @PathVariable long id) {
		var oneOrder = this.service.UpdateOrder(order, id);
		if(oneOrder.getId().equals(-1L)) {
			return ResponseEntity.badRequest().build();
		}
		
		return ResponseEntity.ok(oneOrder);		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteOrder(@PathVariable long id) {
		this.service.DeleteOrder(id);
		return ResponseEntity.noContent().build();
	}
}

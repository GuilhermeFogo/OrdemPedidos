package PedidoPJa.APIOrder.controller;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import PedidoPJa.APIOrder.model.DemandInputModel;
import PedidoPJa.APIOrder.model.DemandModel;
import PedidoPJa.APIOrder.service.interfaces.IDemandService;

@RestController
@RequestMapping("/api/Pedidos")
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:3000"})
public class DemandController {
	
	private IDemandService service;
	public DemandController(IDemandService service) {
		this.service = service;
	}
	
	@GetMapping()
	public ResponseEntity<Collection<DemandModel>> LookAllOrders() {
		return ResponseEntity.ok(this.service.LookAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<DemandModel> LookOnlyDemand(@PathVariable long id) {
		var a = this.service.FindOrder(id);
		return ResponseEntity.ok(a);
	}
	
	@PostMapping()
	@ResponseStatus(HttpStatus.CREATED)
	public DemandModel addOrder(@Valid @RequestBody DemandInputModel order) {
		return this.service.AddOrder(order);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<DemandModel> updateOrder(@Valid @RequestBody DemandInputModel order, @PathVariable long id) {
		var oneOrder = this.service.UpdateOrder(order, id);
		if(oneOrder == null) {
			return ResponseEntity.badRequest().build();
		}
		
		return ResponseEntity.ok(oneOrder);		
	}
	
	@PutMapping("/{id}/finaliza")
	public ResponseEntity<DemandModel> CloseOrder(@Valid @RequestBody DemandInputModel order, @PathVariable long id) {
		var oneOrder = this.service.CloseOrder(order, id);
		if(oneOrder == null) {
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

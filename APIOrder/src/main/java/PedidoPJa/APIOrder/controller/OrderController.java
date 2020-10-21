package PedidoPJa.APIOrder.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import PedidoPJa.APIOrder.modal.Order;

@RestController
@RequestMapping("/api/Order")
public class OrderController {
	
	public OrderController() {
		// TODO Auto-generated constructor stub
	}
	
	@GetMapping()
	public void LookAllOrders() {
		
	}
	
	@PostMapping()
	public void addOrder(@RequestBody Order order) {
		
	}
	
	@PutMapping()
	public void updateOrder(@RequestBody Order order, @PathVariable long id) {
		
	}
	
	@DeleteMapping()
	public void deleteOrder() {
		
	}
}

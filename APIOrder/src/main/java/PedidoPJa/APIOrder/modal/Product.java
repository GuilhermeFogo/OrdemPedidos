package PedidoPJa.APIOrder.modal;

import javax.persistence.Entity;

import lombok.Data;

@Entity
@Data
public class Product {
	private String id;
	private String name;
	private String price;
	
	
	public Product(String id, String name, String price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}
	public Product() {
		
	}
}

package PedidoPJa.APIOrder.modal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String name;
	private String price;
	
	
	public Product(Long id, String name, String price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}
	public Product() {
		
	}
}

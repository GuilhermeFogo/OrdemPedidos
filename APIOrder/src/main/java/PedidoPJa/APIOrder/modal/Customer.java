package PedidoPJa.APIOrder.modal;

import javax.persistence.Entity;

import lombok.Data;

@Entity
@Data
public class Customer extends People {
	private Long id;
	
	public Customer(Long id, String name, String email, String tel) {
		super(name,email, tel);
		this.id = id;
	}
	
	public Customer() { }
}

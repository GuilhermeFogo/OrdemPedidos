package PedidoPJa.APIOrder.modal;

import javax.persistence.Entity;

import lombok.Data;

@Entity
@Data
public abstract class People {
	private String name;
	private String email;
	private String phone;
	
	public People(String name, String email, String phone) {
		this.email = email;
		this.name = name;
		this.phone = phone;
	}
	
	public People() {
		
	}
}

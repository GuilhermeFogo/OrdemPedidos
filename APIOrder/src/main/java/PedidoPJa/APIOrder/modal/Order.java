package PedidoPJa.APIOrder.modal;


import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;

import lombok.Data;

@Entity
@Data
public class Order {
	private String id;
	private String currentDay;
	private String endDay;
	private String emissor;
	
	public Order(String id, Date cuurentDay, Date endDay, String emissor) {
		var formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		this.id = id;
		this.emissor = emissor;
		
	}
	
	
}

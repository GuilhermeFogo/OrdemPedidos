package PedidoPJa.APIOrder.modal;


import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Order {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String currentDay;
	private String endDay;
	private String emissor;
	
	public Order(Long id, Date endDay, String emissor) {
		var formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		this.id = id;
		this.emissor = emissor;
		this.currentDay = formatter.format(new Date());
		this.endDay = formatter.format(endDay);
		
	}
	
}

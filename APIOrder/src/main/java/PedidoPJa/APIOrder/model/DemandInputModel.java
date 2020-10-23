package PedidoPJa.APIOrder.model;

import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class DemandInputModel {
	
	
	private String descricao;
	
	
	private BigDecimal price;
	
	
	private Long idCustomer;
}

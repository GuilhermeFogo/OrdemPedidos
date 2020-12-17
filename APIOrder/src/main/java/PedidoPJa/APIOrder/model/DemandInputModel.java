package PedidoPJa.APIOrder.model;

import java.math.BigDecimal;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import PedidoPJa.APIOrder.dominio.modal.Customer;
import lombok.Data;

@Data
public class DemandInputModel {
	
	
	private String descricao;
	
	
	private BigDecimal price;
	
//	@Valid
//	private CustomerIdInput idcustomer;
	private Long id_customer;
}

package PedidoPJa.APIOrder.model;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class CommetInputModel {
	@NotBlank
	private String description;
	
}

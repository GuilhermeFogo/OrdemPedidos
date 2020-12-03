package PedidoPJa.APIOrder.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class UserModal {
	@NotBlank
	@NotNull
	private String name;
	@NotNull
	@NotBlank
	private String password;
}

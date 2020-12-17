package PedidoPJa.APIOrder.dominio.modal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Entity
@Data
@Table(name = "Usuario")
public class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_Usuario")
	@SequenceGenerator(initialValue = 1, name = "SEQ_Usuario")
	private Long id;
	
	private String name;
	
	private String password;
	
	private String role;
}

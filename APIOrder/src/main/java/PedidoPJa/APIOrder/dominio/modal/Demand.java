package PedidoPJa.APIOrder.dominio.modal;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import javax.validation.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Pedido")
public class Demand {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "SEQ_Pedido")
	@SequenceGenerator(initialValue = 1, name = "SEQ_Pedido")
	private Long id;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="id_cliente")
	private Customer customer;
	
	@NotBlank
	private String descricao;
	
	@NotNull
	private BigDecimal price;
	
	@Enumerated(EnumType.STRING)
	private StatusOrder status;
	
	@Column(name = "data_inicio")
	private OffsetDateTime openDay;
	
	@Column(name = "data_fim")
	private OffsetDateTime endDay;
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Demand other = (Demand) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	
	
	
	
	
}

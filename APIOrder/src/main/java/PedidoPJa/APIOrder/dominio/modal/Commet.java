package PedidoPJa.APIOrder.dominio.modal;

import java.time.OffsetDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "Comentario")
public class Commet {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_Comentario")
	@SequenceGenerator(initialValue = 1, name = "SEQ_Comentario")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="id_pedido")
	private Demand demand;
	
	private String description;
	private OffsetDateTime date;
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Commet other = (Commet) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}

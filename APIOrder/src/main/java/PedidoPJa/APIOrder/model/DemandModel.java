package PedidoPJa.APIOrder.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import PedidoPJa.APIOrder.dominio.modal.StatusOrder;
import lombok.Data;

@Data
public class DemandModel {
	private CustomerModel customer;
	private String descricao;
	private BigDecimal price;
	private StatusOrder status;
	private Long id;
	private OffsetDateTime openDay;
	private OffsetDateTime endDay;
}

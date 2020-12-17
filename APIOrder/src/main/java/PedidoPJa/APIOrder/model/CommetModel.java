package PedidoPJa.APIOrder.model;

import java.time.OffsetDateTime;

import lombok.Data;

@Data
public class CommetModel {
	private Long id;
	private String descricao;
	private OffsetDateTime dataEnvio;
}

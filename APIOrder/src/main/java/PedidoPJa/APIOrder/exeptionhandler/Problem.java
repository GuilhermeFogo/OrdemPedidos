package PedidoPJa.APIOrder.exeptionhandler;

import java.time.OffsetDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class Problem {
	
	private Integer status;
	private OffsetDateTime dateHour;
	private String title;
	private List<Campo> campos;
	
	public static class Campo{
		private String nome;
		private String mensagem;
		
		public Campo(String nome2, String msg) {
			this.nome = nome2;
			this.mensagem = msg;
		}
		
		public String getMensagem() {
			return mensagem;
		}
		
		public String getNome() {
			return nome;
		}

		
	}

	
}

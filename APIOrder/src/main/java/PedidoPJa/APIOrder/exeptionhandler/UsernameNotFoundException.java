package PedidoPJa.APIOrder.exeptionhandler;

public class UsernameNotFoundException extends RuntimeException {
	public UsernameNotFoundException() {
		
	}
	
	public UsernameNotFoundException(String mensagem) {
		super(mensagem);
	}
}

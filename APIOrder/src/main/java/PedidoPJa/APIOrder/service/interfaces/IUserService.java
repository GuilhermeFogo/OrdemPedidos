package PedidoPJa.APIOrder.service.interfaces;

import java.util.Collection;
import java.util.List;

import PedidoPJa.APIOrder.dominio.modal.Users;
import PedidoPJa.APIOrder.model.UserModal;

public interface IUserService {
	Collection<UserModal> LookAllUsers();
	UserModal FindUser(Long id);
	UserModal EditUser(UserModal usu, long id);
	void Delete(UserModal usu);
	UserModal AddUsu(UserModal newUsu);
}

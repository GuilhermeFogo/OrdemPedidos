package PedidoPJa.APIOrder.service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import PedidoPJa.APIOrder.dominio.exeption.BussinesExeption;
import PedidoPJa.APIOrder.dominio.modal.Demand;
import PedidoPJa.APIOrder.dominio.modal.Users;
import PedidoPJa.APIOrder.model.DemandInputModel;
import PedidoPJa.APIOrder.model.DemandModel;
import PedidoPJa.APIOrder.model.UserModal;
import PedidoPJa.APIOrder.repository.IUsersRepository;
import PedidoPJa.APIOrder.service.interfaces.IUserService;

@Service
public class UserService implements IUserService {

	private IUsersRepository repository;
	
	@Autowired
	private ModelMapper modalmaaper;
	
	@Autowired
    private BCryptPasswordEncoder bcryptEncoder;

	@Autowired
	public UserService(IUsersRepository repository) {
		this.repository = repository;
	}

	@Override
	public Collection<UserModal> LookAllUsers() {
		return toModalCollection(this.repository.findAll());
	}

	@Override
	public UserModal FindUser(Long id) {
		var usu = this.repository.findById(id).orElseThrow(()-> new BussinesExeption("Usuario não encontrado"));
		return toModal(usu);
	}

	@Override
	public UserModal AddUsu(UserModal newUsu) {
		var existUsu = this.repository.findByPassword(newUsu.getPassword());
		if (existUsu != null || !existUsu.equals(newUsu)) {
			throw new BussinesExeption("Já existe um Usuario com a mesma senha");
		}
		String passcifra = bcryptEncoder.encode(newUsu.getPassword());
		newUsu.setPassword(passcifra);
		return toModal(this.repository.save(toEntity(newUsu)));
	}

	@Override
	public UserModal EditUser(UserModal usu, long id) {
		if(this.repository.existsById(id)) {
			var transform = toEntity(usu);
			this.repository.save(transform);
		}
		return null;
	}

	@Override
	public void Delete(UserModal usu) {
		Users myuser = this.repository.findByNameAndPassword(usu.getName(), usu.getName());
		this.repository.delete(myuser);
	}

	private UserModal toModal(Users usuario) {
		return modalmaaper.map(usuario, UserModal.class);
	}

	private Collection<UserModal> toModalCollection(Collection<Users> list) {
		return list.stream().map(usu -> toModal(usu)).collect(Collectors.toList());
	}

	private Users toEntity(UserModal input) {
		return modalmaaper.map(input, Users.class);
	}

}

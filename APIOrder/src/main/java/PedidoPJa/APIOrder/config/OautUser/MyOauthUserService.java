package PedidoPJa.APIOrder.config.OautUser;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import PedidoPJa.APIOrder.dominio.modal.Users;
import PedidoPJa.APIOrder.repository.IUsersRepository;

@Repository
public class MyOauthUserService implements UserDetailsService  {

	@Autowired
	private IUsersRepository repository;
	
	@Autowired
	private BCryptPasswordEncoder bcryptEncoder;
	
	@Override
	public UserDetails loadUserByUsername(String username) {
		   Optional<Users> opt = this.repository.findByName(username);
	        Users user = null;
	        if(opt.isPresent()){
	            user = opt.get();
	        }
	        if (user == null) {
	            throw new UsernameNotFoundException("Usuario nao existe");
	        }
	        return new MyOautUser(user);
	}

}

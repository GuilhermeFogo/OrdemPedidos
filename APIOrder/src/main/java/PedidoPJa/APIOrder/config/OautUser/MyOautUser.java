package PedidoPJa.APIOrder.config.OautUser;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import PedidoPJa.APIOrder.dominio.modal.Users;

public class MyOautUser implements UserDetails {

	private static final long serialVersionUID = -8489053074208206273L;
	
	private Users user;
	
	public MyOautUser(Users user) {
		this.user = user;
	}
	

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

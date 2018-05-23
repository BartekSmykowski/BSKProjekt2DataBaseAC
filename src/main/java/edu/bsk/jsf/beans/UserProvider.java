package edu.bsk.jsf.beans;

import edu.bsk.database.repositories.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.annotation.ManagedBean;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.Collection;

@ManagedBean
@SessionScoped
public class UserProvider implements Serializable
{
	private final UserRepository userRepository;

	@Inject
	public UserProvider(UserRepository userRepository)
	{
		this.userRepository = userRepository;
	}

	public String getUserRole()
	{
		String username = getUsername();
		if(username == null)
			return "";
		Collection<? extends GrantedAuthority> authorities = SecurityContextHolder.getContext().getAuthentication().getAuthorities();
		if(authorities.isEmpty())
			return "";
		return authorities.iterator().next().toString();
	}

	private String getUsername()
	{
		return FacesContext.getCurrentInstance().getExternalContext().getRemoteUser();
	}
}

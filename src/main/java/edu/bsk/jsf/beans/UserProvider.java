package edu.bsk.jsf.beans;

import edu.bsk.database.repositories.UserRepository;

import javax.annotation.ManagedBean;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import java.io.Serializable;

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
		return userRepository.findByNickname(username).getRole();
	}

	private String getUsername()
	{
		return FacesContext.getCurrentInstance().getExternalContext().getRemoteUser();
	}
}

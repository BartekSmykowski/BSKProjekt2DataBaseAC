package edu.bsk.confguration;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

import javax.transaction.Transactional;

import edu.bsk.database.entities.User;
import edu.bsk.database.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
@CustomAuthentication
public class AuthenticationConfiguration implements UserDetailsService
{
	@Autowired
	private UserRepository userRepository;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String nickname) throws UsernameNotFoundException
	{
		User user = userRepository.findByNickname(nickname);
		if(user == null)
			throw new UsernameNotFoundException(nickname);
		Collection<GrantedAuthority> grantedAuthorities = getGrantedAuthorities(user);

		return new org.springframework.security.core.userdetails.User(user.getNickname(), user.getPassword(),
				grantedAuthorities);
	}

	private Collection<GrantedAuthority> getGrantedAuthorities(User user)
	{
		return Collections.singleton(new SimpleGrantedAuthority("ROLE_" + user.getRole()));
	}
}

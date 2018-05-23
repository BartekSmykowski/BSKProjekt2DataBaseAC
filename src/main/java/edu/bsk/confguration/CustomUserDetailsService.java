package edu.bsk.confguration;

import edu.bsk.database.entities.User;
import edu.bsk.database.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;

@Component
@CustomAuthentication
public class CustomUserDetailsService implements UserDetailsService
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
		Collection<GrantedAuthority> authorities = new ArrayList<>();
		//user.getRoles().forEach(role -> authorities.add(new SimpleGrantedAuthority("ROLE_" + role)));
		return authorities;
	}
}

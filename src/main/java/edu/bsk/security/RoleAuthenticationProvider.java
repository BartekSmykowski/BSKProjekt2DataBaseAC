package edu.bsk.security;

import edu.bsk.database.entities.User;
import edu.bsk.database.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;

public class RoleAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private UserRepository userRepository;


    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String name = authentication.getName();
        String password = authentication.getCredentials().toString();
        GrantedAuthority authority = authentication.getAuthorities().iterator().next();
        String authorityString = authority.getAuthority();
        String role = authorityString.substring(authorityString.indexOf("_") + 1);

        User user = userRepository.findUserWithRoles(name);

        if (user.getRoles().contains(role) && user.getPassword().equals(password)) {
            return new UsernamePasswordAuthenticationToken(
                    name, password, authentication.getAuthorities());
        } else {
            throw new BadCredentialsException("User do not have this role " + role);
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(
                LoginPasswordRoleAuthenticationToken.class);
    }

}
